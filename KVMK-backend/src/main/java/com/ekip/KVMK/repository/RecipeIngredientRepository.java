package com.ekip.KVMK.repository;



import com.ekip.KVMK.entities.Recipe_ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientRepository extends JpaRepository<Recipe_ingredient, Long> {

}
