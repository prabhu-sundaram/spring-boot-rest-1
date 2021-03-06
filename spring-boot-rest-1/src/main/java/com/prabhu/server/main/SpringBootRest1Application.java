package com.prabhu.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.prabhu.beans.Employee;

@SpringBootApplication(scanBasePackages = {"com.prabhu"})
public class SpringBootRest1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRest1Application.class, args);

	}

}
