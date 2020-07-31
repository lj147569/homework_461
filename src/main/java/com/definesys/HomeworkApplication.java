package com.definesys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.definesys.mpaas","com.definesys"})
public class HomeworkApplication {

    public static void main(String[] args) {

        SpringApplication.run(HomeworkApplication.class, args);
    }

}
