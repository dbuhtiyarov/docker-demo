package com.example.demo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class DemoApplication {

	static Logger log = Logger.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(DemoApplication.class, args);
		log.warn("Application Is Bad");
	}
}
