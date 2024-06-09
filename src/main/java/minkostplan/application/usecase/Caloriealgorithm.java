package minkostplan.application.usecase;

import minkostplan.application.entity.Users;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Caloriealgorithm {


    private double calculateBMR(Users users){
        double basicCalories;
        if(users.getGender().equals("Mand")){
            basicCalories = (10 * users.getWeight()) + (6.25*  users.getHeight() - (5 * users.getAge()) + 5);
        }
        else if(users.getGender().equals("Kvinde")){
            basicCalories = (10 * users.getWeight()) + (6.25* users.getHeight() - (5 * users.getAge()) -161);
        } else {
            throw new IllegalArgumentException("Invalid gender: " + users.getGender());
        }

        return  basicCalories;
    }

    private double calculateTDEE(double bmr, String activityLevel){
        double activityNumber = 0;
        switch (activityLevel){
            case"Ingen eller meget lidt aktivitet":
                activityNumber = 1.2;
                break;
            case"1-2 gange om ugen":
                activityNumber = 1.5;
                break;
            case"3-5 gange om ugen":
                activityNumber = 1.7;
                break;
            case "6-7 gange om ugen":
                activityNumber = 1.9;
                break;
            case "1-2 gange om dagen":
                activityNumber = 2.4;
                break;
        }
        return bmr *activityNumber;
    }

    private double adjustForGoal(double activitycalories, String goal){
        double goalCalories;
        switch (goal){
            case"Tabe vægt":
                goalCalories = activitycalories - 500;
                break;
            case"Øg vægt":
                goalCalories = activitycalories + 500;
                break;
            case"Beholde vægt":
                goalCalories = activitycalories + 0;
                break;
            case "Byg muskel":
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
}
