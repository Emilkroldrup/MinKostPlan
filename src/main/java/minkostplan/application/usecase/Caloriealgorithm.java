package minkostplan.application.usecase;

import minkostplan.application.entity.Users;

import java.time.LocalDateTime;

public class Caloriealgorithm {


private double calculateBMR(Users users){
    double basicCalories;
    if(users.getGender().equals("male")){
        basicCalories = (10 * users.getWeight()) + (6.25*  users.getHeight() - (5 * users.getAge()) + 5);
    }
    else if(users.getGender().equals("female")){
        basicCalories = (10 * users.getWeight()) + (6.25* users.getHeight() - (5 * users.getAge()) -161);
    } else {
        throw new IllegalArgumentException("Invalid gender: " + users.getGender());
    }


    return  basicCalories;
}

private double calculateTDEE(double bmr, String activityLevel){
    double activityNumber;
    switch (activityLevel){
        case"none":
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
        default:
            activityNumber = 1.2;
            break;
    }
    return bmr *activityNumber;
}

private double adjustForGoal(double activitycalories, String goal){
    double goalCalories;
    switch (goal){
        case"Lose":
            goalCalories = activitycalories - 500;
            break;
        case"Gain":
            goalCalories = activitycalories + 500;
            break;
        case"Keep":
            goalCalories = activitycalories + 0;
            break;
        case "Muscle":
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

    Users users = new Users("mads","madsen",20,192,80,"male","Gain","madsen@gmail.com","testword", LocalDateTime.now(), "6-7 gange om ugen");
    Users users2 = new Users("mia","lisbeth",20,192,80,"female","gainweight","madsen@gmail.com","testword", LocalDateTime.now(), "1-2 gange om dagen");



    System.out.println("Total calories:" + calc.totalCalories(users));

}

}
