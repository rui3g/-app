<template>
  <div id="third">
    <van-nav-bar title="购物车">
    </van-nav-bar>
    <van-panel title="读书之法，在循序而渐进，熟读而精思。" desc="—— 朱熹" class="top">
    </van-panel>
    <div id="card" v-for="x in card" >
    <van-card
      :num="x.bookNumber"
      :price="x.bookSale"
      :desc="x.bookAuthor"
      :title="x.bookName"
      :thumb="x.bookImage"
      :origin-price="x.bookPrice"
      @click-thumb="Click(x)"
    >
      <div slot="footer">
       <van-button size="mini" @click="add(x)">添加</van-button>
       <van-button size="mini" @click="upd(x)">减少</van-button>
       <van-button size="mini"  @click="del(x)">删除</van-button>
      </div>
    </van-card>
    </div>
    <van-submit-bar
      :price="sum"
      button-text="结算"
      @submit="onSubmit"
    />
  </div>
</template>

<script>
export default {
  data () {
    return {
      checked: true,
      card: null,
      sum: 0,
      info: '',
      cartID: '',
      userID: ''
    }
  },
  methods: {
    Click: function (x) {
      this.$router.push({name: 'shopinfo', query: {bms: x}})
    },
    add (x) {
      this.info = '1'
      this.cartID = x.cartID
      this.addUpdDel(this.info, this.cartID)
    },
    del (x) {
      this.info = '0'
      this.cartID = x.cartID
      this.addUpdDel(this.info, this.cartID)
    },
    upd (x) {
      this.info = '-1'
      this.cartID = x.cartID
      this.addUpdDel(this.info, this.cartID)
    },
    addUpdDel (info, cartID) {
      this.axios.get('http://127.0.0.1:1216/shoppingCart/addUpdDel', {
        params: {
          info: info,
          cartID: cartID
        }
      })
        .then(response => {
          console.log(response.data)
          this.flashtwo()
          this.flash()
        })
    },
    flash () {
      this.userID = sessionStorage.getItem('userID')
      this.axios.get('http://127.0.0.1:1216/shoppingCart/selectSum', {
        params: {
          userID: this.userID
        }
      }).then(response => {
        console.log(response.data)
        this.sum = response.data
      })
    },
    flashtwo () {
      this.userID = sessionStorage.getItem('userID')
      this.axios.get('http://127.0.0.1:1216/shoppingCart/selectCart', {
        params: {
          userID: this.userID
        }
      }).then(response => {
        console.log(response.data)
        this.card = response.data
      })
    },
    onSubmit () {
      this.$dialog.confirm({
        title: '支付',
        message: '确认要使用默认地址来结算所有购物车内的宝贝吗？'
      }).then(() => {
        // on confirm
        this.userID = sessionStorage.getItem('userID')
        this.axios.get('http://127.0.0.1:1216/shoppingCart/paydelShopCart', {
          params: {
            userID: this.userID
          }
        }).then(response => {
          this.flashtwo()
          this.flash()
          this.$toast('购买成功')
        })
      }).catch(() => {
        // on cancel
      })
    }
  },
  beforeMount () {
    this.userID = sessionStorage.getItem('userID')
    this.axios.get('http://127.0.0.1:1216/shoppingCart/selectSum', {
      params: {
        userID: this.userID
      }
    }).then(response => {
      console.log(response.data)
      this.sum = response.data
    })
  },
  mounted () {
    this.userID = sessionStorage.getItem('userID')
    console.log(this.userID)
    this.axios.get('http://127.0.0.1:1216/shoppingCart/selectCart', {
      params: {
        userID: this.userID
      }
    }).then(response => {
      console.log(response.data)
      this.card = response.data
    })
  }
}
</script>

<style scoped="scoped">
  .van-cell__label{
    margin-left: 280px;
  }
  .van-submit-bar{
    margin-bottom: 13%;
  }
</style>
