<template>
  <div id="second">
    <van-nav-bar title="书城">
    </van-nav-bar>
    <van-search placeholder="请输入书名" v-model="input" @search="onSearch">
    </van-search>
    <van-dropdown-menu>
      <van-dropdown-item v-model="value1" :options="option1" @change="px()" />
      <van-dropdown-item v-model="value2" :options="option2" @change="px()" />
    </van-dropdown-menu>
    <div id="shop1" v-for="s in books" v-show="show">
    <van-card
      :price="s.bookSale"
      :desc="s.bookAuthor"
      :title="s.bookName"
      :thumb="s.bookImage"
      :origin-price="s.bookPrice"
      @click="Click(s)"
    >
      <div slot="tags">
        <van-tag plain type="danger">促销</van-tag>
        <van-tag plain type="danger">{{s.bookSort}}</van-tag>
      </div>
    </van-card>
    </div>
    <div id="shop2" v-for="l in booklist" v-show="show1" >
    <van-card
      :price="l.bookPrice"
      :desc="l.bookAuthor"
      :title="l.bookName"
      :thumb="l.bookImage"
      @click="Clickto(l)"
    />
    </div>
  </div>

</template>

<script>
export default {
  data () {
    return {
      show1: true,
      show: true,
      input: '',
      books: null,
      booklist: null,
      value1: 1,
      value2: '分类',
      option1: [
        { text: '全部商品', value: 1 },
        { text: '活动商品', value: 0 },
        { text: '新款商品', value: 2 }
      ],
      option2: [
        { text: '分类', value: '分类' },
        { text: '文学', value: '文学' },
        { text: '小说', value: '小说' },
        { text: '艺术', value: '艺术' },
        { text: '工具书 ', value: '工具书' }
      ]
    }
  },
  methods: {
    Click: function (s) {
      this.$router.push({name: 'shopinfo', query: {bms: s}})
    },
    Clickto: function (l) {
      this.$router.push({name: 'shopinfo', query: {bms: l}})
    },
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
    px () {
      this.bookshop(this.value1, this.value2)
    },
    bookshop (value1, value2) {
      this.axios.get('http://127.0.0.1:1216/BookMessage/selectSort', {
        params: {
          saleStatus: value1,
          bookSort: value2
        }
      }).then(response => {
        if (this.value1 === 0) {
          console.log(response.data)
          this.books = response.data
          this.show1 = false
          this.show = true
        } else if (this.value1 === 2) {
          console.log(response.data)
          this.booklist = response.data
          this.show = false
          this.show1 = true
        } else {
          console.log(response.data)
          this.show1 = true
          this.show = false
          this.booklist = response.data
        }
      })
    }
  },
  mounted () {
    this.bookshop(this.value1, this.value2)
  }

}
</script>

<style scoped="scoped">
  #second{
    padding-bottom: 50px;
  }
  .van-nav-bar{
    position: -webkit-sticky;
    position: sticky;
    top: 0;
  }
</style>
