package com.ibreath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class IbreathApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbreathApplication.class, args);
	}
}
