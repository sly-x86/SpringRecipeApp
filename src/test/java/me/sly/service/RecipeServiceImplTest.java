package me.sly.service;

import me.sly.domain.Recipe;
import me.sly.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipies() {
        Recipe recipe = new Recipe();
        HashSet recipiesData = new HashSet();
        recipiesData.add(recipe);

        when(recipeService.getRecipies()).thenReturn(recipiesData);

        Set<Recipe> recipes = recipeService.getRecipies();
        assertEquals(recipes.size(), 1);

        verify(recipeRepository, times(1)).findAll();
    }
}