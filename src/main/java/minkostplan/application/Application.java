package minkostplan.application;

import minkostplan.application.entity.Recipe;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Main class for the Spring Boot application.
 */
@SpringBootApplication
public class Application {
	/**
     * Main method to run the Spring Boot application.
     *
     * @param args command line arguments
     */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}