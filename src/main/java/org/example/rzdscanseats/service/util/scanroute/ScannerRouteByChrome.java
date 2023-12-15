package org.example.rzdscanseats.service.util.scanroute;

import org.example.rzdscanseats.model.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.data.util.TypeScanner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.example.rzdscanseats.constant.RouteConstant.*;

@Component
public final class ScannerRouteByChrome extends ScannerRoute {

    private FirefoxDriver driver;
    private WebElement cityFrom;
    private WebElement cityTo;
    private WebElement when;
    private WebElement findRouteButton;
    private WebElement dropDownFrom;
    private WebElement dropDownTo;
    private WebElement trainElement;
    private WebElement carriageElement;
    private WebElement selectTypeCarriageButton;
    WebElement allViewButton;
    private Route route = new Route();
    private Train train = new Train();

    @Override
    public Route apply(Route tmpRoute) {
//        System.out.println("NAME TRAIN------------ " + tmpRoute.getTrain().getName());
        route = tmpRoute;
        train.setName(route.getTrain().getName());
//        train.setRoute(route);
        ChromeOptions options = new ChromeOptions().addArguments("--headless");
        driver = new FirefoxDriver();
        driver.get(URL);
        initRoute();
        cityFrom.sendKeys(tmpRoute.getCityFrom());
        delay();
        driver.findElement(By.xpath(DROP_DOWN_FROM)).click();
        cityTo.sendKeys(tmpRoute.getCityTo());
        delay();
        driver.findElement(By.xpath(DROP_DOWN_TO)).click();
        when.sendKeys(tmpRoute.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        findRouteButton.click();
        delay();
        selectTrain(tmpRoute);
        delay();
        selectTypeCarriage(tmpRoute);
        delay();
        driver.findElement(By.xpath(BUTTON_SELECT_CARRIAGE)).click();
        delay();
        driver.findElement(By.xpath(BUTTON_ALL_VIEW)).click();
        delay();
        scanCarriages();
        System.out.println("++++++=ROUTE === " + route);
        return route;
    }

    private void scanCarriages() {
        int countCarriages = getCountCarriages();
        for (int i = 0; i < countCarriages; i++) {
            WebElement carriageElement = driver.findElement(By.xpath(CARRIAGES.get(i)));
            carriageElement.click();
            Carriage carriage = initCarriage(carriageElement);
            for (int j = 0; j < carriage.getCountSeats(); j++) {
                WebElement seatElement = driver.findElement(By.xpath(SEATS.get(j)));
                Seat seat = initSeat(seatElement, carriage);
                carriage.getSeats().add(seat);
            }
            train.getCarriages().add(carriage);
        }
        train.setRoute(route);
        route.setTrain(train);
    }

    private Seat initSeat(WebElement seatElement, Carriage carriage) {
        return Seat.builder().
                number(Integer.parseInt(seatElement.getText().split("[ \\[\\]\n]")[1])).
                type(getSeatType(seatElement)).
                price(Double.parseDouble(seatElement.getText().split("[ \\[\\]\n]")[4])).
                carriage(carriage).
                build();
    }

    private SeatType getSeatType(WebElement seatElement) {
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

    private Carriage initCarriage(WebElement carriageElement) {
        return Carriage.builder().
                number(Integer.parseInt(carriageElement.getText().split("[ \n]")[1])).
                type(route.getTrain().getCarriages().get(0).getType()).
                countSeats(Integer.parseInt(carriageElement.getText().split("[ \n]")[2])).
                train(train).
                build();
    }

    private int getCountCarriages() {
        WebElement carriagesElement = driver.findElement(By.xpath(CARRIAGES_ELEMENT));
        String[] arr = carriagesElement.getText().split("\n");
        return (int) Arrays.stream(arr).filter(s -> s.contains("ВАГОН")).count();
    }

    private void selectTrain(Route route) {
        for (String trainXPath : TRAINS) {
            trainElement = driver.findElement(By.xpath(trainXPath));
            if (trainElement.getText().contains(route.getTrain().getName())) {
                driver.executeScript("arguments[0].scrollIntoView();", trainElement);
                trainElement.click();
                break;
            }
        }
    }

    private void selectTypeCarriage(Route route) {
        String type = route.getTrain().getCarriages().get(0).getType().getTypeName();
        for (String carriageType : CARRIAGE_TYPES) {
            carriageElement = driver.findElement(By.xpath(carriageType));
            if (carriageElement.getText().contains(type)) {
                driver.executeScript("arguments[0].scrollIntoView();", carriageElement);
                carriageElement.click();
                break;
            }
        }
    }

    private void initRoute() {
        cityFrom = driver.findElement(By.id(CITI_FROM_ID));
        cityTo = driver.findElement(By.id(CITI_TO_ID));
        when = driver.findElement(By.id(DATE_FROM_ID));
        findRouteButton = driver.findElement(By.xpath(BUTTON_FIND_ROUTE));
    }


    private void delay() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
