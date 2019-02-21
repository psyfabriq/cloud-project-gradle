package ru.psyfabriq.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication(scanBasePackages = {"ru.psyfabriq.library.db","ru.psyfabriq.auth"})
@EnableEurekaClient
public class AppServerAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppServerAuthApplication.class, args);
    }
}
