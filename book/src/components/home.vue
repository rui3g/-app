<template>
<div id="first">
  <van-nav-bar title="图书首页">
  </van-nav-bar>
  <van-search placeholder="请输入书名" v-model="input" @search="onSearch">
  </van-search>

  <van-swipe :autoplay="3000" indicator-color="white">
     <van-swipe-item>
      <img
      class="img2"
      src="../assets/top4.jpg"
      />
     </van-swipe-item>
     <van-swipe-item>
       <img
      class="img1"
      src="../../src/assets/top1.jpg"
      />
     </van-swipe-item>
     <van-swipe-item>
       <img
      class="img3"
      src="../../src/assets/top2.jpg"
      />
     </van-swipe-item>
     <van-swipe-item>
      <img
      class="img4"
      src="../../src/assets/top3.jpg"
      />
     </van-swipe-item>
  </van-swipe>
  <van-divider  :style="{ color: 'black',borderColor:'gray',padding: '0 16px' }">
    <van-icon name="fire" /><h3><b>热卖商品</b></h3>
  </van-divider>
  <div id="shop" v-for=" x in books">
    <van-card
       tag="促销"
      :price="x.bookSale"
      :desc="x.bookAuthor"
      :title="x.bookName"
      :thumb="x.bookImage"
      :origin-price="x.bookPrice"
       @click="jump(x)"
    />
  </div>
</div>
</template>

<script>
export default {
  data () {
    return {
      input: '',
      books: null,
      x: ''

    }
  },
  methods: {
    onSearch: function () {
      this.axios.get('http://127.0.0.1:1216/BookMessage/selectOne', {
        params: {
          bookName: this.input
        }
      })
        .then(response => {
          if (response.data === '') {
            this.$toast('作者或书名不存在')
          } else {
            console.log(response.data)
            this.$router.push({name: 'shopinfo', query: {bms: response.data}})
          }
        })
    },
    jump (x) {
      console.log(x)
      this.$router.push({name: 'shopinfo', query: {bms: x}})
    }
  },
  mounted () {
    this.axios.post('http://127.0.0.1:1216/BookMessage/select')
      .then(response => {
        this.books = response.data
      })
  }
}
</script>

<style scoped="scoped">
  .van-swipe{
    width: 100%;
    height: 200px;
    background-color: #2C3E50;
  }
  .img1{
     width: 100%;
     height: 200px;

   }
   .img2{
     width: 100%;
     height: 200px;

   }
   .img3{
     width: 100%;
     height: 200px;

   }
   .img4{
     width: 100%;
     height: 200px;
     }
     #shop{
       width: 45%;
       float: left;
       margin: auto;
       margin: 2%;
       height: 106px;
     }
     .van-card__bottom{
       margin-top: 5%;
     }
     #first{
         padding-bottom:400px;
     }
     .van-nav-bar{
       position: -webkit-sticky;
       position: sticky;
       top: 0;
     }

</style>
