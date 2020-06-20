import axios from 'axios'
import router from '@/router'
const state = {
    context : "http://localhost:5000"
}
const actions = {
    async find({commit},payload){
        alert("액션에 payload 들어옴 :  " + payload)
        axios.post(`${state.context}/user`,payload,{
            authorization: "JWT fefege..",
            Accept: "application/json",
            ContentType : "application/json"})
            .then(({data})=>{
                commit("FIND",data)
                router.push('/car')
                alert(data)
            })
    }
}
const mutations = {

}
export default {
    name:"login",
    namespaced : true,
    state,
    actions,
    mutations
}