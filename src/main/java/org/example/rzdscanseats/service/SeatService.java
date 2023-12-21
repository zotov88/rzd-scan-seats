package org.example.rzdscanseats.service;

import org.example.rzdscanseats.model.Carriage;
import org.example.rzdscanseats.model.Seat;
import org.example.rzdscanseats.model.SeatType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SeatService {

    public Map<SeatType, Integer> getCountPlacesMap(Carriage carriage) {
        Map<SeatType, Integer> seatMap = new HashMap<>();
        for (Seat seat : carriage.getSeats()) {
            if (seat.getType() != null && !seatMap.containsKey(seat.getType())) {
                seatMap.put(seat.getType(), 0);
            }
            seatMap.put(seat.getType(), seatMap.get(seat.getType()) + 1);
        }
        return seatMap;
    }

    public Map<SeatType, Double> getPricePlacesMap(Carriage carriage) {
        Map<SeatType, Double> priceMap = new HashMap<>();
        for (Seat seat : carriage.getSeats()) {
            if (seat.getType() != null && !priceMap.containsKey(seat.getType())) {
                priceMap.put(seat.getType(), seat.getPrice());
            }
            if (priceMap.size() == SeatType.values().length) {
                break;
            }
        }
        return priceMap;
    }
}
