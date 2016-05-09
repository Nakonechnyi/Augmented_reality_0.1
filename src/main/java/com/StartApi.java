package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @autor A_Nakonechnyi
 * @date 25.04.2016.
 */
@SpringBootApplication
@EnableWebMvc
public class StartApi {
    public static void main(String[] args) {
        SpringApplication.run(StartApi.class, args);
    }
}
