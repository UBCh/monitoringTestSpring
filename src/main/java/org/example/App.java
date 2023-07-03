package org.example;

import org.example.config.AppConfig;
import org.example.entitie.Customer;
import org.example.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class App {

    public static void main(String[] args) throws SQLException {


	ConfigurableApplicationContext run = SpringApplication.run(AppConfig.class, args);
	CustomerService bean = run.getBean(CustomerService.class);
	Customer customer = bean.get(5L);
	System.out.println(customer);

    }
}
