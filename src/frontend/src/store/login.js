import axios from 'axios'
import router from '@/router'
const state = {
    context : "http://localhost:5000",
    find : false
}
const actions = {
    async find({commit},payload){
        axios.post(`${state.context}/user`,payload,{
            authorization: "JWT fefege..",
            Accept: "application/json",
            ContentType : "application/json"})
            .then(({data})=>{
                if(data===true){
                    router.push('/car')
                    commit("FIND",data)
                } else if (data===false){
                    alert("로그인실패")
                }
            })
            .catch((e)=>{
                e.error
            })
    }
}
const mutations = {
    FIND(state, data){
        state.find = data
    }
}
export default {
    name:"login",
    namespaced : true,
    state,
    actions,
    mutations
}