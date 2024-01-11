package org.example.rzdscanseats.model;

public enum NotificatorType {

    BOTTOM("нижнее"),
    ANY("любое"),
    OFF("выключено");

    private final String typeName;

    NotificatorType(String typeName) {
        this.typeName = typeName;
    }
}
