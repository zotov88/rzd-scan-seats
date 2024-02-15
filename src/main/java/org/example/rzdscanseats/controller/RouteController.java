package org.example.rzdscanseats.controller;

import lombok.RequiredArgsConstructor;
import org.example.rzdscanseats.dto.FreePlaceInfoDto;
import org.example.rzdscanseats.entity.Route;
import org.example.rzdscanseats.dto.SearchDataDto;
import org.example.rzdscanseats.enums.CarriageType;
import org.example.rzdscanseats.enums.NotificatorType;
import org.example.rzdscanseats.service.RouteService;
import org.example.rzdscanseats.service.TrainService;
import org.example.rzdscanseats.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.example.rzdscanseats.constant.Path.REDIRECT_ROUTES_ALL;

@Controller
@RequiredArgsConstructor
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final TrainService trainService;
    private final UserService userService;

    @GetMapping("/add/{userId}")
    public String add(@PathVariable String userId,
                      Model model) {
        model.addAttribute("searchDataModel", new SearchDataDto());
        model.addAttribute("typeCarriage", CarriageType.values());
        return "routes/add";
    }

    @PostMapping("/add/{userId}")
    public String add(@PathVariable Long userId,
                      @ModelAttribute("searchDataModel") SearchDataDto searchDataDto) {
        searchDataDto.setUserId(userId);
        routeService.create(searchDataDto);
        return REDIRECT_ROUTES_ALL + userId;
    }

    @GetMapping("/all/{userId}")
    public String all(@PathVariable Long userId,
                      Model model) {
        model.addAttribute("routes", routeService.getRoutesByUserId(userId));
        return "routes/all";
    }

    @GetMapping("/update/{routeId}")
    public String update(@PathVariable Long routeId) {
        routeService.update(routeId);
        return REDIRECT_ROUTES_ALL +
                userService.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
    }

    @GetMapping("/delete/{routeId}")
    public String delete(@PathVariable Long routeId) {
        routeService.delete(routeId);
        return REDIRECT_ROUTES_ALL +
                userService.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
    }

    @GetMapping("/details/{routeId}")
    public String details(@PathVariable Long routeId,
                          Model model) {
        Route route = routeService.getById(routeId);
        List<FreePlaceInfoDto> freePlaceInfoDtos = trainService.getFreePlacesInfo(route.getTrain());
        model.addAttribute("freePlaceInfos", freePlaceInfoDtos);
        return "routes/details";
    }

    @GetMapping("/checkall")
    public String checkAll() {
        routeService.checkAllRoutes();
        return REDIRECT_ROUTES_ALL +
                userService.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
    }

    @GetMapping("/notification/{routeId}")
    public String notificationOptions(@PathVariable Long routeId,
                                      Model model) {
        model.addAttribute("typeNotification", NotificatorType.values());
        model.addAttribute("route", routeService.getById(routeId));
        return "routes/notification";
    }

    @PostMapping("/notification/update/{routeId}")
    public String notificationUpdate(@ModelAttribute("typeNotification") Route routeTN,
                                     @PathVariable Long routeId) {
        Route route = routeService.getById(routeId);
        route.setNotificatorType(routeTN.getNotificatorType());
        routeService.updateEnt(route);
        return REDIRECT_ROUTES_ALL +
                userService.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
    }
}
