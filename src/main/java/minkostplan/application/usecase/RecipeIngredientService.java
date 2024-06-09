package minkostplan.application.usecase;

import minkostplan.application.DBcontroller.recipeingredient.RecepiIngredientRepository;
import minkostplan.application.entity.RecipeIngredient;
import minkostplan.application.usecase.CustomExceptions.UnexpectedErrorHappendExpception;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientService {

    private static final Logger logger = LogManager.getLogger(RecipeIngredientService.class);

    private final RecepiIngredientRepository recepiIngredientRepository;

    @Autowired
    public RecipeIngredientService(RecepiIngredientRepository recepiIngredientRepository) {
        this.recepiIngredientRepository = recepiIngredientRepository;
    }

    public void saveRecipeIngredient(RecipeIngredient recipeIngredient) {
        try {
            recepiIngredientRepository.saveRecipeIngredient(recipeIngredient);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while editing user details: {}", e.getMessage());
            throw new UnexpectedErrorHappendExpception( "Data access error occurred: " + e.getMessage(), e);
        }
    }
  
    public RecipeIngredient findByProperty(String property, Object value) {
        try {
            return recepiIngredientRepository.findByProperty(property, value);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while editing user details: {}", e.getMessage());
            throw new UnexpectedErrorHappendExpception( "Data access error occurred: " + e.getMessage(), e);
        }

    }

    public List<RecipeIngredient> findAllRecipeIngredients() {
        try {
            return recepiIngredientRepository.findAll();
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while editing user details: {}", e.getMessage());
            throw new UnexpectedErrorHappendExpception( "Data access error occurred: " + e.getMessage(), e);
        }
    }

    public RecipeIngredient getRecipeIngredientByIngredientId(int ingredientId) {
        try {
            return recepiIngredientRepository.getRecipeIngredientByIngredientId(ingredientId);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while editing user details: {}", e.getMessage());
            throw new UnexpectedErrorHappendExpception( "Data access error occurred: " + e.getMessage(), e);
        }
    }
}