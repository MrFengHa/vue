<template>
    <div>
      <h1>用户修改信息</h1>
      <form>
        用户名:<input type="text" v-model="user.name"><br>
        年龄:<input type="text" v-model="user.age"><br>
        生日:<input type="text" v-model="user.bir"><br>
        <input type="button" value="修改" @click="editUserInfo">
      </form>
    </div>
</template>

<script>
    export default {
        name: "UserEdit",
      data(){
        return{
          user:{
            id:""
          }
        }
      },methods:{
        findOne(){
          this.$http.get("http://localhost:8989/user/findOne?id="+this.user.id).then((res)=>{
            console.log(res.data);
            this.user = res.data
          })
        },
        editUserInfo(){
          this.$http.post("http://localhost:8989/user/update",this.user).then((res)=>{
            console.log(res.data)
              if (res.data.success){
                this.$router.push("/user")
              }
          })
        }
      },
      created() {
        console.log(this.$route.query.id);
        this.user.id = this.$route.query.id;
        this.findOne();
      }
    }
</script>

<style scoped>

</style>
