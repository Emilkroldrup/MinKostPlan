package minkostplan.application.DBcontroller.ingredients;

import minkostplan.application.entity.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
class IngredientsRepositoryImplTest {

    @Mock
    private IngredientsRepository ingredientsRepository;
    private Ingredient ingredient;

    @BeforeEach
    void setUp() {
        Ingredient ingredient = new Ingredient(1L, "Mælk", "Arla Skummemælk");
    }

    @Test
    void saveIngredient() {
        ingredientsRepository.saveIngredient(ingredient);
        verify(ingredientsRepository).saveIngredient(ingredient);
    }

    @Test
    void deleteIngredient() {
        ingredientsRepository.deleteIngredient(ingredient);
        verify(ingredientsRepository).deleteIngredient(ingredient);
    }

    @Test
    void editIngredient() {
        ingredientsRepository.editIngredient(ingredient);
        verify(ingredientsRepository).editIngredient(ingredient);
    }
}