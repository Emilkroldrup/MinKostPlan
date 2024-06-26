package minkostplan.application.usecase;

import java.time.LocalDateTime;

import minkostplan.application.usecase.CustomExceptions.UnexpectedDataErrorExpception;
import minkostplan.application.usecase.CustomExceptions.UserEmailAlreadyExistsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.entity.Users;

@Service
public class SurveyService {

    private final UserRepository userRepository;
    private static final Logger logger = LogManager.getLogger(RecipeService.class);
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public SurveyService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users createUser(String firstName, String lastName, int age, int height, int weight, String gender, String goal, String email, String password, LocalDateTime createdAt, String activityLevel, int phone) {
        try {
            String passwordHash = passwordEncoder.encode(password);
            Users user = new Users(firstName, lastName, age, height, weight, gender, goal, email, passwordHash, LocalDateTime.now(), activityLevel, phone);
            userRepository.saveUser(user);
            return user;
        } catch (DuplicateKeyException ee) {
            logger.error("DuplicateKeyException occurred while trying to create user with email {}: {}", email, ee.getMessage(), ee);
            throw new UserEmailAlreadyExistsException("Email already exists: " + email, ee);
        } catch (DataAccessException e) {
            logger.error("DataAccessException occurred while trying to create user: {}", e.getMessage(), e);
            throw new UnexpectedDataErrorExpception("Data access error occurred while trying to create user: " + e.getMessage(), e);
        }
    }
}
