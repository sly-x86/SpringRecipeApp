package me.sly.service;

import me.sly.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipies();

    Recipe findById(Long id);
}
