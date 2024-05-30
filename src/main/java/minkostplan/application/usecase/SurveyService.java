package minkostplan.application.usecase;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.entity.Users;

@Service
public class SurveyService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Users createUser(String firstName, String lastName, int age, int height, int weight, String gender, String goal, String email, String password, LocalDateTime createdAt, String activityLevel) {
        String passwordHash = passwordEncoder.encode(password);
        Users user = new Users(firstName, lastName, age, height, weight, gender, goal, email, passwordHash, LocalDateTime.now(), activityLevel);
        userRepository.saveUser(user);
        return user;
    }
}
