package com.ekip.KVMK.entities;


import javax.persistence.*;

@Entity
@Table(name = "recipe_ingredient")
public class Recipe_ingredient implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recipe_id")
    private Long recipe_id;

    @Column(name = "ingredient_id")
    private Long ingredient_id;

    @Column(name = "quantity")
    private String quantity;

    public Long getRecipe_id() {
        return recipe_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRecipe_id(Long recipe_id) {
        this.recipe_id = recipe_id;
    }

    public Long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

