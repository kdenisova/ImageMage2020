package com.imagemage.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication springApp = new SpringApplication(WebApplication.class);
        springApp.run(args);
    }
}
