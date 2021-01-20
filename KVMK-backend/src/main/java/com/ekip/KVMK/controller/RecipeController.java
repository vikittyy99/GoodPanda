package com.ekip.KVMK.controller;


import com.ekip.KVMK.Validation.EmailValidation;
import com.ekip.KVMK.beans.RecipeRequest;
import com.ekip.KVMK.entities.Ingredient;
import  com.ekip.KVMK.entities.Recipe;
import  com.ekip.KVMK.entities.Recipe_ingredient;
import  com.ekip.KVMK.entities.Users;
import  com.ekip.KVMK.repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("recipe")

public class RecipeController {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final UserRepositoryLogin userLogin;
    private final UserRepository userRepository;

    private int counter = 0;

    public RecipeController(RecipeRepository recipeRepository, RecipeIngredientRepository recipeIngredientRepository, IngredientRepository ingredientRepository,UserRepository userRepository, UserRepositoryLogin userLogin) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
        this.userRepository=userRepository;

        this.userLogin = userLogin;
    }


    @GetMapping("/all")
    public List<Recipe> getAllRecipes(){
        return recipeRepository.findAll();
    }

    @GetMapping("/ingredients")
    public ResponseEntity<?> getAllIngredients(){
        List<Ingredient> response =  ingredientRepository.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search/page")
    public ResponseEntity<?> paginateRecipe(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                            @RequestParam(value = "perPage", defaultValue = "3") int perPage,
                                            @RequestParam(required = false) String name,
                                            @RequestParam(required = false) String ingredient){

        Pageable pageable = PageRequest.of(currentPage - 1, perPage);

        Page<Recipe> recipes = ingredient.isBlank() || ingredient==null?
                recipeRepository.findPageRecipes(
                        pageable,
                        name == null? "" : name.trim().toLowerCase()) :
                recipeRepository.findPageRecipes(
                        ingredient == null? "" : ingredient.trim().toLowerCase(),
                        pageable);


        Map<String, Object> response = new HashMap<>();
        response.put("recipes", recipes.getContent());
        response.put("currentPage", recipes.getNumber()+1);
        response.put("totalItems", recipes.getTotalElements());
        response.put("totalPages", recipes.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/search/id")
    public Optional<Recipe> getRecipeById(@RequestParam(required = false) Long id)
    {
        Recipe recipe= recipeRepository.findRecipeById(id).get();
        recipe.setViews(recipe.getViews()+1);
        recipeRepository.save(recipe);

        return recipeRepository.findRecipeById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<?> getRecipe(@RequestParam(required = false) String name){

        if(name == null || name.isBlank()) {
            return ResponseEntity.ok().body("За да видите рецептата ");
        }

        Optional<Recipe> result = recipeRepository.findRecipeByName(name.toLowerCase());
        return result.isPresent()? ResponseEntity.ok(result.get()) : ResponseEntity.ok("Няма намерена рецепта!");
        //Optional<Recipe> result = recipeRepository.findById(id);
        //return result.orElse(null);
    }


    @GetMapping("/save")
    public ResponseEntity<?> saveRecipe(@RequestParam(required = false) String name,
                                        @RequestParam(required = false) String ingr,
                                        @RequestParam(required = false) String quan,
                                        @RequestParam(required = false) Integer preptime,
                                        @RequestParam(required = false) Integer serving,
                                        @RequestParam(required = false) Integer category_id,
                                        @RequestParam(required = false) String description,
                                        @RequestParam(required = false) Long id,
                                        Recipe recipe){

        //RecipeRequest form = new RecipeRequest();
        //проверка
        List<String> arr =  Arrays.asList(ingr.split("\\s*,\\s*"));
//        arr.add("Мляко");
//        arr.add("Ориз");
//        arr.add(ingr);

        List<String> arr2 = Arrays.asList(quan.split("\\s*,\\s*"));
//        arr2.add("1 л");
//        arr2.add("500 гр");
//        arr2.add(quan);

//        form.setCategory_id(3);
//        form.setDescription("Варите ориза в млякото.");
//        form.setIngredient(arr);
//        form.setName("Мляко с ориз");
//        form.setPreptime(20);
//        form.setRecipe_ingredient(arr2);
//        form.setServing(4);
//        form.setViews(0);


        Boolean isNew = recipeRepository.findRecipeByName(name.toLowerCase()).isEmpty();

        counter = 0;

        recipe =
                new Recipe(
                        isNew? id : recipeRepository.findRecipeByName(name.toLowerCase()).get().getId(),
                        name,
                        preptime,
                        serving,
                        description,
                        category_id);

        recipe = recipeRepository.save(recipe);
        Map<String, Object> response = new HashMap<>();
        response.put("generatedId", recipe.getId());

        for(String i: arr){
            Optional<Ingredient> ingredient = ingredientRepository.findIngredientByName(i.toLowerCase());

            Recipe_ingredient recipe_ingredient = new Recipe_ingredient();
            if(!ingredient.isPresent()){
                Ingredient ing = new Ingredient();
                ing.setName(i);
                ing = ingredientRepository.save(ing);

                recipe_ingredient.setIngredient_id(ing.getId());

            }
            else {
                recipe_ingredient.setIngredient_id(ingredient.get().getId());
            }

            recipe_ingredient.setRecipe_id(recipe.getId());
            recipe_ingredient.setQuantity(arr2.get(counter));

            recipe_ingredient = recipeIngredientRepository.save(recipe_ingredient);
            counter++;
        }


        if(isNew){
            response.put("message", "Рецептата за "  + recipe.getName() + " беше успешно записана!");
        }
        else{

            response.put("message", "Рецептата за " + recipe.getName() + " беше успешно обновена!");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRecipe(@RequestParam Long id){
        if(!recipeRepository.existsById(id)){
            return ResponseEntity.ok("Няма такава рецепта!");
        }
        String name = recipeRepository.findById(id).get().getName();
        recipeRepository.deleteById(id);
        return ResponseEntity.ok("Рецептата за " + name + " беше успешно изтрита!");
    }

    /*BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();*/

    @GetMapping("/register")
    public ResponseEntity<String> Registration (Users users)
    {
      /*  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        users.setPassword(passwordEncoder.encode(users.getPassword()));
*/

        userRepository.save(users);
        System.out.println(users);
        /*users.setPassword(passwordEncoder.encode(users.getPassword()));*/
        return ResponseEntity.ok("register_success");
    }


    @GetMapping("/authenticate")
    public ResponseEntity<String> Login (Users users)
    {


        String email = users.getEmail();

        String password = users.getPassword();

        Users user = userLogin.authenticate(email, password);

        System.out.println(password);
        boolean status = EmailValidation.validate(email);


        if(user == null & !status)
        {

            //Nqma potrebitel
            return   ResponseEntity.ok().body("login_failed");

        }

        return ResponseEntity.ok("login_success");
    }

}

