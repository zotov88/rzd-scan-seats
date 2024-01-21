package org.example.rzdscanseats.service;

import lombok.RequiredArgsConstructor;
import org.example.rzdscanseats.model.Carriage;
import org.example.rzdscanseats.model.FreePlaceInfo;
import org.example.rzdscanseats.model.Train;
import org.example.rzdscanseats.model.enums.SeatType;
import org.example.rzdscanseats.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TrainService {

    private final TrainRepository trainRepository;
    private final SeatService seatService;

    public List<FreePlaceInfo> getFreePlacesInfo(Train train) {
        List<FreePlaceInfo> freePlaceInfos = new ArrayList<>();
        for (Carriage carriage : train.getCarriages()) {
            Map<SeatType, Integer> countPlacesMap = seatService.getCountPlacesMap(carriage);
            Map<SeatType, Double> pricePlacesMap = seatService.getPricePlacesMap(carriage);
            freePlaceInfos.add(FreePlaceInfo.builder().
                    carriageNumber(carriage.getNumber()).
                    allSeats(carriage.getCountSeats()).
                    countPlacesMap(countPlacesMap).
                    pricePlacesMap(pricePlacesMap).
                    build());
        }
        return freePlaceInfos;
    }

    public void delete(Train train) {
        trainRepository.myDelete(train.getId());
    }
}
