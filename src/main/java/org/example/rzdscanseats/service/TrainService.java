package org.example.rzdscanseats.service;

import lombok.RequiredArgsConstructor;
import org.example.rzdscanseats.entity.Carriage;
import org.example.rzdscanseats.dto.FreePlaceInfoDto;
import org.example.rzdscanseats.entity.Train;
import org.example.rzdscanseats.enums.SeatType;
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

    public List<FreePlaceInfoDto> getFreePlacesInfo(Train train) {
        List<FreePlaceInfoDto> freePlaceInfoDtos = new ArrayList<>();
        for (Carriage carriage : train.getCarriages()) {
            Map<SeatType, Integer> countPlacesMap = seatService.getCountPlacesMap(carriage);
            Map<SeatType, Double> pricePlacesMap = seatService.getPricePlacesMap(carriage);
            freePlaceInfoDtos.add(FreePlaceInfoDto.builder().
                    carriageNumber(carriage.getNumber()).
                    allSeats(carriage.getCountSeats()).
                    countPlacesMap(countPlacesMap).
                    pricePlacesMap(pricePlacesMap).
                    build());
        }
        return freePlaceInfoDtos;
    }

    public void delete(Train train) {
        trainRepository.myDelete(train.getId());
    }
}
