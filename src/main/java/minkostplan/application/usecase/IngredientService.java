package minkostplan.application.usecase;

import minkostplan.application.DBcontroller.ingredients.IngredientsRepository;
import minkostplan.application.entity.Ingredient;
import minkostplan.application.entity.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {


    private final IngredientsRepository ingredientsRepository;

    @Autowired
    public IngredientService(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    public void saveIngredient(Ingredient ingredient) {
        ingredientsRepository.saveIngredient(ingredient);
    }

    public int getIdByIngredientName(String name) {
        return ingredientsRepository.getIdByIngredientName(name);
    }

    public Ingredient getIngredientById(int id) {
        return ingredientsRepository.getIngredientById(id);
    }

    public void deleteIngredient(Ingredient ingredient) {
        ingredientsRepository.deleteIngredient(ingredient);
    }

    public void editIngredient(Ingredient ingredient, int ingredientId) {
        ingredientsRepository.editIngredient(ingredient, ingredientId);
    }

    public Ingredient findByProperty(String property, Object value) {
        return ingredientsRepository.findByProperty(property, value);
    }

    public List<Ingredient> findAll() {
        return ingredientsRepository.findAll();
    }
}
