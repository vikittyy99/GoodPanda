import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import AddRecipe from '../views/AddRecipe.vue'
import Recipe from '../views/Recipe.vue'
import isLogged from "@/utils/Auth";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    meta:{
      secure:true
    },

    component: Home
  },

  {
    path: '/login',
    name: 'Login',
    meta:{
      secure:false
    },
    component: Login
  },
  {
    path: '/register',
    name: 'Register',
    meta:{
      secure:false
    },
    component: Register
  },
  {
    path: '/recipe',
    name: 'Recipe',
    meta:{
      secure:true
    },
    component: Recipe
  },
  {
    path: '/addrecipe',
    name: 'AddRecipe',
    meta:{
      secure:true
    },

    component: AddRecipe
  },

  {
    path: '/about',
    name: 'About',
    meta:{
      secure:true
    },
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  routes
})

router.beforeEach((to, from, next) => {
  if (to.meta.secure && !isLogged()) {
    next({
      path: '/login',
      query: { redirect: to.fullPath }
    })
  }
  else {
    next()
  }
})


export default router
