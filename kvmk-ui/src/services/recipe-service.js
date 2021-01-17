import axios from 'axios'

const API_URL = 'http://localHost:8080/recipe'

class RecipeService {
    getAllRecipes () {
        return axios.get(API_URL + '/all') // .get, защото изпълнява get заявка; има и .post, .delete...
    }

    getAllIngredients () {
        return axios.get(API_URL + '/ingredients')
    }

    getRecipesPage (filters, currentPage, perPage) {
        return axios.get(API_URL + '/search/page',
            {
                params:
                    {
                        name: filters.name,
                        currentPage: currentPage,
                        perPage: perPage
                    }
            })
    }
    saveRecipe(form) {
        return axios.get(API_URL + '/recipesave',
            {
                params:
                    {
                        name: form.name,
                        description: form.description,
                    }


            })

    }
    deleteRecipeById(id) {
        return axios.delete(API_URL + '/delete',
            {
                params:
                    {
                        id: id
                    }
            })
    }
    register(form) {
        return axios.get(API_URL + '/register',
            {
                params:
                    {
                        name: form.name,
                        email: form.email,
                        password: form.password,
                    }
            })

    }

    login(form) {
        return axios.get(API_URL + '/authenticate',
            {
                headers: {
                    'Access-Control-Allow-Origin': '*',
                },
                params:
                    {
                        email: form.email,
                        password: form.password,

                    }

            }) .then(response => {
            if (response.data.accessToken) {
                localStorage.setItem('user', JSON.stringify(response.data));
            }

            return response.data;
        });


    }


}


export default new RecipeService()
