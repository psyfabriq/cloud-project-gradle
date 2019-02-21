package ru.psyfabriq.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"ru.psyfabriq.library.db","ru.psyfabriq.enterprise"})
@EnableEurekaClient
public class AppResourceServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppResourceServerApplication.class, args);
    }
}
