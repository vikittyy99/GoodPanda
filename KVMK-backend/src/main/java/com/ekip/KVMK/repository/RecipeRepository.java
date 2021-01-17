package com.ekip.KVMK.repository;


import com.ekip.KVMK.entities.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT r FROM Recipe r WHERE lower(r.name) = :name")
    Optional<Recipe> findRecipeByName(String name);

    @Query("SELECT r FROM Recipe r " +
            "WHERE lower(r.name) " +
            "LIKE :#{#name == null || #name.isEmpty()? '%' : '%'+#name+'%'} ")
    Page<Recipe> findPageRecipes(Pageable pageable, String name);

    @Query("SELECT r FROM Recipe r LEFT JOIN r.ingredient i " +
            "WHERE lower(i.name) " +
            "LIKE :#{#ingredient == null || #ingredient.isEmpty()? '%' : '%'+#ingredient+'%'} ")
    Page<Recipe> findPageRecipes(String ingredient, Pageable pageable);
}