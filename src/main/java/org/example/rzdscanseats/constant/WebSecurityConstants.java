package org.example.rzdscanseats.constant;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class WebSecurityConstants {

    public List<String> RESOURCES_WHITE_LIST = List.of
            (
                    "/resources/**",
                    "/static/**",
                    "/js/**",
                    "/images/**",
                    "/css/**",
                    "/registration",
                    "/users/remember-password",
                    "/users/change-password",
                    "/"
            );
    public List<String> AUTH_LIST = List.of
            (
                    "/routes/**"
            );

}
