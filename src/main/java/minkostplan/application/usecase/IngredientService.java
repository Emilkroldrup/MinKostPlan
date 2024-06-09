package minkostplan.application.usecase;

import minkostplan.application.DBcontroller.ingredients.IngredientsRepository;
import minkostplan.application.entity.Ingredient;
import minkostplan.application.usecase.CustomExceptions.UnexpectedDataErrorExpception;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private static final Logger logger = LogManager.getLogger(IngredientService.class);

    private final IngredientsRepository ingredientsRepository;

    @Autowired
    public IngredientService(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    public List<String> findAllNames() {
        try {
            return ingredientsRepository.findAllNames();
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while trying to find all ingredient names: {}", e.getMessage(), e);
            throw new UnexpectedDataErrorExpception("Data access error occurred while trying to find all ingredient names: " + e.getMessage(), e);
        }
    }

    public void saveIngredient(Ingredient ingredient) {
        try {
            ingredientsRepository.saveIngredient(ingredient);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while trying to save ingredient: {}", e.getMessage(), e);
            throw new UnexpectedDataErrorExpception("Data access error occurred while trying to save ingredient: " + e.getMessage(), e);
        }
    }

    public int getIdByIngredientName(String name) {
        try {
            return ingredientsRepository.getIdByIngredientName(name);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while trying to find ingredient by its name: {}", e.getMessage(), e);
            throw new UnexpectedDataErrorExpception("Data access error occurred while trying to find ingredient by its name: " + e.getMessage(), e);
        }
    }

    public Ingredient getIngredientById(int id) {
        try {
            return ingredientsRepository.getIngredientById(id);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while trying to find ingredient by its ID: {}", e.getMessage(), e);
            throw new UnexpectedDataErrorExpception("Data access error occurred while trying to find ingredient by its ID: " + e.getMessage(), e);
        }
    }

    public void deleteIngredient(Ingredient ingredient) {
        try {
            ingredientsRepository.deleteIngredient(ingredient);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while trying to delete ingredient: {}", e.getMessage(), e);
            throw new UnexpectedDataErrorExpception("Data access error occurred while trying to delete ingredient: " + e.getMessage(), e);
        }
    }

    public void editIngredient(Ingredient ingredient, int ingredientId) {
        try {
            ingredientsRepository.editIngredient(ingredient, ingredientId);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while trying to edit ingredient: {}", e.getMessage(), e);
            throw new UnexpectedDataErrorExpception("Data access error occurred while trying to edit ingredient: " + e.getMessage(), e);
        }
    }

    public Ingredient findByProperty(String property, Object value) {
        try {
            return ingredientsRepository.findByProperty(property, value);
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while trying to find ingredient by property: {}", e.getMessage(), e);
            throw new UnexpectedDataErrorExpception("Data access error occurred while trying to find ingredient by property: " + e.getMessage(), e);
        }
    }

    public List<Ingredient> findAllIngredients() {
        try {
            return ingredientsRepository.findAll();
        } catch (DataAccessException e) {
            logger.error("Data access exception occurred while trying to find all ingredients: {}", e.getMessage(), e);
            throw new UnexpectedDataErrorExpception("Data access error occurred while trying to find all ingredients: " + e.getMessage(), e);
        }
    }
}