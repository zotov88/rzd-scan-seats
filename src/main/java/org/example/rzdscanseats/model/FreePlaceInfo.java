package org.example.rzdscanseats.model;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class FreePlaceInfo {

    private int carriageNumber;

    private int allSeats;

    @Builder.Default
    private Map<SeatType, Integer> countPlacesMap = new HashMap<>();

    @Builder.Default
    private Map<SeatType, Double> pricePlacesMap = new HashMap<>();
}
