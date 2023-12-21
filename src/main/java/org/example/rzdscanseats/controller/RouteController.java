package org.example.rzdscanseats.controller;

import org.example.rzdscanseats.model.CarriageType;
import org.example.rzdscanseats.model.FreePlaceInfo;
import org.example.rzdscanseats.model.Route;
import org.example.rzdscanseats.model.SearchData;
import org.example.rzdscanseats.service.RouteService;
import org.example.rzdscanseats.service.TrainService;
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
    private final TrainService trainService;
    private final UserService userService;

    public RouteController(RouteService routeService,
                           TrainService trainService,
                           UserService userService) {
        this.routeService = routeService;
        this.trainService = trainService;
        this.userService = userService;
    }

    @GetMapping("/add/{userId}")
    public String add(@PathVariable String userId,
                      Model model) {
        model.addAttribute("searchDataModel", new SearchData());
        model.addAttribute("typeCarriage", CarriageType.values());
        return "routes/add";
    }

    @PostMapping("/add/{userId}")
    public String add(@PathVariable Long userId,
                      @ModelAttribute("searchDataModel") SearchData searchData) {
        searchData.setUserId(userId);
        routeService.create(searchData);
        return "redirect:/routes/all/" + userId;
    }

    @GetMapping("/all/{userId}")
    public String all(@PathVariable Long userId, Model model) {
        List<Route> routes = routeService.getRoutesByUserId(userId);
        model.addAttribute("routes", routes);
        return "routes/all";
    }

    @GetMapping("/update/{routeId}")
    public String update(@PathVariable Long routeId) {
        routeService.update(routeId);
        return "redirect:/routes/all/" +
                userService.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
    }

    @GetMapping("/delete/{routeId}")
    public String delete(@PathVariable Long routeId) {
        routeService.delete(routeId);
        return "redirect:/routes/all/" +
                userService.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
    }

    @GetMapping("/details/{routeId}")
    public String details(@PathVariable Long routeId, Model model) {
        Route route = routeService.getById(routeId);
        List<FreePlaceInfo> freePlaceInfos = trainService.getFreePlacesInfo(route.getTrain());
        model.addAttribute("freePlaceInfos", freePlaceInfos);
        return "routes/details";
    }

    @GetMapping("/checkall")
    public String checkAll() {
        routeService.checkAllRoutes();
        return "redirect:/routes/all/" +
                userService.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
    }

}
