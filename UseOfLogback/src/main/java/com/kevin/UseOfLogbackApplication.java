package com.kevin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class UseOfLogbackApplication {
	static Logger logger = LoggerFactory.getLogger(UseOfLogbackApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(UseOfLogbackApplication.class, args);
		logger.warn("warn");
		logger.info("infor");
		logger.error("error");
	}

}
