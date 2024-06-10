package minkostplan.application.usecase;

import org.springframework.stereotype.Service;

/**
 * Service class that contains various algorithms for calculating nutritional
 * information and serving sizes based on user requirements and meal types.
 */
@Service
public class RecipeAlgorithm {

    /**
     * Calculates the appropriate size of an ingredient portion based on user calories,
     * meal type, product calories, quantity, and total calories in a meal.
     *
     * @param userCalories        The total daily calories requirement of the user.
     * @param mealType            The type of meal (e.g., "morgenmad", "middagsmad", "aftensmad").
     * @param productCalories     The calories in the product per 100 grams or per unit.
     * @param quantity            The quantity of the product (e.g., "200 gram", "3 Unit").
     * @param totalCaloriesInMeal The total calories in the meal.
     * @return The regulated quantity of the ingredient for the specified meal type.
     */
    public double ingredientSize(double userCalories, String mealType, double productCalories, String quantity, double totalCaloriesInMeal) {
        double mealTypeCalories = 0;
        String unit = quantity.replaceAll("[0-9]", "").trim();
        String numberValue = quantity.replaceAll("[^0-9]", "");
        double quantityValue = Double.parseDouble(numberValue);
        double unitCalories = 0;

        if (mealType.equals("morgenmad")) {
            mealTypeCalories = Math.round(userCalories * 0.4);
        } else if (mealType.equals("middagsmad") || mealType.equals("aftensmad")) {
            mealTypeCalories = Math.round(userCalories * 0.3);
        }

        if (unit.equals("Unit")) {
            unitCalories = Math.round(productCalories * quantityValue);
        } else {
            unitCalories = Math.round(productCalories / 100 * quantityValue);
        }

        double foodPercentage = Math.round((unitCalories / totalCaloriesInMeal) * 100);
        double regulationCalories = Math.round((foodPercentage / 100) * mealTypeCalories);
        return Math.round(regulationCalories / productCalories * 100);
    }

    /**
     * Calculates the total calories allocated for a specific meal type based on the user's total daily calories.
     *
     * @param userCalories The total daily calories requirement of the user.
     * @param mealType     The type of meal (e.g., "morgenmad", "middagsmad", "aftensmad").
     * @return The total calories allocated for the specified meal type.
     */
    public double mealCalories(double userCalories, String mealType) {
        if (mealType.equals("morgenmad")) {
            return Math.round(userCalories * 0.4);
        } else if (mealType.equals("middagsmad") || mealType.equals("aftensmad")) {
            return Math.round(userCalories * 0.3);
        }
        throw new IllegalArgumentException("Ugyldig måltidstype: " + mealType);
    }

    /**
     * Calculates the total calories in a given quantity of a product.
     *
     * @param productCalories The calories in the product per 100 grams or per unit.
     * @param quantity        The quantity of the product (e.g., "200 gram", "3 Unit").
     * @return The total calories in the specified quantity of the product.
     */
    public double caloriesCalculated(double productCalories, String quantity) {
        String unit = quantity.replaceAll("[0-9]", "").trim();
        String numberValue = quantity.replaceAll("[^0-9]", "");
        double quantityValue = Double.parseDouble(numberValue);
        if (unit.equals("Unit")) {
            return Math.round(productCalories * quantityValue);
        } else {
            return Math.round(productCalories / 100 * quantityValue);
        }
    }

    /**
     * Extracts the unit from a given quantity string.
     *
     * @param quantity The quantity string (e.g., "200 gram", "3 Unit").
     * @return The unit part of the quantity string.
     */
    public String units(String quantity) {
        return quantity.replaceAll("[0-9]", "").trim();
    }

    /**
     * Calculates the percentage of calories from a unit relative to the total calories in a meal.
     *
     * @param totalCaloriesInMeal The total calories in the meal.
     * @param unitCalories        The calories in the specified unit.
     * @return The percentage of calories from the unit relative to the total calories in the meal.
     */
    public double percentageCalculator(double totalCaloriesInMeal, double unitCalories) {
        return Math.round((unitCalories / totalCaloriesInMeal) * 100);
    }

    /**
     * Calculates the regulated calories based on the percentage and user's meal type calories.
     *
     * @param percentage         The percentage of the unit calories relative to the total calories.
     * @param userMealTypeCalories The user's allocated calories for the meal type.
     * @return The regulated calories based on the given percentage.
     */
    public double regulationCalories(double percentage, double userMealTypeCalories) {
        return Math.round((percentage / 100) * userMealTypeCalories);
    }

    /**
     * Calculates the quantity of a product based on the regulated calories and product calories.
     *
     * @param regulatedCalories The regulated calories for the meal.
     * @param productCalories   The calories in the product per 100 grams or per unit.
     * @return The quantity of the product needed to meet the regulated calories.
     */
    public double quantity(double regulatedCalories, double productCalories) {
        return Math.round(regulatedCalories / productCalories * 100);
    }

    /**
     * Calculates the nutritional content based on the quantity and product quantity.
     *
     * @param quantity        The quantity of the product.
     * @param productQuantity The nutritional content of the product per 100 grams or per unit.
     * @return The calculated nutritional content for the specified quantity.
     */
    public double nutritionalContent(double quantity, double productQuantity) {
        return Math.round(quantity / 100 * productQuantity);
    }
}
