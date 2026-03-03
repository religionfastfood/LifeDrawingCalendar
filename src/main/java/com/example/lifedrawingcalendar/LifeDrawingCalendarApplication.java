package com.example.lifedrawingcalendar;

import net.datafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LifeDrawingCalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifeDrawingCalendarApplication.class, args);
    }

    @Bean
    public Faker faker() { return new Faker(); }

}
