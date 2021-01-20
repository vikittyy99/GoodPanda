package com.ekip.KVMK.repository;

import  com.ekip.KVMK.entities.Ingredient;
import  com.ekip.KVMK.entities.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    @Query("SELECT i FROM Ingredient i WHERE lower(i.name) = :name")
    Optional<Ingredient> findIngredientByName(String name);

    Ingredient findIngredientById(Long id);

//    @Query("SELECT i FROM Recipe i LEFT JOIN i.recipe_ingredient i" +
//            "WHERE lower(i.name) " +
//            "LIKE :#{#ingredient == null || #ingredient.isEmpty()? '%' : '%'+#ingredient+'%'} ")
//
//    Page<Ingredient> findPageRecipes(String ingredient, Pageable pageable);


}
