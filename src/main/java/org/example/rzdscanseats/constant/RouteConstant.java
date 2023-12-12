package org.example.rzdscanseats.constant;

import java.util.List;

public interface RouteConstant {

    String URL = "https://www.rzd.ru/";

    String CITI_FROM_ID = "direction-from";

    String CITI_TO_ID = "direction-to";

    String DATE_FROM_ID = "datepicker-from";

    String BUTTON_FIND_ROUTE = "//*[@id=\"rzd-search-widget\"]/div[1]/div[2]/a";

    String DROP_DOWN_FROM = "//*[@id=\"rzd-search-widget\"]/div[1]/div[1]/div[1]/div[1]/ul/li[2]";

    String DROP_DOWN_TO = "//*[@id=\"rzd-search-widget\"]/div[1]/div[1]/div[1]/div[2]/ul/li[2]";

    String TRAIN_1 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[1]";
    String TRAIN_2 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[2]";
    String TRAIN_3 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[3]";
    String TRAIN_4 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[4]";
    String TRAIN_5 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[5]";
    String TRAIN_6 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[6]";
    String TRAIN_7 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[7]";
    String TRAIN_8 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[8]";
    String TRAIN_9 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[9]";
    String TRAIN_10 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[10]";

    List<String> TRAINS = List.of(TRAIN_1, TRAIN_2, TRAIN_3, TRAIN_4, TRAIN_5, TRAIN_6, TRAIN_7, TRAIN_8, TRAIN_9, TRAIN_10);

    String TYPE_1 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-railway-service-class-selection-list/div/ui-kit-radio-group/ui-kit-radio-button[1]";
    String TYPE_2 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-railway-service-class-selection-list/div/ui-kit-radio-group/ui-kit-radio-button[2]";
    String TYPE_3 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-railway-service-class-selection-list/div/ui-kit-radio-group/ui-kit-radio-button[3]";
    String TYPE_4 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-railway-service-class-selection-list/div/ui-kit-radio-group/ui-kit-radio-button[4]";
    String TYPE_5 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-railway-service-class-selection-list/div/ui-kit-radio-group/ui-kit-radio-button[5]";

    List<String> CARRIAGE_TYPES = List.of(TYPE_1, TYPE_2, TYPE_3, TYPE_4, TYPE_5);

    String BUTTON_SELECT_CARRIAGE = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-railway-service-class-selection-list/rzd-class-selection-footer/div[2]/div/ui-kit-button/button";

    String BUTTON_ALL_VIEW = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-scheme-coupled-container/div[1]/div[2]/ui-kit-button[1]/button";

    String CARRIAGE_1 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/ul/li[1]/rzd-car-button";
    String CARRIAGE_2 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/ul/li[2]/rzd-car-button";
    String CARRIAGE_3 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/ul/li[3]/rzd-car-button";
    String CARRIAGE_4 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/ul/li[4]/rzd-car-button";
    String CARRIAGE_5 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/ul/li[5]/rzd-car-button";
    String CARRIAGE_6 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/ul/li[6]/rzd-car-button";
    String CARRIAGE_7 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/ul/li[7]/rzd-car-button";
    String CARRIAGE_8 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/ul/li[8]/rzd-car-button";
    String CARRIAGE_9 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/ul/li[9]/rzd-car-button";
    String CARRIAGE_10 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/ul/li[10]/rzd-car-button";
    String CARRIAGE_11 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/ul/li[11]/rzd-car-button";
    String CARRIAGE_12 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/ul/li[12]/rzd-car-button";
    String CARRIAGE_13 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/ul/li[13]/rzd-car-button";
    String CARRIAGE_14 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/ul/li[14]/rzd-car-button";
    String CARRIAGE_15 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/ul/li[15]/rzd-car-button";

    List<String> CARRIAGES = List.of(CARRIAGE_1, CARRIAGE_2, CARRIAGE_3, CARRIAGE_4, CARRIAGE_5, CARRIAGE_6, CARRIAGE_7, CARRIAGE_8, CARRIAGE_9, CARRIAGE_10, CARRIAGE_11, CARRIAGE_12, CARRIAGE_13, CARRIAGE_14, CARRIAGE_15);


}





