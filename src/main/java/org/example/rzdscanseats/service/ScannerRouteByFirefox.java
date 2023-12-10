package org.example.rzdscanseats.service;

import org.example.rzdscanseats.model.Route;
import org.springframework.stereotype.Component;

@Component
public final class ScannerRouteByFirefox extends ScannerRoute {

    @Override
    public Route apply(Route route) {
        return null;
    }
}
