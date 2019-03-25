package com.exame.marilia.ml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MlApplication.class, args);
	}

}
