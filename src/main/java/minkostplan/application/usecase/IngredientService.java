package minkostplan.application.usecase;

import minkostplan.application.DBcontroller.ingredients.IngredientsRepository;
import minkostplan.application.entity.Ingredient;
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
        } catch (DataAccessException dataAccessException) {
            logger.error("Error finding all ingredient names: {}", dataAccessException.getMessage());
            throw dataAccessException;
        }
    }

    public void saveIngredient(Ingredient ingredient) {
        try {
            ingredientsRepository.saveIngredient(ingredient);
        } catch (DataAccessException dataAccessException) {
            logger.error("Error saving ingredient: {}", dataAccessException.getMessage());
            throw dataAccessException;
        }
    }

    public int getIdByIngredientName(String name) {
        try {
            return ingredientsRepository.getIdByIngredientName(name);
        } catch (DataAccessException dataAccessException) {
            logger.error("Error getting ID by ingredient name: {}", dataAccessException.getMessage());
            throw dataAccessException;
        }
    }

    public Ingredient getIngredientById(int id) {
        try {
            return ingredientsRepository.getIngredientById(id);
        } catch (DataAccessException dataAccessException) {
            logger.error("Error getting ingredient by ID: {}", dataAccessException.getMessage());
            throw dataAccessException;
        }
    }

    public void deleteIngredient(Ingredient ingredient) {
        try {
            ingredientsRepository.deleteIngredient(ingredient);
        } catch (DataAccessException dataAccessException) {
            logger.error("Error deleting ingredient: {}", dataAccessException.getMessage());
            throw dataAccessException;
        }
    }

    public void editIngredient(Ingredient ingredient, int ingredientId) {
        try {
            ingredientsRepository.editIngredient(ingredient, ingredientId);
        } catch (DataAccessException dataAccessException) {
            logger.error("Error editing ingredient: {}", dataAccessException.getMessage());
            throw dataAccessException;
        }
    }

    public Ingredient findByProperty(String property, Object value) {
        try {
            return ingredientsRepository.findByProperty(property, value);
        } catch (DataAccessException dataAccessException) {
            logger.error("Error finding ingredient: {}", dataAccessException.getMessage());
            throw dataAccessException;
        }
    }

    public List<Ingredient> findAllIngredients() {
        try {
            return ingredientsRepository.findAll();
        } catch (DataAccessException dataAccessException) {
            logger.error("Error finding all ingredients: {}", dataAccessException.getMessage());
            throw dataAccessException;
        }
    }
}