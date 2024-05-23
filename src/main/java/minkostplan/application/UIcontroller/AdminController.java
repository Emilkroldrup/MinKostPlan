package minkostplan.application.UIcontroller;

import minkostplan.application.DBcontroller.ingredients.IngredientsRepository;
import minkostplan.application.DBcontroller.recipe.RecipeRepository;
import minkostplan.application.entity.Ingredient;
import minkostplan.application.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Value("${admin.email}")
    private String adminEmail;

    /**
     * Handles the admin page request.
     * @param model for recipe, used to pass data from controller to view in our html
     * @return the admin page view
     */
    @GetMapping("/admin")
    public String adminPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        if (!email.equals(adminEmail)) {
            return "redirect:/access-denied";
        }
        model.addAttribute("recipe", new Recipe());
        return "adminpage";
    }

    /**
     * Adds the recipe and ingredient(s) to the database
     * @param recipe recipe object of recipe class
     * @param ingredients ingredients value of hidden input fields
     * @param descriptions descriptions value of hidden input fields
     * @return the admin page view
     */

    @PostMapping("/addrecipe")
    public String addRecipe(@ModelAttribute("recipe") Recipe recipe, @RequestParam("ingredients") List<String> ingredients,
                            @RequestParam("descriptions") List<String> descriptions) {

        recipeRepository.saveRecipe(recipe);

        for (int i = 0; i < ingredients.size(); i++) {
            String ingredientName = ingredients.get(i);
            String description = descriptions.get(i);

            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingredientName);
            ingredient.setDescription(description);

            ingredientsRepository.saveIngredient(ingredient);
        }
        return "adminpage";
    }

}
