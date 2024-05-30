package minkostplan.application.usecase;

import minkostplan.application.entity.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;



class CaloriealgorithmTest {

Caloriealgorithm caloriealgorithm;
Users existingUser;


    /**
     * Sets up the test environment before each test method is executed.
     * Makes values reset between each test
     */
    @BeforeEach
    void setUp() {
        caloriealgorithm = new Caloriealgorithm();
        existingUser = new Users("Mads","Bjerring", 38,152,90,"Male","Gain weight","test@mail.com","testword", LocalDateTime.now(), "1-2 times a week");
    }

    /**
     * Test if it calculates the calories correctly for the specefic user
     * Also tests if the set arguments works like 1-2 times a week
     */
    @Test
    void calculatecalories(){
       double usercalories = caloriealgorithm.totalCalories(existingUser);


        double bmr = (10 * existingUser.getWeight()) + (6.25 * existingUser.getHeight()) - (5 * existingUser.getAge()) + 5;
        double tdee = bmr * 1.5;
        double expectedCalories = tdee + 500;

        assertEquals(expectedCalories,usercalories);
        System.out.println("User calories " + usercalories);
        System.out.println("Excepted calories " + expectedCalories);

    }
}