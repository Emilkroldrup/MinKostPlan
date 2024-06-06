package minkostplan.application.usecase;

import minkostplan.application.entity.Users;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class Caloriealgorithm {


private double calculateBMR(Users users){
    double basicCalories;
    if(users.getGender().equals("Male")){
        basicCalories = (10 * users.getWeight()) + (6.25*  users.getHeight() - (5 * users.getAge()) + 5);
    }
    else if(users.getGender().equals("Female")){
        basicCalories = (10 * users.getWeight()) + (6.25* users.getHeight() - (5 * users.getAge()) -161);
    } else {
        throw new IllegalArgumentException("Invalid gender: " + users.getGender());
    }

    return  basicCalories;
}

private double calculateTDEE(double bmr, String activityLevel){
    double activityNumber = 0;
    switch (activityLevel){
        case"None or very little exercise":
            activityNumber = 1.2;
            break;
        case"1-2 times a week":
            activityNumber = 1.5;
            break;
        case"3-5 times a week":
            activityNumber = 1.7;
            break;
        case "6-7 times a week":
            activityNumber = 1.9;
            break;
        case "1-2 times a day":
            activityNumber = 2.4;
            break;
    }
    return bmr *activityNumber;
}

private double adjustForGoal(double activitycalories, String goal){
    double goalCalories;
    switch (goal){
        case"Lose weight":
            goalCalories = activitycalories - 500;
            break;
        case"Gain weight":
            goalCalories = activitycalories + 500;
            break;
        case"Maintain weight":
            goalCalories = activitycalories + 0;
            break;
        case "Build muscle":
            goalCalories = activitycalories + 300;
            break;
        default:
            throw new IllegalArgumentException("Invalid goal" + goal);
    }
    return goalCalories;
}

public double totalCalories(Users users){
    double calculateBMR = calculateBMR(users);
    double calculateTDEE = calculateTDEE(calculateBMR,users.getActivityLevel());

    return adjustForGoal(calculateTDEE, users.getGoal());
}



public static void main(String [] args){
    Caloriealgorithm calc = new Caloriealgorithm();

    Users users = new Users("mads","madsen",20,192,80,"male","Gain weight","madsen@gmail.com","testword", LocalDateTime.now(), "6-7 times a week", 20202020);
    Users users2 = new Users("mia","lisbeth",20,192,80,"female","Build muscle","madsen@gmail.com","testword", LocalDateTime.now(), "1-2 gange om dagen", 21211221);



    System.out.println("Total calories:" + calc.totalCalories(users));

}

}
