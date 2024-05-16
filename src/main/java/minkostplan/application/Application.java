package minkostplan.application;

import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {

			//Users user = userRepository.findByEmail("test@mail.com");
			//System.out.println(userRepository.findByEmail("test@mail.com"));
		};
	}

	private void testFindByEmail() {
		// Replace "test@example.com" with a valid email from your database
		String email = "test@mail.com";
		Users user = userRepository.findByEmail(email);

		if (user != null) {
			System.out.println("User found:");
			System.out.println("Username: " + user.getUsername());
			System.out.println("Email: " + user.getEmail());
		} else {
			System.out.println("User not found for email: " + email);
		}
	}
}