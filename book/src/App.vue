<template>
  <div id="app">
    <van-tabbar v-model="active" v-show="!this.$route.meta.isShow">
      <van-tabbar-item name="home" icon="home-o" to="/home">首页</van-tabbar-item>
      <van-tabbar-item name="bag" icon="bag-o" to="/bookshop">书城</van-tabbar-item>
      <van-tabbar-item name="cart" icon="cart-o" to="/shopping">购物车</van-tabbar-item>
      <van-tabbar-item name="contact" icon="contact" to="/my">我的</van-tabbar-item>
    </van-tabbar>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
  data () {
    return {
      active: 'home',
    }
  }
}
</script>

<style scoped="scoped">
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 0px;
}
</style>
