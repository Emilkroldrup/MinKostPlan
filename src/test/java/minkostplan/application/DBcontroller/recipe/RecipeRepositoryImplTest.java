package minkostplan.application.DBcontroller.recipe;

import minkostplan.application.entity.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.mockito.Mockito.verify;

@SpringBootTest
class RecipeRepositoryImplTest {

    @Mock
    private RecipeRepository recipeRepository;
    private Recipe recipe;

    @BeforeEach
    void setUp() {
        Recipe recipe = new Recipe("Flæskesteg", "John Doe", 90, LocalDateTime.now());
    }

    @Test
    void saveRecipe(){
        recipeRepository.saveRecipe(recipe);
        verify(recipeRepository).saveRecipe(recipe);
    }

    @Test
    void deleteRecipe() {
        recipeRepository.deleteRecipe(recipe);
        verify(recipeRepository).deleteRecipe(recipe);
    }

    @Test
    void updateRecipe() {
        recipeRepository.updateRecipe(recipe);
        verify(recipeRepository).updateRecipe(recipe);
    }
}