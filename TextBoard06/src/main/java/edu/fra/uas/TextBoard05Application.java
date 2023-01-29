package edu.fra.uas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("edu.fra.uas.text.repository") 
@EntityScan("edu.fra.uas.text.model")
@SpringBootApplication 
public class TextBoard05Application {

	public static void main(String[] args) {
		SpringApplication.run(TextBoard05Application.class, args);
	}

}
