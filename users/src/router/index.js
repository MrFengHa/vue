import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import User from '@/components/User'
import Student from '@/components/Student'
import UserAdd from "../components/UserAdd";
import UserEdit from "../components/UserEdit";

Vue.use(Router)

export default new Router({
  routes: [
    {path: '/', redirect: "Home"},
    {path: '/home', component: Home},
    {
      path: '/User', component: User,
      children:[
        { path: 'UserAdd', component: UserAdd},
        { path: 'UserEdit', component: UserEdit}
      ]
    },
    {path: '/Student', component: Student},

  ]
})
