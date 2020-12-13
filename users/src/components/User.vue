<template>
  <div>
    <h1>用户界面</h1>
    <table border="1">
      <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
        <th>操作</th>
      </tr>
      <tr v-for="user in users">
        <td>{{user.id}}</td>
        <td>{{user.name}}</td>
        <td>{{user.age}}</td>
        <td>{{user.bir}}</td>
        <td><a href="" @click.prevent="deleteUser(user.id)">删除</a><a :href="'#/User/UserEdit?id='+user.id">修改</a></td>
      </tr>
    </table>
    <a href="#/User/UserAdd">添加</a>
    <router-view></router-view>
  </div>
</template>

<script>
  export default {
    name: "User",
    data() {
      return {
        users: []
      }
    },
    methods: {
      findAll() {
        this.$http.get("http://localhost:8989/user/findAll?page=1&rows=4").then((res) => {
          console.log(res.data);
          this.users = res.data.results
        })
      },
      deleteUser(id) {
        this.$http.get("http://localhost:8989/user/delete?id=" + id).then((res) => {
          if (res.data.success) {
          this.findAll();
          }
        })
      }
    },
    created() {
      this.findAll()
    }, watch: {//用来监听
      $route: {
        handler: function (val, oldVal) {
          if (val.path == "/user") {
            this.findAll()
          }
        }
      }
    }
  }
</script>

<style scoped>

</style>
