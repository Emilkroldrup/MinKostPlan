package minkostplan.application;

import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.DBcontroller.user.UserRepositoryImpl;
import minkostplan.application.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.DBcontroller.user.UserRepositoryImpl;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}