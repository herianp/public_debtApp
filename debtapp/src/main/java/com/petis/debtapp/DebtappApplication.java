package com.petis.debtapp;

import com.petis.debtapp.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication()
public class DebtappApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebtappApplication.class, args);
	}

}
