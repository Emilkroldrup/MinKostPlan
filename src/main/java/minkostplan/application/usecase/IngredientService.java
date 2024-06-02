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
        try {
            ingredientsRepository.saveIngredient(ingredient);
        } catch (DataAccessException dataAccessException) {
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
    }

    public int getIdByIngredientName(String name) {
        try {
            return ingredientsRepository.getIdByIngredientName(name);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            System.out.println("No such name exists for ingredient" + emptyResultDataAccessException.getMessage());
        } catch (DataAccessException dataAccessException) {
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
        return -1;
    }

    public Ingredient getIngredientById(int id) {
        try {
            return ingredientsRepository.getIngredientById(id);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            System.out.println("No such id exists for ingredient" + emptyResultDataAccessException.getMessage());
        } catch (DataAccessException dataAccessException) {
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
        return null;
    }

    public void deleteIngredient(Ingredient ingredient) {
        try {
            ingredientsRepository.deleteIngredient(ingredient);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            System.out.println("No such ingredient exists" + emptyResultDataAccessException.getMessage());
        } catch (DataAccessException dataAccessException) {
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
    }

    public void editIngredient(Ingredient ingredient, int ingredientId){
        try{
            ingredientsRepository.editIngredient(ingredient,ingredientId);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            System.out.println("No such id for an ingredient exists" + emptyResultDataAccessException.getMessage());
        } catch (DataAccessException dataAccessException) {
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
    }
    public Ingredient findByProperty(String property, Object value){
        try{
            return ingredientsRepository.findByProperty(property,value);
        } catch (DataAccessException dataAccessException) {
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
        return null;
    }
    public List<Ingredient> findAll(){
        try {
            return ingredientsRepository.findAll();
        }catch (DataAccessException dataAccessException) {
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
        return null;
    }
}
