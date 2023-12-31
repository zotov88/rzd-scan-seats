package org.example.rzdscanseats.service.util.checkaccess;

import jakarta.security.auth.message.AuthException;
import org.example.rzdscanseats.constant.Errors;
import org.example.rzdscanseats.service.userdetails.CustomUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class CheckAccess {

    public static void checkAccess(final Long id) throws AuthException {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!id.equals(customUserDetails.getUserId()) &&
                !customUserDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
            throw new AuthException(HttpStatus.FORBIDDEN + ": " + Errors.Users.USER_FORBIDDEN_ERROR);
        }
    }
}
