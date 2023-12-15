package org.example.rzdscanseats.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum CarriageType {

    SEAT("Сидячий"),
    PLATSKART("Плацкартный"),
    CUPE("Купе"),
    SV("СВ"),
    LUXURY("Люкс");

    private final String typeName;

    CarriageType(String typeName) {
        this.typeName = typeName;
    }
}
