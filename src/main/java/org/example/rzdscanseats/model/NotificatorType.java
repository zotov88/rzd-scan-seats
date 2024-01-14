package org.example.rzdscanseats.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NotificatorType {

    BOTTOM("нижнее"),
    ANY("любое"),
    OFF("выключено");

    private final String typeName;

}
