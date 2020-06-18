<template>
  <div id="address">
    <van-nav-bar title="收货地址" left-arrow
    @click-left="onClickLeft">
    </van-nav-bar>
    <van-address-list
      v-model="chosenAddressId"
      :list="list"
      @add="onAdd"
    />
  </div>
</template>

<script>
export default {
  data () {
    return {
      chosenAddressId: '1',
      list: null
    }
  },

  methods: {
    onAdd () {
      this.$toast('此功能暂未开发敬请期待')
    },
    onClickLeft () {
      this.$toast('返回')
      this.$router.push({ name: 'my' })
    }
  },
  mounted () {
    this.userID = sessionStorage.getItem('userID')
    this.axios.get('http://127.0.0.1:1216/my/selectAddress', {
      params: {
        userID: this.userID
      }
    }).then(response => {
      this.list = response.data
    })
  }
}
</script>

<style scoped="scoped">
.van-address-list__add{
  color: red;
}
</style>
