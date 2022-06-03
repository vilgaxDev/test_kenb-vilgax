package com.bank.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Kenb.vilgax
 *
 */
@SpringBootApplication
@ComponentScan("com.bank")
@EntityScan({"com.bank.entity"})
@EnableJpaRepositories(basePackages = "com.bank.repo")
public class BankAtmApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAtmApplication.class, args);
		System.out.println("\n\nHello..I am started!");
	}
}


