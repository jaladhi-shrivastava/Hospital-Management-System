package com.hms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.hms")
public class HospitalManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalManagementSystemApplication.class, args);
    }
}