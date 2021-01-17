<template>

</template>

<script>
import RecipeService from '../services/recipe-service'

export default {
  name: 'RecipeTab',
  data() {
    return {
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
      beforeRouteEnter(to, from, next) {
        RecipeService.getRecipe(to.params.name).then(
            response => {
              next(vm =>
                  vm.setData(response)
              )
            }
        )
      }
    }
  }
}

</script>
