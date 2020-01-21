package com.manoj.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories /// we are using Jpa
public class CmsApplication {

	public static void main(String[] args) {

		SpringApplication.run(CmsApplication.class, args);
		System.out.println("HIII");
	}

}
