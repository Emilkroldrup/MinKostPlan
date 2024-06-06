package minkostplan.application.usecase;

import minkostplan.application.DBcontroller.recipe.RecipeRepository;
import minkostplan.application.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    public void saveRecipe(Recipe recipe) {
        try {
            recipeRepository.saveRecipe(recipe);
        } catch (DataAccessException dataAccessException) {
            System.out.println("Error connecting to database: " + dataAccessException.getMessage());
        }
    }

    public int getIdByRecipeName(String name){
            return  recipeRepository.getIdByRecipeName(name);
        }

    public Recipe getRecipeById(int id){
            return  recipeRepository.getRecipeById(id);
    }

    public void deleteRecipe(Recipe recipe) {
            recipeRepository.deleteRecipe(recipe);
    }

    public void editRecipe(Recipe recipe, int recipeId) {
            recipeRepository.editRecipe(recipe, recipeId);
    }

    public Recipe findByProperty(String property, Object value) {
            return recipeRepository.findByProperty(property, value);
    }
    public List<Recipe> findAll(){
        return  recipeRepository.findAll();
    }
    public List<Recipe> findAllRecipes(){
            return  recipeRepository.findAllRecipe();
    }
}

