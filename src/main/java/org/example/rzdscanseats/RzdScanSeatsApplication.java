package org.example.rzdscanseats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RzdScanSeatsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RzdScanSeatsApplication.class, args);
    }

}
