<template>
  <div>
    <b-form @submit="onSubmit"  v-if="show">
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
            v-model="category_id"
            :options="category"
            required
        ></b-form-select>
      </b-form-group>

<!--      <b-form-group id="input-group-6" label="Продукти:" label-for="input-2">-->
<!--        <b-form-input-->
<!--            id="input6"-->
<!--            v-model="form.ingredients"-->
<!--            placeholder="Продукт"-->
<!--            required-->
<!--        ></b-form-input>-->
<!--      </b-form-group>-->
<!--      <b-form-group id="input-group-7" label="Количество:" label-for="input-3">-->
<!--        <b-form-input-->
<!--            id="input7"-->
<!--            v-model="form.quan"-->
<!--            placeholder="Количество"-->

<!--            required-->
<!--        ></b-form-input>-->
<!--      </b-form-group>-->
      <b-form-group
          id="input-group-7"
          label="Продукт:"
          label-for="input-7"
          description=""
      >
        <b-form-input
            id="input-7"
            v-model="form.ingredients"
            type="name"
            placeholder="Продукт"
            required
        ></b-form-input>
      </b-form-group>
      <b-form-group
          id="input-group-8"
          label="Количество:"
          label-for="input-8"
          description=""
      >
        <b-form-input
            id="input-8"
            v-model="form.quan"
            type="name"
            placeholder="Количество"
            required
        ></b-form-input>
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
      <b-form-group
          id="input-group-4"
          label="Порции"
          label-for="input-4"
          description=""
      >
        <b-form-input
            id="input-4"
            v-model="form.serving"
            type="name"
            placeholder="Порции"
            required
        ></b-form-input>
      </b-form-group>
      <b-form-group
          id="input-group-5"
          label="Време на приготвяне"
          label-for="input-5"
          description=""
      >
        <b-form-input
            id="input-5"
            v-model="form.preptime"
            type="name"
            placeholder="Време на приготвяне"
            required
        ></b-form-input>
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
      category_id: null,
      form: {
        ingredients: '',
        quan: '',
        name: '',
        text: '',
        preptime: '',
        serving: '',
        /* category_id: null, */
        checked: []
      },
      category: [{
        text: 'Изберете категория',
        value: null
      },
      {
        value: 1, text: 'Основни'
      },

      {
        value: 2, text: 'Предястия'
      },
      {
        value: 3, text: 'Салати'
      },
      {
        value: 4, text: 'Закуски'
      },
      {
        value: 5, text: 'Десерти'
      },
      {
        value: 6, text: 'Напитки'
      },
      {
        value: 7, text: 'Други'
      }
      ],
      show: true
    }
  },
  methods: {
    addIngredient (e) {
      e.preventDefault()
    },
    onSubmit (event) {
      event.preventDefault()
      const form = {
        name: this.form.name,
        description: this.form.text,
        preptime: this.form.preptime,
        serving: this.form.serving,
        ingredients: this.form.ingredients,
        quan: this.form.quan,
        category_id: this.category_id

      }
      RecipeService.saveRecipe(form).then(
        response => {
          this.form.name = ''
          this.form.text = ''
          this.form.serving = ''
          this.form.preptime = ''
          this.form.ingredients = ''
          this.form.quan = ''
          this.category_id = ''
        }
      )
      console.log(this.category_id)
    }
  }
}
</script>

<style scoped>

</style>
