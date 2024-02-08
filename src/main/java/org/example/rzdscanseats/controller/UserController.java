package org.example.rzdscanseats.controller;

import jakarta.security.auth.message.AuthException;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.example.rzdscanseats.model.User;
import org.example.rzdscanseats.service.UserService;
import org.example.rzdscanseats.service.util.checkaccess.CheckAccess;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/profile/{userId}")
    public String profile(@PathVariable Long userId,
                          Model model) throws AuthException {
        CheckAccess.checkAccess(userId);
        model.addAttribute("userForm", userService.getById(userId));
        return "user/profile";
    }

    @GetMapping("/profile/update/{userId}")
    public String update(@PathVariable Long userId,
                         Model model) throws AuthException {
        CheckAccess.checkAccess(userId);
        model.addAttribute("userForm", userService.getById(userId));
        return "user/updateUser";
    }

    @PostMapping("/profile/update")
    public String update(@ModelAttribute("userForm") User userUpdated,
                         BindingResult bindingResult) {
        User emailDuplicated = userService.getByEmail(userUpdated.getEmail().toLowerCase());
        User foundUser = userService.getById(userUpdated.getId());
        if (isNoDuplicateEmail(emailDuplicated, foundUser)) {
            bindingResult.rejectValue("email", "error.email", "Такой email уже существует");
            return "user/updateUser";
        }
        foundUser.setName(userUpdated.getName());
        foundUser.setEmail(userUpdated.getEmail().toLowerCase());
        foundUser.setTgBotToken(userUpdated.getTgBotToken());
        foundUser.setTgChatId(userUpdated.getTgChatId());
        userService.update(foundUser);
        return "redirect:/routes/all/" +
                userService.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
    }

    private static boolean isNoDuplicateEmail(User emailDuplicated, User foundUser) {
        return emailDuplicated != null && !Objects.equals(emailDuplicated.getEmail(), foundUser.getEmail());
    }

    @GetMapping("/remember-password")
    public String rememberPassword() {
        return "user/rememberPassword";
    }

    @PostMapping("/remember-password")
    public String rememberPassword(@ModelAttribute("changePasswordForm") User user) {
        user = userService.getByEmail(user.getEmail().toLowerCase());
        if (Objects.isNull(user)) {
            return "user/notFoundEmail";
        }
        userService.sendChangePasswordEmail(user);
        return "redirect:/login";
    }

    @GetMapping("/change-password")
    public String changePassword(@PathParam(value = "uuid") String uuid,
                                 Model model) {
        model.addAttribute("uuid", uuid);
        if (Objects.isNull(userService.getUserByChangePasswordToken(uuid))) {
            return "user/usedToken";
        }
        return "user/changePassword";
    }

    @PostMapping("/change-password")
    public String changePassword(@PathParam(value = "uuid") String uuid,
                                 @ModelAttribute("changePasswordForm") User user) {
        userService.changePassword(uuid, user.getPassword());
        return "redirect:/logout";
    }

    @GetMapping("/change-password/{userId}")
    public String changePassword(@PathVariable Long userId,
                                 Model model) throws AuthException {
        CheckAccess.checkAccess(userId);
        User user = userService.getById(userId);
        user.setChangePasswordToken(UUID.randomUUID().toString());
        model.addAttribute("uuid", user.getChangePasswordToken());
        userService.update(user);
        return "user/changePassword";
    }
}
