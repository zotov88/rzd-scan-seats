package org.example.rzdscanseats.model;

import lombok.Getter;

@Getter
public enum Type {

    SEAT("Сидячий"),
    PLATSKART("Плацкартный"),
    CUPE("Купе"),
    SV("СВ"),
    LUXURY("Люкс");

    private final String typeName;

    Type(String typeName) {
        this.typeName = typeName;
    }
}
