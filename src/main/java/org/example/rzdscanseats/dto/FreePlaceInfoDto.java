package org.example.rzdscanseats.dto;

import lombok.Builder;
import lombok.Data;
import org.example.rzdscanseats.enums.SeatType;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class FreePlaceInfoDto {

    private int carriageNumber;

    private int allSeats;

    @Builder.Default
    private Map<SeatType, Integer> countPlacesMap = new HashMap<>();

    @Builder.Default
    private Map<SeatType, Double> pricePlacesMap = new HashMap<>();
}
