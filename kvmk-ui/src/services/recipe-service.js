import axios from 'axios'

const API_URL = 'http://localHost:8080/recipe'

class RecipeService {
  getAllRecipes () {
    return axios.get(API_URL + '/all') // .get, защото изпълнява get заявка; има и .post, .delete...
  }

  getAllIngredients () {
    return axios.get(API_URL + '/ingredients')
  }

  getRecipesPage (filters, currentPage, perPage, ingredient) {
    return axios.get(API_URL + '/search/page',
      {
        params:
        {
          name: filters,
          currentPage: currentPage,
          perPage: perPage,
          ingredient: ingredient
        }
      })
  }

  getRecipes () {
    return axios.get(API_URL + '/search',
      {
        params:
        {
          name: name
        }
      })
  }

  getRecipeById (id) {
    return axios.get(API_URL + '/search/id',
      {
        params:
        {
          id: id
        }
      })
  }

  saveRecipe (form) {
    return axios.get(API_URL + '/save',
      {
        params:
        {
          name: form.name,
          description: form.description,
          preptime: form.preptime,
          serving: form.serving,
          ingr: form.ingredients,
          quan: form.quan,
          request: 'category_id',
          category_id: form.category_id
        }
      }).then(response =>
    {
        return this.category_id = response.data
    })
  }

  register (form) {
    return axios.get(API_URL + '/register',
      {
        params:
        {
          name: form.name,
          email: form.email,
          password: form.password
        }
      })
  }

  login (form) {
    return axios.get(API_URL + '/authenticate',
      {
        headers: {
          'Access-Control-Allow-Origin': '*'
        },
        params:
            {
              email: form.email,
              password: form.password
            }
      }).then(response => {
      if (response.data.accessToken) {
        localStorage.setItem('user', JSON.stringify(response.data))
      }
      return response.data
    })
  }

  deleteRecipeById (id) {
    return axios.delete(API_URL + '/delete',
      {
        params:
        {
          id: id
        }
      })
  }
}
export default new RecipeService()
