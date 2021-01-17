<template>
  <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group
          id="input-group-1"
          label="Име на рецептата:"
          label-for="input-1"
          description=""
      >
        <b-form-input
            id="input-1"
            v-model="form.name"
            type="name"
            placeholder="Име на рецептата"
            required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-3" label="Категория:" label-for="input-3">
        <b-form-select
            id="input-3"
            v-model="category"
            :options="foods"
            required
        ></b-form-select>
      </b-form-group>

      <b-form-group id="input-group-2" label="Начин на приготвяне:" label-for="input-2">
        <b-form-textarea
            id="textarea"
            v-model="form.text"
            placeholder="Начин на приготвяне"
            rows="3"
            max-rows="6"
        ></b-form-textarea>

      </b-form-group>


      <b-button type="submit" variant="primary">Submit</b-button>

    </b-form>

  </div>
</template>

<script>
import RecipeService from '@/services/recipe-service'

export default {
  name: 'Recipe',
  data () {
    return {
      category: null,

      form: {
        name: '',
        food: null,
        text: '',
      },
      foods: [{
        text: 'Изберете категория',
        value: null
      },
        {
        value: 1, text: 'Основни'
        },

        {
          value: 2, text:'Предястия'

        },
        {
          value: 3, text:'Салати'

        },
        {
          value: 4, text:'Закуски'

        },
        {
          value: 5, text:'Десерти'

        },
        {
          value: 6, text:'Напитки'

        },
        {
          value: 7, text:'Други'

        },
        ],
      show: true
    }
  },
  methods: {

    onSubmit (event) {
      event.preventDefault()
       const form = {
         name: this.form.name,
         description: this.form.text,
       }
      RecipeService.saveRecipe(form).then(
          response => {
            this.form.name = "";
            this.form.text="";
          }
      )
      console.log(this.category)



    },

  }
}
</script>

<style scoped>

</style>
