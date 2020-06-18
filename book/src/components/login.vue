<template>
  <div id="login">
     <van-nav-bar title="登录">
     </van-nav-bar>
     <div id="head">
     <van-image
       fit=cover
       round
       width="10rem"
       height="10rem"
       src="https://img.yzcdn.cn/vant/cat.jpeg"
     />
     </div>
     <div id="user">
     <van-cell-group>
       <van-field
         v-model="userID"
         required
         clearable
         label="用户名"
         right-icon="question-o"
         placeholder="请输入用户名"
         @click-right-icon="$toast('question')"
       ></van-field>
       <van-field
         v-model="passWord"
         type="password"
         label="密码"
         placeholder="请输入密码"
         required
       ></van-field>
     </van-cell-group>
     </div>
     <div id="button1">
     <van-button round type="primary" color="linear-gradient(to right, #4bb0ff, #6149f6)" size="large" @click="login()">登录</van-button>
     </div>
     <div id="button2">
     <van-button round type="primary" color="linear-gradient(to right, #4bb0ff, #6149f6)" size="large" to="/register">注册</van-button>
     </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      userID: '',
      passWord: ''

    }
  },
  methods: {
    login () {
      this.axios.post('http://127.0.0.1:1216/loginAndres/login', {
        userID: this.userID,
        passWord: this.passWord
      }).then(response => {
        console.log(response.data)
        if (response.data !== '') {
          sessionStorage.setItem('userID', response.data.userID)
          sessionStorage.setItem('userName', response.data.userName)
          sessionStorage.setItem('passWord', response.data.passWord)
          sessionStorage.setItem('headImage', response.data.headImage)
          this.$router.push({'name': 'home'})
        } else {
          this.$toast('学号或密码错误')
        }
      })
    }
  }

}
</script>

<style scoped="scoped">
  #head{
    text-align: center;
    margin-top: 40px;
  }
  #user{
    margin-top: 20px;
  }
  #button1{
    margin-top: 6%;
    margin-left: 6%;
    margin-right: 6%;
  }
  #button2{
    margin-top: 1%;
    margin-left: 6%;
    margin-right: 6%;
  }
</style>
