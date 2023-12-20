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
    private final TrainService trainService;
    private final RouteRepository routeRepository;
    private final ScannerRoute scannerRoute;

    public RouteService(UserService userService,
                        TrainService trainService,
                        RouteRepository routeRepository,
                        ScannerRoute scannerRoute) {
        this.userService = userService;
        this.trainService = trainService;
        this.routeRepository = routeRepository;
        this.scannerRoute = scannerRoute;
    }

    public void create(SearchData data) {
        User user = userService.getById(data.getUserId());
        Route route = scannerRoute.apply(data);
        route.setUser(user);
        routeRepository.save(route);
    }

    public void update(Long routeId) {
        Route route = getById(routeId);
        SearchData data = SearchData.builder().
                cityTo(route.getCityTo()).
                cityFrom(route.getCityFrom()).
                date(route.getDate()).
                trainName(route.getTrain().getName()).
                userId(route.getUser().getId()).
                carriageType(route.getTrain().getCarriages().get(0).getType()).
                build();
        Train oldTrain = route.getTrain();
        route.setTrain(null);
        trainService.delete(oldTrain.getId());
        Train newTrain = scannerRoute.apply(data).getTrain();
        newTrain.setRoute(route);
        route.setTrain(newTrain);
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

    public List<Long> getDistinctByUserId() {
        return routeRepository.getDistinctByUserId();
    }

    public void checkAllRoutes() {
        for (Long userId : getDistinctByUserId()) {
            checkRoutes(getRoutes(userId), userId);
        }
    }

    private List<Route> getRoutes(Long userId) {
        return routeRepository.getRoutesByUserId(userId);
    }

    private void checkRoutes(List<Route> routes, Long userId) {
        for (Route route : routes) {

        }
    }


}
