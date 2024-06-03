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
            recepiIngredientRepository.saveRecipeIngredient(recipeIngredient);
    }

    public RecipeIngredient findByProperty(String property, Object value){
          return recepiIngredientRepository.findByProperty(property,value);
    }

    public List<RecipeIngredient> findAllRecipeIngredients(){
            return recepiIngredientRepository.findAll();
    }

}
