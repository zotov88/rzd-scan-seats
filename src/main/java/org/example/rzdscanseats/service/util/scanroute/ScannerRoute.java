package org.example.rzdscanseats.service.util.scanroute;

import org.example.rzdscanseats.model.*;
import org.openqa.selenium.WebElement;

import java.util.function.Function;


public abstract class ScannerRoute implements Function<SearchData, Route> {

    protected Seat initSeat(WebElement seatElement, Carriage carriage) {
        return Seat.builder().
                number(Integer.parseInt(seatElement.getText().split("[ \\[\\]\n]")[1])).
                type(getSeatType(seatElement)).
                price(Double.parseDouble(seatElement.getText().split("[ \\[\\]\n]")[4])).
                carriage(carriage).
                build();
    }

    protected SeatType getSeatType(WebElement seatElement) {
        String[] arr = seatElement.getText().split("[ \\[\\]\n]");
        String typeText = arr.length == 7 ? arr[6] : arr[6] + " " + arr[7];
        SeatType type;
        switch (typeText) {
            case "Нижнее" -> {
                type = SeatType.BOTTOM;
            }
            case "Верхнее" -> {
                type = SeatType.TOP;
            }
            case "Боковое верхнее" -> {
                type = SeatType.TOP_SIDE;
            }
            case "Боковое нижнее" -> {
                type = SeatType.BOTTOM_SIDE;
            }
            default -> type = null;
        }
        return type;
    }

}
