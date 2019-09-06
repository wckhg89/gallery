import Vue from 'vue'
import Vuex from 'vuex'

import episode from './modules/episode'
import guestBook from './modules/guestBook'

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    episode,
    guestBook
  },
});

export default store
