<template>
  <div>
    <h3>{{message}}</h3>
    <div>
      <b-input-group>
        <template #prepend>
          <b-dropdown :text="searchLabel" variant="info">
            <b-dropdown-item v-on:click="setSearchLabel('Рецепти')" >Рецепти</b-dropdown-item>
            <b-dropdown-item v-on:click="setSearchLabel('Продукти')">Продукти</b-dropdown-item>
          </b-dropdown>
        </template>

        <b-form-input v-model="search"></b-form-input>

        <template #append>
          <div v-if="searchLabel==='Рецепти'">
            <b-button v-on:click="searchRecipes" style="background-color: #5ac18e">
              Търси
            </b-button>
          </div>
          <div v-if="searchLabel==='Продукти'">
            <b-button v-on:click="searchRecipesByIngredient" style="background-color: #5ac18e">
              Търси
            </b-button>
          </div>
        </template>
      </b-input-group>
      <br/>
    </div>
    <b-table class="format"
             id="recipeTable"
             striped
             hover
             :items="recipes"
             :fields="fields"
             :current-page="currentPage"
             :per-page="0"
    >
      <!--        <template slot="top-row" slot-scope="{ fields }">-->
      <!--          <td v-for="(field, index) in fields" :key="field.id">-->
      <!--            <div v-if="index === fields.length - 1">-->
      <!--            </div>-->
      <!--            <div v-else>-->
      <!--              <input v-model="filters[field.key]" :placeholder="field.label">-->
      <!--            </div>-->
      <!--          </td>-->
      <!--        </template>-->
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
        <router-link :to="{name: 'RecipeTab', params: {id: row.item.id}}" class="btn-outline-dark">Read more</router-link>
        <b-button v-on:click="deleteRecipe(row.item.id)" variant="light">Изтрий</b-button>
      </template>
    </b-table>
    <b-pagination
        @input="searchRecipes"
        v-model="currentPage"
        pills :total-rows="rows"
        :per-page="perPage"
        prev-text="⏪"
        next-text="⏩"
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
      searchLabel: 'Рецепти',
      currentPage: 1,
      rows: '',
      perPage: 5,
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
        // { key: 'ingredient', label: 'Продукти' },
        // { key: 'recipe_ingredient', label: 'Количество' },
        { key: 'views', label: 'Преглеждания' },
        { key: 'actions', label: 'Действия' }
      ],
      filters: {
        name: '',
        ingredient: ''
      },
      search: ''
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
      RecipeService.getRecipesPage(this.search, this.currentPage, this.perPage, '').then(
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
    },
    searchRecipesByIngredient () {
      RecipeService.getRecipesPage(this.search, this.currentPage, this.perPage, this.search).then(
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
    },
    deleteRecipe (id) {
      RecipeService.deleteRecipeById(id).then(
        response => {
          this.message = response.data.recipes
          this.searchRecipes()
        },
        error => {
          this.content =
              (error.response() && error.response.data)
          error.message ||
          error.ToString()
        }
      )
    },
    setSearchLabel (choice) {
      this.searchLabel = choice
    }
  }
}

</script> <!--JavaScript и променливи-->

<style scoped>
.format{
  background-color: #ffd29a;
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
  padding-left: 30px;
}
</style> <!--css-->
