<template>
  <div>
    <h3>{{message}}</h3>
    <button v-on:click="searchUsers">
      Търси
    </button>
    <b-table
        id="usersTable"
        striped
        hover
        :items="users"
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

      <template v-slot:cell(city)="data">
        <div v-if="data.item.city">
          {{ data.item.city.name}}
        </div>
        <div v-else>
          Няма град
        </div>
      </template>

      <template v-slot:cell(actions)="row">
        <router-link :to="{name: 'UserTab', params: {id: row.item.id } }" class="btn-group">Отвори</router-link>
        <button v-on:click="deleteUsers(row.item.id)">Изтрий</button>
      </template>
    </b-table>
    <b-pagination
        @input="searchUsers"
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      aria-controls="userTable"
      ></b-pagination>
  </div>
</template>
<!--<template>-->
<!--  <div>-->
<!--    <input v-model="users.name" placeholder="Попълни ме" type="text">-->
<!--    <input v-model="users.num" placeholder="Попълни ме" type="number">-->
<!--    <input v-model="users.city.id" placeholder="Попълни ме" type="number">-->
<!--  </div>-->
<!--</template>-->

<script>
import UsersService from '../services/users-service'

export default {
  name: 'User',
  data () {
    return {
      message: '',
      currentPage: 1,
      rows: '',
      perPage: 5,
      users: [{
        id: '',
        name: '',
        num: '',
        city:
            {
              id: '',
              name: ''
            }
      }
      ],
      fields: [
        { key: 'name', label: 'Име' },
        { key: 'city', label: 'Град' },
        {key: 'num', label: 'Номер'},
        {key: 'id', label: 'Id'},
        { key: 'actions', label: 'Действия'}
        ],
      filters: {
        name: '',
        num: '',
        id: '',
        city: ''
      }
    }
  },
  mounted () {
    this.searchUsers()
    // UsersService.getALLUsers().then(
    //     response => {
    //       this.users = response.data.users
    //     },
    //     error => {
    //       this.content =
    //           (error.response() && error.response.data)
    //       error.message
    //       error.ToString()
    //     }
    // )
  },
  methods: {
    searchUsers () {
      UsersService.getUsersPage(this.filters, this.currentPage, this.perPage).then(
          response => {
            this.users = response.data.users
            this.rows = response.data.totalElements
          },
          error => {
            this.content =
                (error.response() && error.response.data) ||
            error.message ||
            error.ToString()
          }
      )
    },

    deleteUsers (id) {
      UsersService.deleteUserById(id).then(
          response => {
            this.message = response.data.users
            this.searchUsers()
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
