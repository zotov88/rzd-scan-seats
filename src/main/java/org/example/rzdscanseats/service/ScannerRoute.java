package org.example.rzdscanseats.service;

import org.example.rzdscanseats.model.Route;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public abstract class ScannerRoute implements Function<Route, Route> {

}
