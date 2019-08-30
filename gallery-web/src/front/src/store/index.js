import Vue from 'vue'
import Vuex from 'vuex'

import episode from './modules/episode'

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    episode
  },
});

export default store
