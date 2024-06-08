package minkostplan.application.UIcontroller;

import minkostplan.application.entity.Ingredient;
import minkostplan.application.entity.Recipe;
import minkostplan.application.entity.RecipeIngredient;
import minkostplan.application.entity.Users;
import minkostplan.application.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserRecipeController {

    private final RecipeService recipeService;
    private final Caloriealgorithm caloriealgorithm;
    private final IngredientService ingredientService;
    private final RecipeIngredientService recipeIngredientService;

    @Autowired
    public UserRecipeController(RecipeService recipeService, Caloriealgorithm caloriealgorithm, IngredientService ingredientService, RecipeIngredientService recipeIngredientService) {
        this.recipeService = recipeService;
        this.caloriealgorithm = caloriealgorithm;
        this.ingredientService = ingredientService;
        this.recipeIngredientService = recipeIngredientService;
    }

    @GetMapping("/recipelist")
    public String userRecipeList(Model model) {
        List<Recipe> recipes = recipeService.findAllRecipes();
        model.addAttribute("recipes", recipes);
        return "userRecipeList";
    }

    @GetMapping("/ingredientList")
    public String userIngredientList(Model model) {
        List<Ingredient> ingredients = ingredientService.findAllIngredients();
        model.addAttribute("ingredients", ingredients);
        return "userIngredientList";
    }

    @GetMapping("/recipe/{id}")
    public String getRecipeById(@PathVariable("id") int id, Model model) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe.getInstructions() != null) {
            List<String> instructionsList = Arrays.asList(recipe.getInstructions().split("\n"));
            recipe.setInstructionsList(instructionsList);
        }

        Users user = UserUtil.getCurrentUser();
        Ingredient ingredient = ingredientService.getIngredientById(id);
        RecipeIngredient recipeIngredient = recipeIngredientService.getRecipeIngredientByIngredientId(id);
        double totalCalories = 0;
        System.out.println(recipe.getIngredients());
        for (RecipeIngredient recipeIngredient1 : recipe.getIngredients()) {
            int ingredientId = ingredientService.getIdByIngredientName(recipeIngredient1.getIngredientName());
            Ingredient recipeIngredientDetail = ingredientService.getIngredientById(ingredientId);
            totalCalories += recipeIngredientDetail.getCalories();
        }
        double userCalories = caloriealgorithm.totalCalories(user);
        double mealCalories = caloriealgorithm.mealCalories(userCalories, recipe.getMealType());
        double ingredientCalories = caloriealgorithm.caloriesCalculated(ingredient.getCalories(), recipeIngredient.getQuantity());
        String units = caloriealgorithm.units(recipeIngredient.getQuantity());
        double percentageCalories = caloriealgorithm.percentageCalculator(totalCalories, ingredientCalories);
        double regulatedCalories = caloriealgorithm.regulationCalories(percentageCalories, mealCalories);
        double quantity = caloriealgorithm.quantity(regulatedCalories, ingredient.getCalories());

        model.addAttribute("recipe", recipe);
        model.addAttribute("quantity", quantity);
        model.addAttribute("units", units);
        return "recipePage";
    }
}
