package minkostplan.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.DBcontroller.user.UserRepositoryImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
