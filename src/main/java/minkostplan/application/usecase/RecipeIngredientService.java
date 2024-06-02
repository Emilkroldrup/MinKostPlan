package minkostplan.application.usecase;

import minkostplan.application.DBcontroller.recipeingredient.RecepiIngredientRepository;
import minkostplan.application.entity.Recipe;
import minkostplan.application.entity.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientService {

    private final RecepiIngredientRepository recepiIngredientRepository;
    @Autowired
    public  RecipeIngredientService(RecepiIngredientRepository recepiIngredientRepository){
        this.recepiIngredientRepository = recepiIngredientRepository;
    }

    public void saveRecipeIngredient(RecipeIngredient recipeIngredient){
        try {
            recepiIngredientRepository.saveRecipeIngredient(recipeIngredient);
        } catch (DataAccessException dataAccessException){
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
    }

    public RecipeIngredient findByProperty(String property, Object value){
        try {
          return recepiIngredientRepository.findByProperty(property,value);
        } catch (DataAccessException dataAccessException){
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
        return null;
    }

    public List<RecipeIngredient> findAllRecipeIngredients(){
        try {
            return recepiIngredientRepository.findAll();
        }catch (DataAccessException dataAccessException){
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
        return null;
    }

}
