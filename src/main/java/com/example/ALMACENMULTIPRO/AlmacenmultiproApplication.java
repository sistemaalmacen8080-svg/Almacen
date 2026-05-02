package com.example.ALMACENMULTIPRO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AlmacenmultiproApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlmacenmultiproApplication.class, args);
	}

}