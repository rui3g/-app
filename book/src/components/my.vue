<template>
  <div id="four">
    <van-nav-bar title="我的">
    </van-nav-bar>
    <div id="head">
    <van-image
      fit=cover
      round
      width="10rem"
      height="10rem"
      :src="headImage"
    />
    </div>
    <div id="mm"><h2 id="qq">{{userName}}</h2></div>
    <van-divider />
    <van-cell title="我的订单" is-link to="ordersave" />
    <van-cell title="收货地址" is-link to="address" />
    <van-cell title="联系我们" is-link @click="onclick" />
  </div>
</template>

<script>
export default {
  data () {
    return {
      headImage: '',
      userName: ''

    }
  },
  methods: {
    onclick () {
      this.$toast('联系我们请拨打138xxxxxxx电话竭诚为您服务')
    }
  },
  mounted () {
    this.userID = sessionStorage.getItem('userID')
    this.userName = sessionStorage.getItem('userName')
    this.passWord = sessionStorage.getItem('passWord')
    this.headImage = sessionStorage.getItem('headImage')
  }
}
</script>

<style scoped="scoped">
  #head{
    text-align: center;
    margin-top: 40px;
  }
  #mm{
    text-align: center;
  }
  #qq{
    margin-top: 10px;
    margin-bottom: 0px;
  }
  .van-divider{
    background-color: #c8c9cc;
    margin-bottom: 40px;
  }
  .van-cell{
    background-color: #f2f3f5;
    margin-top: 0.7%;

  }
</style>
