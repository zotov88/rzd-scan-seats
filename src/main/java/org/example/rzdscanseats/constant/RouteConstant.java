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

//    String TRAIN_1 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[1]";
//    String TRAIN_2 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[2]";
//    String TRAIN_3 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[3]";
//    String TRAIN_4 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[4]";
//    String TRAIN_5 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[5]";
//    String TRAIN_6 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[6]";
//    String TRAIN_7 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[7]";
//    String TRAIN_8 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[8]";
//    String TRAIN_9 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[9]";
//    String TRAIN_10 = "/html/body/rzd-app/div/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[10]";

    String TRAIN_1 = "/html/body/rzd-app/main/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[1]/div/div";
    String TRAIN_2 = "/html/body/rzd-app/main/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[2]/div/div";
    String TRAIN_3 = "/html/body/rzd-app/main/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[3]/div/div";
    String TRAIN_4 = "/html/body/rzd-app/main/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[4]/div/div";
    String TRAIN_5 = "/html/body/rzd-app/main/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[5]/div/div";
    String TRAIN_6 = "/html/body/rzd-app/main/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[6]/div/div";
    String TRAIN_7 = "/html/body/rzd-app/main/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[7]/div/div";
    String TRAIN_8 = "/html/body/rzd-app/main/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[8]/div/div";
    String TRAIN_9 = "/html/body/rzd-app/main/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[9]/div/div";
    String TRAIN_10 = "/html/body/rzd-app/main/div/rzd-search-results/div/div/rzd-base-result-theme/div/div/div[2]/rzd-search-results-card-list/div/rzd-search-results-card-railway-flat-card[10]/div/div";

    List<String> TRAINS = List.of(TRAIN_1, TRAIN_2, TRAIN_3, TRAIN_4, TRAIN_5, TRAIN_6, TRAIN_7, TRAIN_8, TRAIN_9, TRAIN_10);

    String TYPE_1 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-railway-service-class-selection-list/div/ui-kit-radio-group/ui-kit-radio-button[1]";
    String TYPE_2 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-railway-service-class-selection-list/div/ui-kit-radio-group/ui-kit-radio-button[2]";
    String TYPE_3 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-railway-service-class-selection-list/div/ui-kit-radio-group/ui-kit-radio-button[3]";
    String TYPE_4 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-railway-service-class-selection-list/div/ui-kit-radio-group/ui-kit-radio-button[4]";
    String TYPE_5 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-railway-service-class-selection-list/div/ui-kit-radio-group/ui-kit-radio-button[5]";

    List<String> CARRIAGE_TYPES = List.of(TYPE_1, TYPE_2, TYPE_3, TYPE_4, TYPE_5);

    String BUTTON_SELECT_CARRIAGE = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-railway-service-class-selection-list/rzd-class-selection-footer/div[2]/div/ui-kit-button/button";

    String BUTTON_ALL_VIEW = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-scheme-coupled-container/div[1]/div[2]/ui-kit-button[1]/button";

    String CARRIAGES_ELEMENT = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/ul";

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

    String SEAT_1 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[1]/div";
    String SEAT_2 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[2]/div";
    String SEAT_3 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[3]/div";
    String SEAT_4 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[4]/div";
    String SEAT_5 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[5]/div";
    String SEAT_6 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[6]/div";
    String SEAT_7 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[7]/div";
    String SEAT_8 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[8]/div";
    String SEAT_9 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[9]/div";
    String SEAT_10 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[10]/div";
    String SEAT_11 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[11]/div";
    String SEAT_12 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[12]/div";
    String SEAT_13 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[13]/div";
    String SEAT_14 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[14]/div";
    String SEAT_15 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[15]/div";
    String SEAT_16 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[16]/div";
    String SEAT_17 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[17]/div";
    String SEAT_18 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[18]/div";
    String SEAT_19 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[19]/div";
    String SEAT_20 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[20]/div";
    String SEAT_21 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[21]/div";
    String SEAT_22 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[22]/div";
    String SEAT_23 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[23]/div";
    String SEAT_24 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[24]/div";
    String SEAT_25 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[25]/div";
    String SEAT_26 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[26]/div";
    String SEAT_27 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[27]/div";
    String SEAT_28 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[28]/div";
    String SEAT_29 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[29]/div";
    String SEAT_30 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[30]/div";
    String SEAT_31 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[31]/div";
    String SEAT_32 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[32]/div";
    String SEAT_33 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[33]/div";
    String SEAT_34 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[34]/div";
    String SEAT_35 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[35]/div";
    String SEAT_36 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[36]/div";
    String SEAT_37 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[37]/div";
    String SEAT_38 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[38]/div";
    String SEAT_39 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[39]/div";
    String SEAT_40 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[40]/div";
    String SEAT_41 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[41]/div";
    String SEAT_42 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[42]/div";
    String SEAT_43 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[43]/div";
    String SEAT_44 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[44]/div";
    String SEAT_45 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[45]/div";
    String SEAT_46 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[46]/div";
    String SEAT_47 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[47]/div";
    String SEAT_48 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[48]/div";
    String SEAT_49 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[49]/div";
    String SEAT_50 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[50]/div";
    String SEAT_51 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[51]/div";
    String SEAT_52 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[52]/div";
    String SEAT_53 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[53]/div";
    String SEAT_54 = "/html/body/rzd-app/div/div/rzd-trip-component/rzd-booking-rail-container/div/div[2]/rzd-seats-rail-container/rzd-seats-scheme-container/div/rzd-car-seats-list-container/ul/li[54]/div";

    List<String> SEATS = List.of(SEAT_1, SEAT_2, SEAT_3, SEAT_4, SEAT_5, SEAT_6, SEAT_7, SEAT_8, SEAT_9, SEAT_10,
            SEAT_11, SEAT_12, SEAT_13, SEAT_14, SEAT_15, SEAT_16, SEAT_17, SEAT_18, SEAT_19, SEAT_20, SEAT_21, SEAT_22,
            SEAT_23, SEAT_24, SEAT_25, SEAT_26, SEAT_27, SEAT_28, SEAT_29, SEAT_30, SEAT_31, SEAT_32, SEAT_33, SEAT_34,
            SEAT_35, SEAT_36, SEAT_37, SEAT_38, SEAT_39, SEAT_40, SEAT_41, SEAT_42, SEAT_43, SEAT_44, SEAT_45, SEAT_46,
            SEAT_47, SEAT_48, SEAT_49, SEAT_50, SEAT_51, SEAT_52, SEAT_53, SEAT_54);

}





