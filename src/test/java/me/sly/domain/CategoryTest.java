package me.sly.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Test
    public void getId() {
        Long idValue = 4L;
        category = new Category();
        category.setId(idValue);
        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}