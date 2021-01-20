<template>
  <div>
    <em>
    <div v-if="recipes.category_id === 1">
      Основни
    </div>
    <div v-if="recipes.category_id === 2">
      Предястия
    </div>
    <div v-if="recipes.category_id === 3">
      Салати
    </div>
    <div v-if="recipes.category_id === 4">
      Закуси
    </div>
    <div v-if="recipes.category_id === 5" >
      Десерти
    </div>
    <div v-if="recipes.category_id === 6" >
      Напитки
    </div>
    <div v-if="recipes.category_id === 7" >
      Други
    </div>
    </em>
    <div v-if="recipes.category_id === 1" class="img-fluid" >
      <img src="https://icons.iconarchive.com/icons/graphicloads/food-drink/72/chicken-icon.png">
    </div>
    <div v-if="recipes.category_id === 2" class="img-fluid" >
      <img src="https://icons.iconarchive.com/icons/graphicloads/food-drink/72/dish-icon.png">
    </div>
    <div v-if="recipes.category_id === 3" class="img-fluid" >
      <img src="https://icons.iconarchive.com/icons/graphicloads/food-drink/72/tomato-icon.png">
    </div>
    <div v-if="recipes.category_id === 4" class="img-fluid" >
      <img src="https://icons.iconarchive.com/icons/graphicloads/food-drink/72/egg-icon.png">
    </div>
    <div v-if="recipes.category_id === 5" class="img-fluid" >
      <img src="https://icons.iconarchive.com/icons/graphicloads/food-drink/72/icecream-icon.png">
    </div>
    <div v-if="recipes.category_id === 6" class="img-fluid" >
      <img src="https://icons.iconarchive.com/icons/graphicloads/food-drink/72/tea-icon.png">
    </div>
    <div v-if="recipes.category_id === 7" class="img-fluid" >
      <img src="https://icons.iconarchive.com/icons/graphicloads/food-drink/72/catering-icon.png">
    </div>
    <br/>
      <h1 class = "title">
        {{recipes.name}}
      </h1>
    <br/><br/>
    <div v-for="ing in recipes.ingredient" :key="ing.id">
    <b>{{ing.name}}</b>
      <div v-for="quan in recipes.recipe_ingredient" :key="quan.ingredient_id">
        <div v-if="ing.id === quan.ingredient_id">
        <em>{{quan.quantity}}</em>
        </div>
      </div>
    </div>
    <br/><br/>
    <div>
      <b>Време за приготвяне:</b> <em>{{recipes.preptime}} минути    </em><br/>
      <b style="margin-left: 10px">Количество:</b> <em>{{recipes.serving}} порции</em>
    </div>
    <br/><br/>
    <h5><em><b>Начин на приготвяне:</b></em></h5><br/>
    {{recipes.description}}
    <br/><br/><br/>
<!--<input v-model="recipes.name" placeholder="Попълни ме" type="text">
<input v-model="recipes.ingredient" placeholder="Попълни ме" type="text">
<input v-model="recipes.quantity" placeholder="Попълни ме" type="text">-->
</div>
</template>
<script>
import RecipeService from '../services/recipe-service'

export default {
  name: 'RecipeTab',

  data () {
    return {
      recipes: {
        id: '',
        name: '',
        preptime: '',
        serving: '',
        description: '',
        category_id: '',
        views: '',
        ingredient:
            {
              name: '',
              id: ''
            },
        recipe_ingredient:
            {
              recipe_id: '',
              ingredient_id: '',
              quantity: ''
            }
      }

    }
  },
  beforeRouteEnter (to, from, next) {
    if (to.params.id) {
      RecipeService.getRecipeById(to.params.id).then(
        response => {
          next(vm => vm.setData(response))
        }
      )
    } else {
      next()
    }
  },
  methods:
      {
        setData (response) {
          this.recipes = response.data
        }
        // getRecipeById() {
        //   RecipeService.getRecipeById(this.recipes).then(
        //       response =>{
        //         this.recipes = response.data.recipes
        //       },
        //       error => {
        //         this.content =
        //             (error.response() && error.response.data) ||
        //             error.message ||
        //             error.ToString()
        //
        //       }
        //   )
        // }
      }
}
</script>

<style scoped>
.title{
  color: #ff7700;
  font-family: "Comic Sans MS";
}

</style>
