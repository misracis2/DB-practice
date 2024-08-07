package org.example.mysqlpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class MySqlPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySqlPracticeApplication.class, args);
	}

}
