<template>
  <div id="register">
    <van-nav-bar title="注册" left-arrow @click-left="onClickLeft">
    </van-nav-bar>
    <van-uploader>
      <van-image id="tou" src="http://mimg1.gamedog.cn/2014/12/15/7-1412151509210-50.jpg" icon="photo" type="primary"></van-image>
    </van-uploader>
    <van-cell-group>
      <van-field
        v-model="userID"
        required
        clearable
        label="用户名"
        right-icon="question-o"
        placeholder="请输入用户名"
        @click-right-icon="$toast('question')"
      />
      <van-field
        v-model="userName"
        required
        label="昵称"
        placeholder="请输入昵称"
      />
      <van-field
        v-model="passWord"
        type="password"
        label="密码"
        placeholder="请输入密码"
        required
      />
      <van-field
        v-model="name"
        required
        label="姓名"
        placeholder="请输入姓名"
      />
      <van-field
        v-model="tel"
        required
        label="电话"
        placeholder="请输入手机号"
      />
      <van-field
        v-model="address"
        required
        label="地址"
        placeholder="请输入详细地址便于购买时使用"
      />
      <van-field
        v-model="headImage"
        clearable
        required
        label="头像url地址"
        placeholder="请输入您在网上找的头像url地址"
      />
    </van-cell-group>
    <div id="button1">
    <van-button round type="primary" color="linear-gradient(to right, #4bb0ff, #6149f6)" size="large" @click="register()">立即注册</van-button>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      userID: '',
      passWord: '',
      userName: '',
      headImage: 'http://file.qqtouxiang.com/qinglv/2019-10-21/09f748385027866176efc3d6629d5aa2.jpg',
      address: '',
      name: '',
      tel: ''

    }
  },
  methods: {
    onClickLeft () {
      this.$toast('返回')
      this.$router.push({ name: 'login' })
    },
    insertAddress () {
      this.axios.post('http://127.0.0.1:1216/my/insertAddress', {
        address: this.address,
        name: this.name,
        tel: this.tel,
        userID: this.userID
      }).then(response => {

      })
    },
    register () {
      this.axios.post('http://127.0.0.1:1216/loginAndres/register', {
        userID: this.userID,
        passWord: this.passWord,
        userName: this.userName,
        headImage: this.headImage
      }).then(response => {
        if (response.data !== 1) {
          this.$toast('不符合注册规范')
        } else {
          this.insertAddress()
          this.$toast('注册成功')
          this.$router.push({'name': 'login'})
        }
      })
    }

  }
}
</script>

<style scoped="scoped">
  .van-uploader{
    float: left;
    margin-top: 22%;

  }
  #tou{
    width: 60%;
    height: 100%;
    margin: auto;
    margin-left: 43%;
  }
  .van-cell-group{
    float: left;
     margin-left: 5%;
  }
  #button1{
    margin: 6%;
  }
</style>
