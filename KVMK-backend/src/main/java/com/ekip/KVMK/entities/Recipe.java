package com.ekip.KVMK.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "recipe")
public class Recipe implements java.io.Serializable{

    public Recipe() {
        this.views = 0;
    }

    public Recipe(Long id, String name, Integer preptime, Integer serving, String description, Integer category_id) {
        this.id = id;
        this.name = name;
        this.preptime = preptime;
        this.serving = serving;
        this.description = description;
        this.views = 0;
        this.category_id = category_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "preptime")
    private Integer preptime;

    @Column(name = "serving")
    private Integer serving;

    @Column(name = "description")
    private String description;

    @Column(name = "views")
    private Integer views;

    @Column(name = "category_id")
    private Integer category_id;

    //@JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "recipe_ingredient",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredient = new ArrayList<Ingredient>();

    //за да може във фронтенда да се изпише количеството за всеки продукт
    @OneToMany(mappedBy = "recipe_id")
    private List<Recipe_ingredient> recipe_ingredient;

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

    public List<Ingredient> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<Ingredient> ingredient) {
        this.ingredient = ingredient;
    }

    public List<Recipe_ingredient> getRecipe_ingredient() {
        return recipe_ingredient;
    }

    public void setRecipe_ingredient(List<Recipe_ingredient> recipe_ingredient) {
        this.recipe_ingredient = recipe_ingredient;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
