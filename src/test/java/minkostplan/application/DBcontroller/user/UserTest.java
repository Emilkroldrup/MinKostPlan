package minkostplan.application.DBcontroller.user;
import minkostplan.application.entity.Users;
import minkostplan.application.usecase.UserUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
@SpringBootTest

class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;


    private Users existingUser;
    private String firstname;
    private String lastname;
    private int age;
    private int height;
    private int weight;
    private String gender;
    private String goal;
    private String email;
    private String passwordHash;
    private LocalDateTime createdAt;

    @BeforeEach
    void setUp() {
        firstname = "test";
        lastname = "masden";
        age = 50;
        height= 192;
        weight = 80;
        gender ="Guy";
        goal ="gain weight";
        passwordHash = "testenpassword";
        email = "nej";
        existingUser = new Users(firstname,lastname, age,height,weight,gender,goal,email,passwordHash, LocalDateTime.now());
    }


    @Test
    void findbyEmail(){
        when(userRepository.findByEmail(argThat(email -> email.equals(existingUser.getEmail())))).thenReturn(existingUser);
        Users result = userRepository.findByEmail(email);
        System.out.println("email" + email);
        System.out.println(existingUser);
        System.out.println("Has to equal: " + existingUser);
        System.out.println();
        System.out.println("Result: " + result);
        assertEquals(result,existingUser);




    }


}
