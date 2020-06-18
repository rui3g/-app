<template>
  <div id="order">
    <van-nav-bar title="订单提交"
    left-arrow
    @click-left="onClickLeft">
    </van-nav-bar>
    <van-skeleton
      title
      :row="3"
      :loading="false"
    >
      <div id="maninfo">
        <h5>{{name}} {{tel}} <van-tag round type="danger">默认</van-tag></h5>
        <h5><p>{{address}}</p></h5>
      </div>
      <van-divider />
    </van-skeleton>
    <!-- 下边框 -->
    <div class="van-hairline--bottom"></div>
    <van-swipe :loop="false" :height="300">
      <van-swipe-item>
        <img
        class="img3"
        :src="bookImage"
        />
      </van-swipe-item>
      </van-swipe>
    <van-card
      :num="addnum"
      tag="标签"
      :price="bookSale"
      :desc="bookAuthor"
      :title="bookName"
      :origin-price="bookPrice"
    />
    <van-panel title="读书之法，在循序而渐进，熟读而精思。" desc="—— 朱熹" class="top">
    </van-panel>
    <van-submit-bar
      :price="Sum"
      button-text="提交订单"
      @submit="onSubmit"
    />
  </div>
</template>

<script>
export default {
  data () {
    return {
      addnum: '',
      bookName: '',
      bookAuthor: '',
      bookImage: '',
      bookID: '',
      bookSale: 0,
      bookPrice: 0,
      tel: '',
      name: '',
      address: '',
      userID: '',
      Sum: 0,
      bookCount: ''

    }
  },
  methods: {
    onSubmit () {
      this.axios.post('http://127.0.0.1:1216/my/insertOrder', {
        userID: this.userID,
        bookID: this.bookID,
        bookCount: this.addnum,
        sumSale: this.Sum / 100
      }).then(response => {
        this.$toast('订单提交成功请到订单查询页面付款')
      })
      this.$router.push({ name: 'my' })
    },
    onClickLeft () {
      this.$toast('返回')
      this.$router.push({ name: 'bookshop' })
    },
    SelectAddress () {
      this.userID = sessionStorage.getItem('userID')
      this.axios.get('http://127.0.0.1:1216/my/selectAddress', {
        params: {
          userID: this.userID
        }
      }).then(response => {
        this.tel = response.data[0].tel
        this.name = response.data[0].name
        this.address = response.data[0].address
      })
    }
  },
  mounted () {
    this.addnum = sessionStorage.getItem('addnum')
    this.bookID = sessionStorage.getItem('bookID')
    this.bookName = sessionStorage.getItem('bookName')
    this.SelectAddress()
    this.axios.get('http://127.0.0.1:1216/BookMessage/selectOne', {
      params: {
        bookName: this.bookName
      }
    }).then(response => {
      this.bookAuthor = response.data.bookAuthor
      this.bookImage = response.data.bookImage
      this.bookSale = response.data.bookSale
      this.bookPrice = response.data.bookPrice
      if (response.data.bookSale !== null) {
        this.Sum = this.bookSale * this.addnum * 100
      } else {
        this.Sum = this.bookPrice * this.addnum * 100
      }
    })
  }
}
</script>

<style scoped="scoped">
  #maninfo{
    margin-left: 10%;
    word-spacing:10px;
  }
  .van-divider{
    border-color: #9da1a8;
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
  .img3{
    height: 300px;
    margin: 20%;
    margin-top: 0px;
  }
  #order{
    padding-bottom:50px ;
  }
  .van-nav-bar{
    position: -webkit-sticky;
    position: sticky;
    top: 0;
  }
</style>
