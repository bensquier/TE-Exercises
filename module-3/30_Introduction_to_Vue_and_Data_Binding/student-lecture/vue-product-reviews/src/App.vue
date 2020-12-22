<template>
  <div id="app">
    <product-reviews></product-reviews>
    <img alt="Vue logo" src="./assets/logo.png">
  </div>
</template>

<script>
import ProductReviews from './components/ProductReviews.vue'
//import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    //HelloWorld,
    ProductReviews
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  max-width: 800px;
  margin: 60px auto 0px auto;
}
</style>
