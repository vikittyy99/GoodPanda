<template>
  <div>
<h3> {{message}}</h3>
    <input v-model="users.name" placeholder="Попълни ме" type="text">
    <input v-model="users.num" placeholder="Попълни ме" type="number">
    <input v-model="users.city.id" placeholder="Попълни ме" type="number">
  <button v-on:click="saveUser">Запис</button>
  </div>
</template>

<script>
import UsersService from '../services/users-service'

export default {
  name: 'UserTab',
  data() {
    return {
      users: {
        id: '',
        name: '',
        num: '',
        city: {
          id: '',
          name: ''
        }
      }

    }
  },
  beforeRouteEnter(to, from, next)
  {
    UsersService.getUserById(to.params.id).then(
        response => {
          next( vm =>
              vm.setData(response)
          )
        }
    )
  },
  methods:
      {
        setData (response) {
          this.users = response.data
        },
        saveUser() {
          UsersService.saveUser(this.users).then(
              response =>{
                this.users = response.data.users
                this.message = response.data.users

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
}
</script>

<style scoped>

</style>