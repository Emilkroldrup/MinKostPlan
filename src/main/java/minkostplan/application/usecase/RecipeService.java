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
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
    }

    public int getIdByRecipeName(String name){
        try {
            return  recipeRepository.getIdByRecipeName(name);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException){
            System.out.println("No recipe with the given name" + emptyResultDataAccessException.getMessage());
        }
        catch (DataAccessException dataAccessException){
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
          return -1;
        }

    public Recipe getRecipeById(int id){
        try {
            return  recipeRepository.getRecipeById(id);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException){
            System.out.println("No recipe with the given id" + emptyResultDataAccessException.getMessage());
        }  catch (DataAccessException dataAccessException){
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
        return null;
    }

    public void deleteRecipe(Recipe recipe) {
        try {
            recipeRepository.deleteRecipe(recipe);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException){
            System.out.println("No recipe like that exists" + emptyResultDataAccessException.getMessage());
        }catch (DataAccessException dataAccessException){
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
    }

    public void editRecipe(Recipe recipe, int recipeId) {
        try {
            recipeRepository.editRecipe(recipe, recipeId);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            System.out.println("No recipe like that exists" + emptyResultDataAccessException.getMessage());
        } catch (DataAccessException dataAccessException) {
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
    }

    public Recipe findByProperty(String property, Object value) {
        try {
            return recipeRepository.findByProperty(property, value);
        } catch (DataAccessException dataAccessException) {
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
        return null;
    }

    public List<Recipe> findAllRecipes(){
        try{
            return  recipeRepository.findAll();
        } catch (DataAccessException dataAccessException){
            System.out.println("Error connecting to database" + dataAccessException.getMessage());
        }
          return null;
    }




    }

