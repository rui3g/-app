<template>
  <div id="ordersave">
    <van-nav-bar title="订单查询" left-arrow
    @click-left="onClickLeft">
     </van-nav-bar>
     <div id="order" v-for="o in order">
     <van-card
       :num="o.bookCount"
       :price="o.sumSale"
       :desc="o.bookAuthor"
       :title="o.bookName"
       :thumb="o.bookImage"
       @click-thumb="Click(x)"
     >
     <div slot="footer">
      <van-button id="fukuan" size="mini" @click="pay(o)">{{o.orderStatus}}</van-button>
     </div>
     </van-card>
     </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      order: null,
      userID: '',
      id: ''

    }
  },
  methods: {
    onClickLeft () {
      this.$toast('返回')
      this.$router.push({ name: 'my' })
    },
    Click: function (x) {
      this.$router.push({name: 'shopinfo', query: {bms: x}})
    },
    pay (o) {
      this.$dialog.confirm({
        title: '支付',
        message: '确认购买此书籍吗？'

      }).then(() => {
        // on confirm
        o.orderStatus = '已付款'
        this.axios.get('http://127.0.0.1:1216/my/updateStatus', {
          params: {
            id: o.id
          }
        }).then(response => {
          this.$toast('支付成功')
        })
      }).catch(() => {
        // on cancel
      })
    }

  },
  mounted () {
    this.userID = sessionStorage.getItem('userID')
    this.axios.get('http://127.0.0.1:1216/my/orderSelect', {
      params: {
        userID: this.userID
      }
    }).then(response => {
      console.log(response.data)
      this.order = response.data
    })
  }
}
</script>

<style scoped="scoped">
</style>
