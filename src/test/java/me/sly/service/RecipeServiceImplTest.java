package me.sly.service;

import me.sly.converters.RecipeCommandToRecipe;
import me.sly.converters.RecipeToRecipeCommand;
import me.sly.domain.Recipe;
import me.sly.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getRecipeByIdTest() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);
        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    public void getRecipies() {
        Recipe recipe = new Recipe();
        HashSet recipiesData = new HashSet();
        recipiesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipiesData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);

        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteById() {
        // given
        Long idToDelete = Long.valueOf(2L);
        // when
        recipeService.deleteById(idToDelete);
        // no 'when', since method has void return type
        // then
        verify(recipeRepository, times(1)).deleteById(anyLong());
    }
}