import axios from 'axios'

const API_URL = 'http://localhost:8080/app'
class UsersService {
    getALLUsers() {
        return axios.get(API_URL + '/user')
    }

    getUsersPage(filters, currentPage, perPage) {
        return axios.get(API_URL + '/search/page',
            {
                params:
                    {
                        city: filters.city,
                        name: filters.name,
                        num: filters.num,
                        currentPage: currentPage,
                        perPage: perPage
                    }
            })
    }
    saveUser(form) {
        return axios.post(API_URL + '/save',
            {
                id: form.id,
                name: form.name,
                num: form.num,
                cityId: form.city.id,

            })

    }

    getUserById(id) {
        return axios.get(API_URL + '/search/id',
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


    deleteUserById(id) {
        return axios.delete(API_URL + '/delete',
            {
                params:
                    {
                        id: id
                    }
            })
    }

}
export default new UsersService()