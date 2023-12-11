package org.example.rzdscanseats.service.util.scanroute;

import org.example.rzdscanseats.model.Route;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

import static org.example.rzdscanseats.constant.RouteConstant.*;

@Component
public final class ScannerRouteByFirefox extends ScannerRoute {

    private FirefoxDriver driver;
    private WebElement cityFrom;
    private WebElement cityTo;
    private WebElement when;
    private WebElement findRouteButton;
    private WebElement cl;
    private WebElement cl2;
    private WebElement train;

    @Override
    public Route apply(Route route) {
        driver = new FirefoxDriver();
        driver.get(URL);
        initRoute();
        cityFrom.sendKeys(route.getCityFrom());
        delay();
        cl = driver.findElement(By.xpath("//*[@id=\"rzd-search-widget\"]/div[1]/div[1]/div[1]/div[1]/ul/li[2]"));
        cl.click();
        cityTo.sendKeys(route.getCityTo());
        delay();
        cl2 = driver.findElement(By.xpath("//*[@id=\"rzd-search-widget\"]/div[1]/div[1]/div[1]/div[2]/ul/li[2]"));
        cl2.click();
        when.sendKeys(route.getDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        findRouteButton.click();
        delay();
        findTrain(route);
        delay();

        return null;
    }

    private void findTrain(Route route) {
        int i = 1;
        train = driver.findElement(By.xpath("/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[\" + i + \"]"));
        while (!train.getText().contains(route.getTrain().getName())) {
            i++;
            train = driver.findElement(By.xpath("/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[" + i + "]"));
        }
        driver.executeScript("arguments[0].scrollIntoView();", train);
        train.click();
    }

    private void initRoute() {
        cityFrom = driver.findElement(By.id(CITI_FROM_ID));
        cityTo = driver.findElement(By.id(CITI_TO_ID));
        when = driver.findElement(By.id(DATE_FROM_ID));
        findRouteButton = driver.findElement(By.xpath(BUTTON_FIND_ROUTE));
    }


    private void delay() {
        try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
