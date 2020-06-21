<template>
    <v-container>
        <a> 자동차 정보수 : {{ count }}</a>
        <v-card>
            <v-card-title>
                중고차 현황
                <v-spacer/>
                <v-text-field
                        v-model="search"
                        append-icon="mdi-magnify"
                        label="Search"
                        single-line
                        hide-details
                ></v-text-field>
            </v-card-title>

            <v-data-table
                    :headers="headers"
                    :items="list"
                    :search="search">
                <template v-slot:item.img="{item}">
                    <img :src=item.img width="50" height="50"/>
                </template>

            </v-data-table>
        </v-card>
    </v-container>
</template>

<script>
    import {mapState} from'vuex'
    export default {
        name: "Car",
        data(){
          return {
              OK: true,
              search: '',
              headers: [
                  {
                      text: 'carSeq',
                      value: 'carSeq'
                  },
                  {
                      text: 'img',
                      value: 'img'
                  },
                  {
                      text: 'name',
                      value: 'name'
                  },
                  {
                      text: 'year',
                      value: 'year'
                  },
                  {
                      text: 'km',
                      value: 'km'
                  },
                  {
                      text: 'fuel',
                      value: 'fuel'
                  },
                  {
                      text: 'price',
                      value: 'price'
                  },
              ]
          }
        },
        computed :{
            ...mapState ({
            list : state => state.car.list
            })
        },
        mounted() {
            this.$store.dispatch('car/list')
        }
    }
</script>

<style scoped>

</style>