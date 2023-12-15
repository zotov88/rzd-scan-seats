package org.example.rzdscanseats.controller;

import org.example.rzdscanseats.model.Carriage;
import org.example.rzdscanseats.model.CarriageType;
import org.example.rzdscanseats.model.Route;
import org.example.rzdscanseats.model.Train;
import org.example.rzdscanseats.service.RouteService;
import org.example.rzdscanseats.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final UserService userService;

    public RouteController(RouteService routeService, UserService userService) {
        this.routeService = routeService;
        this.userService = userService;
    }

    @GetMapping("/add/{userId}")
    public String add(@PathVariable String userId,
                      Model model) {
        model.addAttribute("routeModel", new Route());
        model.addAttribute("trainModel", new Train());
        model.addAttribute("carriageModel", new Carriage());
        model.addAttribute("typeCarriage", CarriageType.values());
        return "routes/add";
    }

    @PostMapping("/add/{userId}")
    public String add(@PathVariable String userId,
                      @ModelAttribute("routeModel") Route tmpRoute,
                      @ModelAttribute("trainModel") Train tmpTrain,
                      @ModelAttribute("carriageModel") Carriage tmpCarriage) {
        tmpTrain.getCarriages().add(tmpCarriage);
        tmpRoute.setTrain(tmpTrain);
        tmpRoute.setUser(userService.getById(Long.valueOf(userId)));
        routeService.create(tmpRoute);
        return "redirect:/routes/all/" + userId;
    }

    @GetMapping("/all/{userId}")
    public String all(@PathVariable Long userId, Model model) {
        List<Route> routes = routeService.getRoutesByUserId(userId);
        model.addAttribute("routes", routes);
        return "routes/all";
    }

    @GetMapping("/delete/{routeId}")
    public String all(@PathVariable Long routeId) {
        routeService.delete(routeId);
        return "redirect:/routes/all/" +
                userService.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
    }
}
