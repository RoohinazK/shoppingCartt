package com.mindtree.shooppingCartApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingCartApplication {
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	
		logger.debug("This is a debug message");
		logger.info("This is a info message");
		logger.warn("This is a warn message");
		logger.error("This is a error message");
	
	}
}