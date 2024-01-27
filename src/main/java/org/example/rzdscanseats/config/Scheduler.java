package org.example.rzdscanseats.config;

import org.example.rzdscanseats.service.RouteService;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    private final RouteService routeService;

    public Scheduler(RouteService routeService) {
        this.routeService = routeService;
    }

//    @Scheduled(cron = "0 0 9-21/3 * * *")
//    @Scheduled(cron = "0 * * * * *")

    public void updateRouteListAllUsers() {
        routeService.checkAllRoutes();
    }
}
