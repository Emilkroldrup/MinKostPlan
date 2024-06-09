package minkostplan.application.UIcontroller;

import minkostplan.application.entity.Ingredient;
import minkostplan.application.entity.Recipe;

import minkostplan.application.entity.RecipeIngredient;

import minkostplan.application.entity.Users;
import minkostplan.application.usecase.*;

import minkostplan.application.usecase.CustomExceptions.RecipeNameAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

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
    public AdminController(RecipeIngredientService recipeIngredientService, RecipeService recipeService, IngredientService ingredientService) {
        this.recipeIngredientService = recipeIngredientService;
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    /**
     * Handles the admin page request.
     *
     * @param model for recipe, used to pass data from controller to view in our html
     * @return the admin page view
     */
    @GetMapping("/adminrecipe")
    public String adminPageRecipe(Model model) {

        Users user = UserUtil.getCurrentUser();
        String email = user.getEmail();
        List<String> ingredients = ingredientService.findAllNames();
        if (!email.equals(adminEmail)) {
            return "redirect:/access-denied";
        }
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("ingredients", ingredients);
        return "adminpagerecipe";
    }


    @GetMapping("/adminingredient")
    public String adminPageIngredient(Model model) {

        Users user = UserUtil.getCurrentUser();
        String email = user.getEmail();

        if (!email.equals(adminEmail)) {
            return "redirect:/access-denied";
        }
        model.addAttribute("ingredient", new Ingredient());
        return "adminpageingredient";
    }


    @GetMapping("/adminrecipes")
    public String adminPageAllRecipes(Model model) {
        List<Recipe> recipes = recipeService.findAllRecipes();
        Users user = UserUtil.getCurrentUser();
        String email = user.getEmail();

        if (!email.equals(adminEmail)) {
            return "redirect:/access-denied";
        }
        model.addAttribute("recipes", recipes);
        return "adminpageallrecipes";
    }

    @GetMapping("/adminingredients")
    public String adminPageAllIngredient( Model model) {
        List<Ingredient> ingredients = ingredientService.findAllIngredients();
        Users user = UserUtil.getCurrentUser();
        String email = user.getEmail();

        if (!email.equals(adminEmail)) {
            return "redirect:/access-denied";
        }
        model.addAttribute("ingredients", ingredients);
        return "adminpageallingredients";
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
     *
     * @param recipe recipe object of recipe class
     * @return the admin page view
     */
    @PostMapping("/addrecipe")
    public String addRecipe(@ModelAttribute("recipe") Recipe recipe, @RequestParam(name = "ingredientNames", required = false)
           List<String> ingredientNames, @RequestParam Map<String, String> params,RedirectAttributes redirectAttributes) {

        if (ingredientNames == null || ingredientNames.isEmpty()) {
            redirectAttributes.addFlashAttribute("Erroringredient","Select atleast 1 ingredient");
            return "redirect:adminrecipe";
        }

        recipeService.saveRecipe(recipe);
        int recipeId = recipeService.getIdByRecipeName(recipe.getName());

        for (String ingredientName : ingredientNames) {
            String quantity = params.get("quantities[" + ingredientName + "]");
            if (quantity != null && !quantity.isEmpty()) {
                int ingredientId = ingredientService.getIdByIngredientName(ingredientName);
                RecipeIngredient recipeIngredient = new RecipeIngredient(recipeId, ingredientId, quantity, ingredientName);
                recipeIngredientService.saveRecipeIngredient(recipeIngredient);
            }
        }
        return "redirect:/adminrecipe";
    }

    @PostMapping("/addingredient")
    public String addIngredient(@ModelAttribute("ingredient") Ingredient ingredient){
        ingredientService.saveIngredient(ingredient);
        System.out.println("loll" + ingredient);
        return "redirect:/adminingredient";
    }

    @PostMapping("/editrecipe")
    public String editRecipe(@ModelAttribute("recipe") Recipe recipe, @RequestParam("id") int recipeId) {
        recipeService.editRecipe(recipe, recipeId);
        return "redirect:/adminrecipes";
    }

    @PostMapping("/deleterecipe")
    public String deleteRecipe(@ModelAttribute("recipe") Recipe recipe, @RequestParam("id") int recipeId) {
        Recipe recipe1 = recipeService.getRecipeById(recipeId);
        recipeService.deleteRecipe(recipe1);
        return "redirect:/adminrecipes";
    }

    @PostMapping("/editingredient")
    public String editIngredient(@ModelAttribute("ingredient") Ingredient ingredient, @RequestParam("id") int ingredientId){
        ingredientService.editIngredient(ingredient, ingredientId);
        return "redirect:/adminingredients";
    }

    @PostMapping("/deleteingredient")
    public String deleteIngredient(@ModelAttribute("ingredient") Ingredient ingredient, @RequestParam("id") int ingredientId){
        Ingredient ingredient1 = ingredientService.getIngredientById(ingredientId);
        ingredientService.deleteIngredient(ingredient1);
        return "redirect:/adminingredients";
    }
}
