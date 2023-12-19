package org.example.rzdscanseats.service;

import org.example.rzdscanseats.model.Route;
import org.example.rzdscanseats.model.SearchData;
import org.example.rzdscanseats.model.Train;
import org.example.rzdscanseats.model.User;
import org.example.rzdscanseats.repository.RouteRepository;
import org.example.rzdscanseats.service.util.scanroute.ScannerRoute;
import org.openqa.selenium.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final UserService userService;
    private final RouteRepository routeRepository;
    private final TrainService trainService;
    private final ScannerRoute scannerRoute;

    public RouteService(UserService userService,
                        RouteRepository routeRepository,
                        TrainService trainService,
                        ScannerRoute scannerRoute) {
        this.userService = userService;
        this.routeRepository = routeRepository;
        this.trainService = trainService;
        this.scannerRoute = scannerRoute;
    }

    public void create(SearchData data) {
        User user = userService.getById(data.getUserId());
        Route route = scannerRoute.apply(data);
        route.setUser(user);
        routeRepository.save(route);
    }

    public void update(Route route) {
        routeRepository.save(route);
    }

    public void update(SearchData data, Route route) {
        Train train = scannerRoute.apply(data).getTrain();
        train.setRoute(route);
        route.setTrain(train);
        routeRepository.save(route);
    }

    public List<Route> getRoutesByUserId(Long userId) {
        return routeRepository.getRoutesByUserId(userId);
    }

    public Route getById(Long routeId) {
        return routeRepository.findById(routeId).
                orElseThrow(() -> new NotFoundException("Нет данных с id " + routeId));
    }

    public void delete(Long routeId) {
        routeRepository.deleteById(routeId);
    }
}
