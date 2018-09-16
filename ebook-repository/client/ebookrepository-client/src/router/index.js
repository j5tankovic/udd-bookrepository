import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import AdminProfile from '@/components/admin/AdminProfile'
import Login from '@/components/Login'
import SubscriberProfile from '@/components/subscriber/SubscriberProfile'
import RouteNames from './routeNames'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: RouteNames.HOME,
      component: Home
    },
    {
      path: '/profile-admin/:id',
      name: RouteNames.ADMIN_PROFILE,
      component: AdminProfile
    },
    {
      path: '/profile-subscriber/:id',
      name: RouteNames.SUBSCRIBER_PROFILE,
      component: SubscriberProfile,
    },
    {
      path: '/login',
      name: RouteNames.LOGIN,
      component: Login
    }
  ]
})
