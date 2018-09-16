// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Buefy from 'buefy'
import 'buefy/lib/buefy.css'
import setupInterceptor from './interceptor'

Vue.config.productionTip = false
Vue.use(Buefy, {
  defaultIconPack:'fa',
})

setupInterceptor();

const eventHub = new Vue();
window.eventHub = eventHub;

/* eslint-disable no-new */
const vm = new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
});