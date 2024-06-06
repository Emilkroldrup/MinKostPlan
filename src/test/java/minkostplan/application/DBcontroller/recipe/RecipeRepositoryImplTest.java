package minkostplan.application.DBcontroller.recipe;

import minkostplan.application.entity.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class RecipeRepositoryImplTest {

    @Mock
    private RecipeRepository recipeRepository;

    private Recipe updateRecipe;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updateRecipe = new Recipe("Flæskesteg", "John Doe", 90, LocalDateTime.now(), "Flæskesvær","morgenmad");
    }

    @Test
    void saveRecipe(){
        recipeRepository.saveRecipe(updateRecipe);
        verify(recipeRepository).saveRecipe(updateRecipe);
    }

    @Test
    void deleteRecipe() {
        recipeRepository.deleteRecipe(updateRecipe);
        verify(recipeRepository).deleteRecipe(updateRecipe);
    }

    @Test
    void updateRecipe() {
        when(recipeRepository.getIdByRecipeName("Flæskesteg")).thenReturn(1);
        int recipeId = recipeRepository.getIdByRecipeName("Flæskesteg");
        when(recipeRepository.getRecipeById(1)).thenReturn(updateRecipe);
        updateRecipe = recipeRepository.getRecipeById(recipeId);
        updateRecipe.setAverageTime(40);
        recipeRepository.editRecipe(updateRecipe, recipeId);
        verify(recipeRepository).editRecipe(updateRecipe, recipeId);
    }
}