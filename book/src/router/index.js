import Vue from 'vue'
import Router from 'vue-router'
import home from '@/components/home'
import bookshop from '@/components/bookshop'
import shopping from '@/components/shopping'
import my from '@/components/my'
import shopinfo from '@/components/shopinfo'
import order from '@/components/order'
import address from '@/components/address'
import ordersave from '@/components/ordersave'
import login from '@/components/login'
import register from '@/components/register'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/home',
      name: 'home',
      component: home
    },
    {
      path: '/bookshop',
      name: 'bookshop',
      component: bookshop
    },
    {
      path: '/shopping',
      name: 'shopping',
      component: shopping
    },
    {
      path: '/my',
      name: 'my',
      component: my
    },
    {
      path: '/shopinfo',
      name: 'shopinfo',
      component: shopinfo,
      meta: {isShow: true}
    },
    {
      path: '/order',
      name: 'order',
      component: order,
      meta: {isShow: true}
    },
    {
      path: '/address',
      name: 'address',
      component: address,
      meta: {isShow: true}
    },
    {
      path: '/ordersave',
      name: 'ordersave',
      component: ordersave,
      meta: {isShow: true}
    },
    {
      path: '/',
      name: 'login',
      component: login,
      meta: {isShow: true}
    },
    {
      path: '/register',
      name: 'register',
      component: register,
      meta: {isShow: true}
    }
  ]
})
