package minkostplan.application.usecase;

import minkostplan.application.entity.Users;

import java.time.LocalDateTime;

public class Caloriealgorithm {


private double basicCalc(Users users){
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

private double activityCalc(double bmr, String activityLevel){
    double activityNumber;
    switch (activityLevel){
        case"none":
            activityNumber = 1.2;
            break;
        case"1-2":
            activityNumber = 1.5;
            break;
        case"3-5":
            activityNumber = 1.7;
            break;
        case "6-7":
            activityNumber = 1.9;
            break;
        case "1-2 daily":
            activityNumber = 2.4;
            break;
        default:
            throw new IllegalArgumentException("Invalid activity level" + activityLevel);
    }
    return bmr *activityNumber;
}

private double goalCalc(double activitycalories, String goal){
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
    double basicalc = basicCalc(users);
    double activitycalc = activityCalc(basicalc,users.getActivityLevel());
    double goalcalc = goalCalc(activitycalc, users.getGoal());

    return  goalcalc;
}



public static void main(String [] args){
    Caloriealgorithm calc = new Caloriealgorithm();

    Users users = new Users("mads","madsen",20,192,80,"mand","Gain","madsen@gmail.com","testword", LocalDateTime.now(), "none");
    Users users2 = new Users("mads","madsen",20,192,80,"kvinde","gainweight","madsen@gmail.com","testword", LocalDateTime.now(), "1-2 daily");



    System.out.println("Total calories:" + calc.totalCalories(users));

}

}
