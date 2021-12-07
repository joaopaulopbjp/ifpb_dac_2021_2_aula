import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import AdicionaAutor from '../views/AdicionaAutor.vue'

const routes = [
  {
    path: '/',
    component: Home
  },
  {
    path: '/add',
    component: AdicionaAutor
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
