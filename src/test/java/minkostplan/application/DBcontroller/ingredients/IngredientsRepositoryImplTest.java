package minkostplan.application.DBcontroller.ingredients;

import minkostplan.application.entity.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class IngredientsRepositoryImplTest {

    @Mock
    private IngredientsRepository ingredientsRepository;
    private Ingredient ingredient;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ingredient = new Ingredient(1L, "Mælk", "Arla Skummemælk");
    }

    @Test
    public void saveIngredient() {
        ingredientsRepository.saveIngredient(ingredient);
        verify(ingredientsRepository).saveIngredient(ingredient);
    }

    @Test
    public void deleteIngredient() {
        ingredientsRepository.deleteIngredient(ingredient);
        verify(ingredientsRepository).deleteIngredient(ingredient);
    }

    @Test
    public void editIngredient() {
        when(ingredientsRepository.getIdByIngredientName("Mælk")).thenReturn(1);
        int ingredientId = ingredientsRepository.getIdByIngredientName("Mælk");
        when(ingredientsRepository.getIngredientById(1)).thenReturn(ingredient);
        ingredient = ingredientsRepository.getIngredientById(ingredientId);
        ingredient.setName("Skummemælk");
        ingredientsRepository.editIngredient(ingredient, ingredientId);
        verify(ingredientsRepository).editIngredient(ingredient, ingredientId);
    }
}