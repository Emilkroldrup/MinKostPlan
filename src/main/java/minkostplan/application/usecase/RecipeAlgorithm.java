package minkostplan.application.usecase;

import org.springframework.stereotype.Service;

@Service
public class RecipeAlgorithm {

    public double ingredientSize(double userCalories, String mealType, double productCalories, String quantity, double totalCaloriesInMeal){
        double mealTypeCalories = 0;
        String unit = quantity.replaceAll("[0-9]", "").trim();
        String numberValue = quantity.replaceAll("[^0-9]", "");
        double quantityValue = Double.parseDouble(numberValue);
        double unitCalories = 0;

        if(mealType.equals("morgenmad")){
            mealTypeCalories = Math.round(userCalories * 0.4);
        } else if(mealType.equals("middagsmad") || mealType.equals("aftensmad")){
            mealTypeCalories = Math.round(userCalories * 0.3);
        }

        if(unit.equals("Unit")){
            unitCalories = Math.round(productCalories * quantityValue);
        } else {
            unitCalories = Math.round(productCalories / 100 * quantityValue);
        }

        double foodPercentage = Math.round((unitCalories / totalCaloriesInMeal) * 100);
        double regulationCalories = Math.round((foodPercentage / 100) * mealTypeCalories);
        return Math.round(regulationCalories / productCalories * 100);
    };

    public double mealCalories(double userCalories, String mealType){
        if(mealType.equals("morgenmad")){
            return Math.round(userCalories * 0.4);
        } else if(mealType.equals("middagsmad") || mealType.equals("aftensmad")){
            return Math.round(userCalories * 0.3);
        }
        throw new IllegalArgumentException("Ugyldig måltidstype: " + mealType);
    }

    public double caloriesCalculated(double productCalories, String quantity){
        String unit = quantity.replaceAll("[0-9]", "").trim();
        String numberValue = quantity.replaceAll("[^0-9]", "");
        double quantityValue = Double.parseDouble(numberValue);
        if(unit.equals("Unit")){
            return Math.round(productCalories * quantityValue);
        } else {
            return Math.round(productCalories / 100 * quantityValue);
        }
    }

    public String units(String quantity){
        return quantity.replaceAll("[0-9]", "").trim();
    }

    public double percentageCalculator(double totalCaloriesInMeal, double unitCalories){
        return Math.round((unitCalories / totalCaloriesInMeal) * 100);
    }

    public double regulationCalories(double percentage, double userMealTypeCalories){
        return Math.round((percentage / 100) * userMealTypeCalories);
    }

    public double quantity(double regulatedCalories, double productCalories){
        return Math.round(regulatedCalories / productCalories * 100);
    }

    public double nutritionalContent(double quantity, double productQuantity){
        return Math.round(quantity / 100 * productQuantity);
    }
}
