import Vue from 'vue'
import Vuex from 'vuex'
import login from './login'
import join from "./join";
import car from "./car";

Vue.use(Vuex)

export default new Vuex.Store({
   modules: {
     login, join, car
  }
})
