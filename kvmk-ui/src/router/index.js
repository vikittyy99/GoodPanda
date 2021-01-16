import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import User from '../views/User.vue'
import UserTab from '../views/UserTab'
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import Blog from '../views/Blog.vue'
import Dattebayp from '../views/Dattebayp.vue'
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
    path: '/user',
    name: 'User',
    meta:{
      secure:true
    },
    component: User
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
    path: '/userTab',
    name: 'UserTab',
    meta:{
      secure:true
    },
    component: UserTab
  },
  {
    path: '/blog',
    name: 'Blog',
    meta:{
      secure:true
    },
    component: Blog
  },
  {
    path: '/dattebayp',
    name: 'Dattebayp',
    meta:{
      secure:true
    },
    component: Dattebayp
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
