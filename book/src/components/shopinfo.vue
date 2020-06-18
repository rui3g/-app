<template>
 <div id="info">
   <van-nav-bar title="商品详情页" left-arrow
  @click-left="onClickLeft">
   </van-nav-bar>
   <van-swipe :loop="false" :height="400">
     <van-swipe-item>
       <img
       class="img3"
       :src="bookImage"
       />
     </van-swipe-item>
     <van-swipe-item>
       <img
       class="img3"
       :src="bookImage"
       />
     </van-swipe-item>
     <van-swipe-item>
       <img
       class="img3"
       :src="bookImage"
       />
     </van-swipe-item>
   </van-swipe>
   <van-card
     tag="标签"
     :price="bookSale"
     :desc="bookAuthor"
     :title="bookName"
     :origin-price="bookPrice"
   />
   <div class="van-hairline--top"></div>
   <div class="stepper">
     <span id="zi">数量：</span><van-stepper v-model="addnum" />
   </div>
   <van-panel title="评价">
     <div>
       <van-skeleton title :row="3" :loading="false">
          <div v-for="p in list">
            <div id="niname">{{p.remarkMan}}&nbsp; {{p.date}}</div>
            <van-rate v-model="value" :size="10" readonly />
            <p id="remark">
              {{p.bookRemark}}
            </p>
          </div>
          <!-- 下边框 -->
          <div class="van-hairline--bottom"></div>
       </van-skeleton>
     </div>
   </van-panel>
   <van-goods-action>
     <van-goods-action-icon icon="chat-o" text="客服" @click="onClickIcon" />
     <van-goods-action-icon icon="cart-o" text="购物车" @click="onClickShopping" />
     <van-goods-action-button type="warning" text="加入购物车" @click="onClickButtonAdd" />
     <van-goods-action-button type="danger" text="立即购买" @click="onClickButtonSale" />
   </van-goods-action>
 </div>
</template>

<script>
export default {
  data () {
    return {
      value: 3,
      addnum: 1,
      bookName: '',
      bookAuthor: '',
      bookImage: '',
      bookSort: '',
      bookId: '',
      bookSale: '',
      bookPrice: '',
      bookID: '',
      list: null,
      userID: ''

    }
  },
  methods: {
    onClickIcon () {
      this.$toast('请拨打电话138xxxxxxxx联系客服')
    },
    onClickButtonAdd () {
      this.userID = sessionStorage.getItem('userID')
      this.bookName = this.$route.query.bms.bookName
      this.bookAuthor = this.$route.query.bms.bookAuthor
      this.bookImage = this.$route.query.bms.bookImage
      this.bookSort = this.$route.query.bms.bookSort
      this.bookId = this.$route.query.bms.bookID
      this.bookSale = this.$route.query.bms.bookSale
      this.bookPrice = this.$route.query.bms.bookPrice
      this.axios.post('http://127.0.0.1:1216/shoppingCart/insertCart', {
        bookID: this.$route.query.bms.bookID,
        bookName: this.bookName,
        bookImage: this.bookImage,
        bookAuthor: this.bookAuthor,
        bookSale: this.bookSale,
        bookPrice: this.bookPrice,
        bookNumber: this.addnum,
        userID: this.userID
      }).then(response => {
        this.$toast('加入成功')
      })
    },
    onClickShopping () {
      this.$router.push({ name: 'shopping' })
    },
    onClickButtonSale () {
      sessionStorage.setItem('addnum', this.addnum)
      sessionStorage.setItem('bookName', this.$route.query.bms.bookName)
      sessionStorage.setItem('bookAuthor', this.$route.query.bms.bookAuthor)
      sessionStorage.setItem('bookImage', this.$route.query.bms.bookImage)
      sessionStorage.setItem('bookID', this.$route.query.bms.bookID)
      if (this.bookSale !== null) {
        sessionStorage.setItem('bookSale', this.$route.query.bms.bookSale)
        sessionStorage.setItem('bookPrice', this.$route.query.bms.bookPrice)
      } else {
        sessionStorage.setItem('bookPrice', this.$route.query.bms.bookPrice)
      }
      this.$router.push({ name: 'order' })
    },
    onClickLeft () {
      this.$toast('返回')
      this.$router.push({ name: 'bookshop' })
    }

  },
  beforeMount: function () {
    this.bookName = this.$route.query.bms.bookName
    this.bookAuthor = this.$route.query.bms.bookAuthor
    this.bookImage = this.$route.query.bms.bookImage
    this.bookSort = this.$route.query.bms.bookSort
    this.bookId = this.$route.query.bms.bookID
    this.bookSale = this.$route.query.bms.bookSale
    this.bookPrice = this.$route.query.bms.bookPrice
  },
  mounted () {
    this.axios.get('http://127.0.0.1:1216/shoppingInfo/selectEvaluate', {
      params: {
        bookID: this.$route.query.bms.bookID
      }
    })
      .then(response => {
        this.list = response.data
        this.value = response.data[0].bookStar
      })
  }

}
</script>

<style scoped="scoped">
  .img3{
    height: 400px;
    margin: 14%;
    margin-top: 0px;
  }
  .van-card__title{
    font-size: 16px;
    font-weight:1000;
    padding-bottom: 10px;
    padding-top: 5px;
  }
  .van-card__bottom{
    margin-top: 10px;
    font-size: 20px;
    font-weight:700;
  }
  .van-cell{
    font-weight:600;
    font-size: 14px;
  }
  .van-panel__content{
    margin-left: 4%;
  }
  #niname{
    font-size: 13px;
    color:#9f9d9d;
    word-spacing:100px;
  }
  #remark{
    font-size: 13px;
    font-weight:500;
    font-family: 黑体;
  }
  #info{
    padding-bottom:50px ;
  }
  .van-hairline--top{
    margin: 5px;
  }
  .stepper{
    background-color: #fafafa;
  }
  #zi{
    float: left;
    margin-top: 4px;
    font-weight:1000;
    font-size: 14px;
    margin-left: 4%;
  }
  .van-stepper{
     margin-left: 20%;
  }
  .van-nav-bar{
    position: -webkit-sticky;
    position: sticky;
    top: 0;
  }
</style>
