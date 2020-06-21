import axios from 'axios'
const state = {
    context : "http://localhost:5000",
    list : []
}
const actions = {
    async list({commit}){
        axios.get(`${state.context}/car/list`)
            .then(({data})=>{
                commit("LIST",data)
            })
            .catch((e)=>{
                console.log(e)
            })
    }
}
const mutations = {
    LIST(state,data){
        state.list = data
        data.forEach(item => {
            state.list.push({
                carSeq : item.carSeq,
                img : item.img,
                name : item.name,
                year : item.year,
                km : item.km,
                fuel : item.fuel,
                price : item.price
            })
        })
    }
}
export default {
    name:"car",
    namespaced : true,
    state,
    actions,
    mutations
}