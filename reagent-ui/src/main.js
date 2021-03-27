import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'

Vue.config.productionTip = false

Vue.prototype.getImgSrc = function (img) {
  return "http://127.0.0.1:10086/img/" + img
}

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
