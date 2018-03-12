package me.sly.service;

import me.sly.commands.IngredientCommand;
import org.springframework.transaction.annotation.Transactional;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    @Transactional
    IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand);

    void deleteById(Long recipeId, Long ingredientId);
}
