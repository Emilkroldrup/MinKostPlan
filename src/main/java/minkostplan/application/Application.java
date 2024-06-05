package minkostplan.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import minkostplan.application.usecase.PictureStorageService;

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
          commandLineRunner(args);
		SpringApplication.run(Application.class, args);
	}

     /**
      * Command line runner for the Spring Boot application.
      * Makes sure that the picture storage service is initialized and the root folder is created.
      * @param args*
      */
     public static void commandLineRunner(String... args) {
          PictureStorageService pictureStorage = new PictureStorageService();
          pictureStorage.init();
     }
}