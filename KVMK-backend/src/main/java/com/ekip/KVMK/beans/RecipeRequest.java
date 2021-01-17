package com.ekip.KVMK.beans;

import java.util.List;

public class RecipeRequest {

    Long id;
    String name;
    Integer preptime;
    Integer serving;
    String description;
    Integer views;
    Integer category_id;
    List<String> ingredient;
    List<String> recipe_ingredient;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPreptime() {
        return preptime;
    }

    public void setPreptime(Integer preptime) {
        this.preptime = preptime;
    }

    public Integer getServing() {
        return serving;
    }

    public void setServing(Integer serving) {
        this.serving = serving;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public List<String> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<String> ingredient) {
        this.ingredient = ingredient;
    }

    public List<String> getRecipe_ingredient() {
        return recipe_ingredient;
    }

    public void setRecipe_ingredient(List<String> recipe_ingredient) {
        this.recipe_ingredient = recipe_ingredient;
    }
}
