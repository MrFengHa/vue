<template>
  <div>
    <h1>用户添加信息</h1>
    <form>
      用户名：<input type="text" v-model="user.name"><br>
      年龄：<input type="text"  v-model="user.age"><br>
      生日：<input type="text" v-model="user.bir"><br>
      <input type="button" value="提交" @click="saveUserInfo">
    </form>
  </div>
</template>

<script>
  export default {
    name: "UserAdd",
    data(){
      return{
        user:{}
      }
    },
    methods:{
      saveUserInfo(){
        console.log(this.user);
        //发送请求
        this.$http.post("http://localhost:8989/user/add",this.user).then((res)=>{
          console.log(res);
          if (res.data.success){
            this.$router.push("/user")//切换路由
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
