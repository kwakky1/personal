import axios from 'axios'

const state = {
    context : "http://localhost:5000"
}
const actions = {
    async find({commit},payload){

        axios.get(`${state.context}/login/${payload.userId}`)
            .then(({data})=>{
                commit("FIND",payload)
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