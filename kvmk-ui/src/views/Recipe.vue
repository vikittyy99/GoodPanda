<template>
  <div>
     <h3>{{message}}</h3>
      <button v-on:click="searchRecipes">
      Search
      </button>
      <b-table
          id="recipeTable"
          striped
          hover
          :items="recipes"
          :fields="fields"
          :current-page="currentPage"
          :per-page="0"
      >
        <template slot="top-row" slot-scope="{ fields }">
          <td v-for="(field, index) in fields" :key="field.id">
            <div v-if="index === fields.length - 1">
            </div>
            <div v-else>
              <input v-model="filters[field.key]" :placeholder="field.label">
            </div>
          </td>
        </template>
        <template v-slot:cell(ingredient)="data">

          <div v-for="ing in data.item.ingredient" :key="ing.id">
            <b>{{ing.name}}</b>

          </div>
        </template>
        <template v-slot:cell(recipe_ingredient)="data">
          <div v-for="quan in data.item.recipe_ingredient" :key="quan.ingredient_id">
            <em>{{quan.quantity}}</em>
          </div>
        </template>

        <div>
          employees.sort((a, b) => {
          return b.age - a.age;
          });
        </div>
        <template v-slot:cell(actions)="row" >
          <router-link :to="{name: 'RecipeTab', params: {id: row.item.id}}" class="btn-group">Read more</router-link>
          <button v-on:click="deleteRecipe(row.item.id)">Delete</button>
        </template>
      </b-table>
      <b-pagination
          @input="searchRecipes"
          v-model="currentPage"
          :total-rows="rows"
          :per-page="perPage"
          aria-controls="recipeTable">

      </b-pagination>
  </div><!--div таг, който да държи ВСИЧКИ останали компоненти-->
</template> <!--html тагове и подреждаме интерфейса-->

<script>
import RecipeService from '../services/recipe-service'

export default {
  name: 'Recipe',
  data () {
    return {
      message: '',
      currentPage: 1,
      rows: '',
      perPage: 3,
      recipes: [{
        id: '',
        name: '',
        preptime: '',
        serving: '',
        description: '',
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
      ],
      fields: [
        { key: 'name', label: 'Рецепта' },
        { key: 'preptime', label: 'Време' },
        { key: 'serving', label: 'Порции' },
        { key: 'ingredient', label: 'Продукти' },
        { key: 'recipe_ingredient', label: 'Количество' },
        { key: 'views', label: 'Преглеждания' },
        { key: 'actions', label: 'Действия' }
      ],
      filters: {
        name: '',
        ingredient: ''
      }
    }
  },
  mounted () {
    this.searchRecipes()
    // RecipeService.getAllRecipes()
    //   .then(
    //     response => {
    //       console.log(response)
    //       this.recipes = response.data
    //     },
    //     error => {
    //       this.content =
    //         (error.response && error.response.data) ||
    //         error.message ||
    //         error/* .toString() */
    //     })
  },
  methods: {
    searchRecipes () {
      RecipeService.getRecipesPage(this.filters, this.currentPage, this.perPage).then(
          response => {
            console.log(response)
            this.recipes = response.data.recipes
            this.rows = response.data.totalItems
          },
          error => {
            this.content =
                (error.response() && error.response.data) ||
                error.message ||
                error
          }
      )
    }
  },
  deleteRecipe (id) {
    RecipeService.deleteRecipeById(id).then(
        response => {
          this.message = response.data.recipes
          this.searchRecipes()
        },
        error => {
          this.content =
              (error.response() && error.response.data) ||
              error.message ||
              error.ToString()
        }
    )
  }
}

</script> <!--JavaScript и променливи-->

<style scoped>

</style> <!--css-->
