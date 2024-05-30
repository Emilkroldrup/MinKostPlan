package minkostplan.application.DBcontroller.UseCaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.entity.Users;
import minkostplan.application.usecase.SurveyService;

@ExtendWith(MockitoExtension.class)
public class SurveyServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private SurveyService surveyService;

    private String hashedPassword;

    @BeforeEach
    public void setUp() {
        hashedPassword = "encodedPassword1";
        when(passwordEncoder.encode(any(String.class))).thenReturn(hashedPassword);
        
    }


    @Test
    public void createUser() {
        String firstName = "Test1";
        String lastName = "Tester1";
        int age = 69;
        int height = 169;
        int weight = 69;
        String gender = "male";
        String goal = "keep";
        String email = "test1@tester1.com";
        String password = "password1";
        LocalDateTime createdAt = LocalDateTime.now();
        String activityLevel = "none";

        Users userTest = surveyService.createUser(firstName, lastName, age, height, weight, gender, goal, email, password, createdAt, activityLevel);
        
        assertNotNull(userTest);
        assertEquals(hashedPassword, userTest.getPasswordHash());
        assertEquals(firstName, userTest.getFirstName());
        assertEquals(lastName, userTest.getLastName());
        assertEquals(age, userTest.getAge());
        assertEquals(height, userTest.getHeight());
        assertEquals(weight, userTest.getWeight());
        assertEquals(gender, userTest.getGender());
        assertEquals(goal, userTest.getGoal());
        assertEquals(email, userTest.getEmail());
        assertEquals(activityLevel, userTest.getActivityLevel());

        
        verify(passwordEncoder).encode(password);
        verify(userRepository).saveUser(any(Users.class));
    }
    
}
