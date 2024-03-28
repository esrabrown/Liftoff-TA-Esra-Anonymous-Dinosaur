package com.cafemanager.cafe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StripePaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StripePaymentApplication.class, args);
    }
}


