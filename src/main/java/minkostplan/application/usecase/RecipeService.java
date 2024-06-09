package minkostplan.application.usecase;

import minkostplan.application.DBcontroller.recipe.RecipeRepository;
import minkostplan.application.entity.Recipe;
import minkostplan.application.entity.RecipeIngredient;
import minkostplan.application.usecase.CustomExceptions.RecipeNameAlreadyExistsException;
import minkostplan.application.usecase.CustomExceptions.UnexpectedDataErrorExpception;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecipeService {

    private static final Logger logger = LogManager.getLogger(RecipeService.class);

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void saveRecipe(Recipe recipe) {
        try {
            recipeRepository.saveRecipe(recipe);
        } catch (DuplicateKeyException duplicateKeyException) {
            logger.error("Same recipe name already exists exception occurred while saving recipe details: {}", duplicateKeyException.getMessage());
            throw new RecipeNameAlreadyExistsException("Recipe name already exists: " + recipe.getName(),duplicateKeyException);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while editing user details: {}", e.getMessage());
            throw new UnexpectedDataErrorExpception("Data access error occurred while saving recipe: " + e.getMessage(), e);
        }
    }


    public int getIdByRecipeName(String name) {
        try {
            return recipeRepository.getIdByRecipeName(name);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while getting recipe id by its name: {}", e.getMessage());
            throw new UnexpectedDataErrorExpception("Data access error occurred while getting recipe by name: " + e.getMessage(), e);
        }
    }

    public Recipe getRecipeById(int id) {
        try {
            return recipeRepository.getRecipeById(id);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while getting recipe by id: {}", e.getMessage());
            throw new UnexpectedDataErrorExpception("Data access error occurred while getting recipe by id: " + e.getMessage(), e);
        }
    }

    public void deleteRecipe(Recipe recipe) {
        try {
            recipeRepository.deleteRecipe(recipe);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while deleting recipe: {}", e.getMessage());
            throw new UnexpectedDataErrorExpception("Data access error occurred while trying to delete recipe: " + e.getMessage(), e);
        }
    }

    public void editRecipe(Recipe recipe, int recipeId) {
        try {
            recipeRepository.editRecipe(recipe, recipeId);
        } catch (DuplicateKeyException duplicateKeyException) {
            logger.error("Same Recipe name already exists exception occurred while editing recipe details: {}", duplicateKeyException.getMessage());
            throw new RecipeNameAlreadyExistsException("Recipe name already exists: " + recipe.getName(),duplicateKeyException);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while saving the recipes: {}", e.getMessage());
            throw new UnexpectedDataErrorExpception("Data access error occurred while trying to edit recipe: " + e.getMessage(), e);
        }
    }

    public Recipe findByProperty(String property, Object value) {
        try {
            return recipeRepository.findByProperty(property, value);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while finding the recipe: {}", e.getMessage());
            throw new UnexpectedDataErrorExpception("Data access error occurred while trying to find al recipe: " + e.getMessage(), e);
        }
    }

    public List<Recipe> findAll() {
        try {
            return recipeRepository.findAll();
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while finding all recipes: {}", e.getMessage());
            throw new UnexpectedDataErrorExpception("Data access error occurred while trying to find all recipes: " + e.getMessage(), e);
        }
    }

        public List<Recipe> findAllRecipes () {
            try {
                return recipeRepository.findAllRecipe();
            } catch (DataAccessException e) {
                logger.error("Data access exception occurred while finding all recipes: {}", e.getMessage());
                throw new UnexpectedDataErrorExpception("Data access error occurred while trying to find all recipes: " + e.getMessage(), e);
            }
        }
    }


