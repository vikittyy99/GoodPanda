import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import * as axios from 'axios'
import VueCookies from 'vue-cookies';
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import { BTable, BPagination } from "bootstrap-vue"
import { CarouselPlugin } from 'bootstrap-vue'
import { ImagePlugin } from 'bootstrap-vue'
import { NavPlugin } from 'bootstrap-vue'
import { CardPlugin } from 'bootstrap-vue'
import { BootstrapVue } from 'bootstrap-vue'


Vue.component('b-pagination', BPagination)
Vue.component('b-table' , BTable)
Vue.use(BootstrapVue)
Vue.use(CardPlugin)
Vue.use(NavPlugin)
Vue.use(ImagePlugin)
Vue.use(CarouselPlugin)
Vue.use(VueCookies);
Vue.prototype.$axios = axios
Vue.config.productionTip = false

new Vue({
  router,
  store,
  axios,
  render: h => h(App)
}).$mount('#app')
