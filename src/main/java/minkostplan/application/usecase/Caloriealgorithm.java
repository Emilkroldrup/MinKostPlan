package minkostplan.application.usecase;

import minkostplan.application.entity.Users;

import java.time.LocalDateTime;

public class Caloriealgorithm {


private double basicCalc(Users users){
    double basicCalories;
    if(users.getGender().equals("Boy")){
        basicCalories = (10 * users.getWeight()) + (6.25*  users.getHeight() - (5 * users.getAge()) + 5);
    }
    else if(users.getGender().equals("Girl")){
        basicCalories = (10 * users.getWeight()) + (6.25* users.getHeight() - (5 * users.getAge()) -161);
    } else {
        throw new IllegalArgumentException("Invalid gender: " + users.getGender());
    }


    return  basicCalories;
}

private double activityCalc(double bmr, double activityLevel){
    return bmr *activityLevel;
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
    double activity = 1.5;
    double basicalc = basicCalc(users);
    double activitycalc = activityCalc(basicalc,activity);
    double goalcalc = goalCalc(activitycalc, users.getGoal());

    return  goalcalc;
}



public static void main(String [] args){
    Caloriealgorithm calc = new Caloriealgorithm();

    Users users = new Users("mads","madsen",20,192,80,"Boy","Gain","madsen@gmail.com","testword", LocalDateTime.now());
    Users users2 = new Users("mads","madsen",20,192,80,"Girl","gainweight","madsen@gmail.com","testword", LocalDateTime.now());



    System.out.println("Total calories:" + calc.totalCalories(users));

}

}
