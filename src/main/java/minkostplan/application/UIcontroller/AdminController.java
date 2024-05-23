package minkostplan.application.UIcontroller;

import minkostplan.application.DBcontroller.ingredients.IngredientsRepository;
import minkostplan.application.DBcontroller.recipe.RecipeRepository;
import minkostplan.application.entity.Ingredient;
import minkostplan.application.entity.Recipe;
import minkostplan.application.entity.Users;
import minkostplan.application.usecase.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
     *
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

    @PostMapping("/addrecipe")
    public String addRecipe(@ModelAttribute("recipe") Recipe recipe, @ModelAttribute("ingredients") Ingredient ingredient) {
        ingredientsRepository.saveIngredient(ingredient);
        recipeRepository.saveRecipe(recipe);
        return "adminpage";
    }
}
