package org.example.rzdscanseats.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchData {

    private Long userId;

    private String cityFrom;

    private String cityTo;

    private LocalDate date;

    private String trainName;

    private CarriageType carriageType;

}
