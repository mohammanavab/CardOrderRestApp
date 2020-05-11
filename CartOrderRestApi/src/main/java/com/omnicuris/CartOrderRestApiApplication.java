package com.omnicuris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.omnicuris"})
public class CartOrderRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartOrderRestApiApplication.class, args);
	}

}
