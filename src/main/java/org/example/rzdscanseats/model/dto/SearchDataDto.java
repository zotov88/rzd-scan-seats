package org.example.rzdscanseats.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.rzdscanseats.model.enums.CarriageType;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchDataDto {

    private Long userId;

    private String cityFrom;

    private String cityTo;

    private LocalDate date;

    private String trainName;

    private CarriageType carriageType;

}
