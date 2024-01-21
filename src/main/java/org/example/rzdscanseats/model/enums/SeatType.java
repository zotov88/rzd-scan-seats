package org.example.rzdscanseats.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SeatType {

    TOP("верхнее"),
    BOTTOM("нижнее"),
    TOP_SIDE("верхнее боковое"),
    BOTTOM_SIDE("нижнее боковое");

    private final String description;
}
