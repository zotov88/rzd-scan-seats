package org.example.rzdscanseats.service;

import jakarta.transaction.Transactional;
import org.example.rzdscanseats.model.*;
import org.example.rzdscanseats.repository.RouteRepository;
import org.example.rzdscanseats.repository.TrainRepository;
import org.example.rzdscanseats.service.util.notification.SenderNotifications;
import org.example.rzdscanseats.service.util.scanroute.ScannerRoute;
import org.openqa.selenium.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RouteService {

    private final UserService userService;
    private final TrainService trainService;
    private final RouteRepository routeRepository;
    private final ScannerRoute scannerRoute;
    private final SenderNotifications senderNotifications;
    private final TrainRepository trainRepository;

    public RouteService(UserService userService,
                        TrainService trainService,
                        RouteRepository routeRepository,
                        ScannerRoute scannerRoute,
                        SenderNotifications senderNotifications, TrainRepository trainRepository) {
        this.userService = userService;
        this.trainService = trainService;
        this.routeRepository = routeRepository;
        this.scannerRoute = scannerRoute;
        this.senderNotifications = senderNotifications;
        this.trainRepository = trainRepository;
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
        trainService.delete(oldTrain);
//        trainRepository.delete(oldTrain);
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
            checkRoutes(getRoutes(userId));
        }
    }

    private List<Route> getRoutes(Long userId) {
        return routeRepository.getRoutesByUserId(userId);
    }

    private void checkRoutes(List<Route> routes) {
        for (Route route : routes) {
            update(route.getId());
            senderNotifications.sendAll(userService.getById(route.getUser().getId()), createMessage(route));
        }
    }

    private String createMessage(Route route) {
        Map<SeatType, Integer> seatInfo = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append("Поезд ").append(route.getTrain().getName()).
                append(" ").append(route.getDate()).append("\n");
        for (FreePlaceInfo placeInfo : trainService.getFreePlacesInfo(route.getTrain())) {
            for (SeatType type : placeInfo.getCountPlacesMap().keySet()) {
                if (!seatInfo.containsKey(type)) {
                    seatInfo.put(type, 0);
                }
                seatInfo.put(type, placeInfo.getCountPlacesMap().get(type) + seatInfo.get(type));
            }
        }
        for (SeatType type : seatInfo.keySet()) {
            sb.append(type.getDescription()).append(": ").append(seatInfo.get(type)).append("\n");
        }
        return sb.toString();
    }


}
