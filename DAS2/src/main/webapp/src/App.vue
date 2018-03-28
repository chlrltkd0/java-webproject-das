<template>
  <div id="app">
    <my-nav></my-nav>
    <router-view></router-view>
    <!-- <my-footer></my-footer> -->
  </div>
</template>

<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script src="./resources/js/daum_search.js"></script>
<script>
import Nav from './components/Nav.vue';
import Footer from './components/Footer.vue';

export default {
  name: 'app',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  components : {
    'my-nav' : Nav,
    'my-footer' : Footer
  },
  created : function(){
    this.$store.dispatch('setCoords');
  }
}
</script>

<style>
@import url("./resources/css/freelancer.min.css");

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
