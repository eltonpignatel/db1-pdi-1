package br.com.eltonpignatel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PDIApplication {
	 public static void main(String[] args) {
		 SpringApplication.run(PDIApplication.class, args);		 
	 }
}