package org.example.rzdscanseats.service;

import org.example.rzdscanseats.model.Route;
import org.example.rzdscanseats.repository.RouteRepository;
import org.example.rzdscanseats.service.util.scanroute.ScannerRoute;
import org.openqa.selenium.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final ScannerRoute scannerRoute;

    public RouteService(RouteRepository routeRepository,
                        ScannerRoute scannerRoute) {
        this.routeRepository = routeRepository;
        this.scannerRoute = scannerRoute;
    }

    public void create(Route route) {
        routeRepository.save(scannerRoute.apply(route));
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
