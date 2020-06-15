import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home";
import Login from "../components/Login";
Vue.use(VueRouter);
export default new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    { path: "/", component: Home },
    { path:"/login", component: Login }
  ]
});