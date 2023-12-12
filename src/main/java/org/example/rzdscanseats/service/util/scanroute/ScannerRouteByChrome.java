package org.example.rzdscanseats.service.util.scanroute;

import org.example.rzdscanseats.model.Route;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

import static org.example.rzdscanseats.constant.RouteConstant.*;

@Component
public final class ScannerRouteByChrome extends ScannerRoute {

    private ChromeDriver driver;
    private WebElement cityFrom;
    private WebElement cityTo;
    private WebElement when;
    private WebElement findRouteButton;
    private WebElement dropDownFrom;
    private WebElement dropDownTo;
    private WebElement train;
    private WebElement carriage;
    private WebElement selectTypeCarriageButton;
    WebElement allViewButton;

    @Override
    public Route apply(Route route) {
        ChromeOptions options = new ChromeOptions().addArguments("--headless");
        driver = new ChromeDriver();
        driver.get(URL);
        initRoute();
        cityFrom.sendKeys(route.getCityFrom());
        delay();
        driver.findElement(By.xpath(DROP_DOWN_FROM)).click();
        cityTo.sendKeys(route.getCityTo());
        delay();
        driver.findElement(By.xpath(DROP_DOWN_TO)).click();
        when.sendKeys(route.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        findRouteButton.click();
        delay();
        selectTrain(route);
        delay();
        selectTypeCarriage(route);
        delay();
        driver.findElement(By.xpath(BUTTON_SELECT_CARRIAGE)).click();
        delay();
        driver.findElement(By.xpath(BUTTON_ALL_VIEW)).click();
        scanCarriages(route);
        return null;
    }

    private void scanCarriages(Route route) {

    }

    private void selectTrain(Route route) {
        for (String trainXPath : TRAINS) {
            train = driver.findElement(By.xpath(trainXPath));
            if (train.getText().contains(route.getTrain().getName())) {
                driver.executeScript("arguments[0].scrollIntoView();", train);
                train.click();
                break;
            }
        }
    }

    private void selectTypeCarriage(Route route) {
        String type = route.getTrain().getCarriages().get(0).getType().getTypeName();
        for (String carriageType : CARRIAGE_TYPES) {
            carriage = driver.findElement(By.xpath(carriageType));
            if (carriage.getText().contains(type)) {
                driver.executeScript("arguments[0].scrollIntoView();", carriage);
                carriage.click();
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
