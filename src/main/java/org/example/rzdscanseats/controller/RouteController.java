package org.example.rzdscanseats.controller;

import org.example.rzdscanseats.model.*;
import org.example.rzdscanseats.service.CarriageService;
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
    private final CarriageService carriageService;
    private final UserService userService;

    public RouteController(RouteService routeService,
                           TrainService trainService,
                           CarriageService carriageService,
                           UserService userService) {
        this.routeService = routeService;
        this.trainService = trainService;
        this.carriageService = carriageService;
        this.userService = userService;
    }

    @GetMapping("/add/{userId}")
    public String add(@PathVariable String userId,
                      Model model) {
        model.addAttribute("searchDataModel", new SearchData());
//        model.addAttribute("trainModel", new Train());
//        model.addAttribute("carriageModel", new Carriage());
        model.addAttribute("typeCarriage", CarriageType.values());
        return "routes/add";
    }

    @PostMapping("/add/{userId}")
    public String add(@PathVariable Long userId,
                      @ModelAttribute("searchDataModel") SearchData searchData) {
//        tmpTrain.getCarriages().add(tmpCarriage);
//        tmpRoute.setTrain(tmpTrain);
//        tmpRoute.setUser(userService.getById(Long.valueOf(userId)));
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
        Route route = routeService.getById(routeId);
        SearchData data = SearchData.builder().
                cityTo(route.getCityTo()).
                cityFrom(route.getCityFrom()).
                date(route.getDate()).
                trainName(route.getTrain().getName()).
                userId(route.getUser().getId()).
                carriageType(route.getTrain().getCarriages().get(0).getType()).
                build();
        Train train = route.getTrain();
        route.setTrain(null);
        routeService.update(route);
        trainService.delete(train.getId());
        routeService.update(data, route);
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
}
