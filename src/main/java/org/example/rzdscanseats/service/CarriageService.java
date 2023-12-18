package org.example.rzdscanseats.service;

import org.example.rzdscanseats.repository.CarriageRepository;
import org.springframework.stereotype.Service;

@Service
public class CarriageService {

    private final CarriageRepository carriageRepository;

    public CarriageService(CarriageRepository carriageRepository) {
        this.carriageRepository = carriageRepository;
    }
}
