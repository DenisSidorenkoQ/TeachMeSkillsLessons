package com.exmaple.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.exmaple.springboot.client")
public class UsersApplication {
    public static void main(final String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

}
