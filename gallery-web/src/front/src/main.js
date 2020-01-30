import Vue from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'
import Element from 'element-ui'
import VueCarousel from 'vue-carousel';

import 'element-ui/lib/theme-chalk/index.css'



Vue.config.productionTip = false;

Vue.use(Element, {
});

Vue.use(VueCarousel)

new Vue({
  el: "#app",
  router,
  store,
  render: h => h(App),
});
