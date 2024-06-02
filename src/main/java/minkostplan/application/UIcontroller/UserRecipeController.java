package minkostplan.application.UIcontroller;

import minkostplan.application.entity.Recipe;
import minkostplan.application.usecase.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserRecipeController {

    private final RecipeService recipeService;

    @Autowired
    public UserRecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipelist")
    public String userRecipeList(Model model) {
        List<Recipe> recipes = recipeService.findAllRecipes();
        model.addAttribute("recipes", recipes);
        return "userRecipeList";
    }

    @GetMapping("/recipe/{id}")
    public String recipePage(@PathVariable int id, Model model) {
        Recipe recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe", recipe);
        return "recipePage";
    }
}
