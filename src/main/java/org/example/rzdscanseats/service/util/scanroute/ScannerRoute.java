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
        String seatInfo = seatElement.getText();
        SeatType type = null;
        if (seatInfo.contains("Боковое верхнее")) {
            type = SeatType.TOP_SIDE;
        } else if (seatInfo.contains("Боковое нижнее")) {
            type = SeatType.BOTTOM_SIDE;
        } else if (seatInfo.contains("Нижнее") || seatInfo.contains("Последнее купе (отсек), нижнее")) {
            type = SeatType.BOTTOM;
        } else if (seatInfo.contains("Верхнее")) {
            type = SeatType.TOP;
        }
        return type;
    }

}
