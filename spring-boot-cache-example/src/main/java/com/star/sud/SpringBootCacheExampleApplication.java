package com.star.sud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringBootCacheExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCacheExampleApplication.class, args);
	}

}
