import {createRouter,createWebHashHistory} from 'vue-router'

import Login from "../components/Login.vue";
import Regist from "../components/Regist.vue";
import ShowSchedule from "../components/ShowSchedule.vue";

import pinia from "../pinia.js";
import {defineUser} from "../store/userStore.js";
let sysUser = defineUser(pinia)


const router = createRouter(
    {
        history:createWebHashHistory(),
        routes:[
            {
                path:"/",
                redirect:"/showSchedule"
            },
            {
                path:"/showSchedule",
                component:ShowSchedule
            },
            {
                path:"/login",
                component:Login
            },
            {
                path:"/regist",
                component:Regist
            },
        ]
    }
)

//通过路由的全局前置守卫，判断是否可以访问showSchedule
router.beforeEach((to,from,next)=>{
    if (to.path == '/showSchedule'){
        //登录过就放行, 没登陆就跳转登录页
        if (sysUser.username == ''){
            next("/login")
        }else {
            next()
        }
    }else {
        next()
    }
})

export default router