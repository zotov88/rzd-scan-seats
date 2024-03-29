package org.example.rzdscanseats.service.util.scanroute;

import org.example.rzdscanseats.entity.Carriage;
import org.example.rzdscanseats.entity.Route;
import org.example.rzdscanseats.entity.Seat;
import org.example.rzdscanseats.entity.Train;
import org.example.rzdscanseats.dto.SearchDataDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.example.rzdscanseats.constant.RouteConstant.*;

@Component
public final class ScannerRouteByFirefox extends ScannerRoute {

    private ChromeDriver driver;

    @Override
    public Route apply(SearchDataDto data) {
        Carriage carriage = Carriage.builder().type(data.getCarriageType()).build();
        Train train = Train.builder().name(data.getTrainName()).build();
        train.getCarriages().add(carriage);
        Route route = Route.builder().cityFrom(data.getCityFrom()).cityTo(data.getCityTo()).date(data.getDate()).build();
        route.setTrain(train);
        driver = new ChromeDriver();
        driver.get(URL);
        driver.findElement(By.id(CITI_FROM_ID)).sendKeys(route.getCityFrom());
        delay(3);
        driver.findElement(By.xpath(DROP_DOWN_FROM)).click();
        driver.findElement(By.id(CITI_TO_ID)).sendKeys(route.getCityTo());
        delay(3);
        driver.findElement(By.xpath(DROP_DOWN_TO)).click();
        driver.findElement(By.id(DATE_FROM_ID)).sendKeys(route.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        driver.findElement(By.xpath(BUTTON_FIND_ROUTE)).click();
        delay(4);
        selectTrain(route);
        delay(5);
        selectTypeCarriage(route);
        delay(3);
        driver.findElement(By.xpath(BUTTON_SELECT_CARRIAGE)).click();
        delay(3);
        driver.findElement(By.xpath(BUTTON_ALL_VIEW)).click();
        delay(3);
        scanCarriages(route);
        driver.close();
        return route;
    }

    private void scanCarriages(Route route) {
        Train train = new Train();
        train.setName(route.getTrain().getName());
        int countCarriages = getCountCarriages();
        for (int i = 0; i < countCarriages; i++) {
            WebElement carriageElement = driver.findElement(By.xpath(CARRIAGES.get(i)));
            carriageElement.click();
            Carriage carriage = initCarriage(carriageElement, route, train);
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

    private Carriage initCarriage(WebElement carriageElement, Route route, Train train) {
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
            WebElement trainElement = driver.findElement(By.xpath(trainXPath));
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
            WebElement carriageElement = driver.findElement(By.xpath(carriageType));
            if (carriageElement.getText().contains(type)) {
                driver.executeScript("arguments[0].scrollIntoView();", carriageElement);
                carriageElement.click();
                break;
            }
        }
    }

    private void delay(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
