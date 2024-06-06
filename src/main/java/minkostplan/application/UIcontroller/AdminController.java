package minkostplan.application.UIcontroller;

import minkostplan.application.DBcontroller.ingredients.IngredientsRepository;
import minkostplan.application.DBcontroller.recipe.RecipeRepository;
import minkostplan.application.DBcontroller.recipeingredient.RecepiIngredientRepository;
import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.entity.Ingredient;
import minkostplan.application.entity.Recipe;

import minkostplan.application.entity.RecipeIngredient;

import minkostplan.application.entity.Users;
import minkostplan.application.usecase.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

/**
 * Controller for handling admin related requests.
 */
@Controller
public class AdminController {


    private final RecipeIngredientService recipeIngredientService;

    private final RecipeService recipeService;

    private final IngredientService ingredientService;

    @Value("${admin.email}")
    private String adminEmail;

    @Autowired
    public AdminController( RecipeIngredientService recipeIngredientService,RecipeService recipeService , IngredientService ingredientService) {
        this.recipeIngredientService =recipeIngredientService;
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    /**
     * Handles the admin page request.
     * @param model for recipe, used to pass data from controller to view in our html
     * @return the admin page view
     */
    @GetMapping("/admin")
    public String adminPage(Model model) {

        Users user = UserUtil.getCurrentUser();
        String email = user.getEmail();

        if (!email.equals(adminEmail)) {
            return "redirect:/access-denied";
        }
        model.addAttribute("recipe", new Recipe());
        return "adminpage";
    }

    @GetMapping("/navbar")
    public String navbarAdmin(Model model) {
        Users user = UserUtil.getCurrentUser();
        String email = user.getEmail();
        model.addAttribute("email", email);
        model.addAttribute("adminEmail", adminEmail);
        return "navbar";
    }

    /**
     * Adds the recipe and ingredient(s) to the database and to recipeingredients in the database
     * @param recipe recipe object of recipe class
     * @param ingredients ingredients value of hidden input fields
     * @param descriptions descriptions value of hidden input fields
     * @param quantity quantity value of hidden input fields
     * @return the admin page view
     */

        @PostMapping("/addrecipe")
        public String addRecipe(@ModelAttribute("recipe") Recipe recipe, @RequestParam("ingredients") List<String> ingredients,
                                @RequestParam("descriptions") List<String> descriptions,@RequestParam("quantity") List<String> quantity, Model model) {


            if (recipe.getInstructions().isEmpty() || recipe.getName().isEmpty() || recipe.getCookName().isEmpty() || recipe.getAverageTime() == null) {
                model.addAttribute("error", "All recipe fields must be filled.");
                return "adminpage";
            }

            if (ingredients.isEmpty() || descriptions.isEmpty() || quantity.isEmpty()) {
                model.addAttribute("error", "Ingredients, descriptions, and quantity must not be empty.");
                return "adminpage";
            }

            try {
                recipeService.saveRecipe(recipe);
                int recipeId = recipeService.getIdByRecipeName(recipe.getName());

                for (int i = 0; i < ingredients.size(); i++) {
                    String ingredientName = ingredients.get(i);
                    String description = descriptions.get(i);

                    Ingredient ingredient = new Ingredient();
                    ingredient.setName(ingredientName);
                    ingredient.setDescription(description);
                    String quantityOfIngredient = quantity.get(i);

                    ingredientService.saveIngredient(ingredient);
                    int ingredientId = ingredientService.getIdByIngredientName(ingredientName);

                    RecipeIngredient recipeIngredient = new RecipeIngredient(recipeId, ingredientId, quantityOfIngredient, ingredientName);
                    recipeIngredientService.saveRecipeIngredient(recipeIngredient);
                }
            } catch (DuplicateKeyException e) {
                model.addAttribute("error", "An ingredient with the same name already exists.");
            } catch (DataAccessException e) {
                model.addAttribute("error", "Error connecting to database.");
            }

            return "adminpage";
        }
    }
