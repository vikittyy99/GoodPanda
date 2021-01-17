package com.ekip.KVMK.repository;

import  com.ekip.KVMK.entities.Ingredient;
import  com.ekip.KVMK.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    @Query("SELECT i FROM Ingredient i WHERE lower(i.name) = :name")
    Optional<Ingredient> findIngredientByName(String name);

    Ingredient findIngredientById(Long id);
}
