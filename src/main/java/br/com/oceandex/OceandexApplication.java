package br.com.oceandex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OceandexApplication {

	public static void main(String[] args) {
		SpringApplication.run(OceandexApplication.class, args);
	}

}
