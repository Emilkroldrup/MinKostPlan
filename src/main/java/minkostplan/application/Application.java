package minkostplan.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import minkostplan.application.DBcontroller.filesystem.StorageServiceInterface;
import minkostplan.application.config.StorageProperties;

/**
 * Main class for the Spring Boot application.
 */
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application {
	/**
     * Main method to run the Spring Boot application.
     *
     * @param args command line arguments
     */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

     @Bean
	CommandLineRunner init(StorageServiceInterface storageService) {
		return args -> {
			storageService.init();
		};
	}
}