<template>
  <div>
    <div id="top">
      <a>Gmail</a>
      <a>이미지</a>
      <router-link to="/login"><button id="login" >로그인</button></router-link>
    </div>
    <br />
    <div>
      <img
              id="google"
              src="http://www.aitimes.kr/news/photo/201805/11897_11716_4927.jpg"
              title="Google"
      />
    </div>
    <div>
      <input
              id="search"
              @keyup.enter="search"
              v-model="searchWord"
              type="text"
              style=" background-repeat: no-repeat; background-position: 88% 50%, 98% 50%;"
              title="검색"
      />
    </div>
    <div id="box">
      <input
              @click="search"
              id="google_search"
              type="button"
              value="Google 검색"
      />
    </div>
  </div>
</template>

<script>
  import router from '@/router'
  export default {
    data() {
      return {
        searchWord: ""
      };
    },
    methods: {
      search() {
        this.$store.dispatch("search/find", this.searchWord);
      },
      login(){
        router.push('/login')
      }
    }
  }
</script>
<style scoped>
  body {
    margin: 0px;
    min-width: 1050px;
    min-height: 550px;
  }
  #top {
    margin: 5px 5px;
    float: right;
  }
  a {
    text-decoration: none;
    font-size: 10.5pt;
    margin: 0px 10px;
    color: grey;
  }
  a:hover {
    text-decoration: underline;
  }
  img {
    margin: 10px 7px;
    width: 20px;
    vertical-align: middle;
  }
  #login {
    background-color: #4485f3;
    color: #ffffff;
    width: 70px;
    height: 30px;
    border: none;
    vertical-align: middle;
    margin: 10px 12px 10px 7px;
    font-weight: bold;
    font-size: 10pt;
    border-radius: 2px;
  }
  #google {
    display: block;
    width: 500px;
    height: 300px;
    margin: 180px auto 20px;
  }
  #search {
    display: block;
    margin: 0 auto;
    width: 550px;
    height: 50px;
    font-size: 15pt;
    box-shadow: 3px 3px 5px #c3c3c3;
    border: 1px solid #eaeaea;
  }
  #box {
    text-align: center;
  }
  #google_search {
    width: 135px;
    height: 40px;
    margin: 30px 3px;
    border: none;
    background-color: #f4f4f4;
    font-weight: bold;
    color: grey;
  }
  #Feeling_Lucky {
    width: 180px;
    height: 40px;
    margin: 30px 3px;
    border: none;
    background-color: #f4f4f4;
    font-weight: bold;
    color: grey;
  }
  #google_search:hover,
  #Feeling_Lucky:hover {
    border: 1px solid #c6c6c6;
    color: black;
  }
</style>
