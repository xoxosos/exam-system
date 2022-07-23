<template>
  <div class="login">
    <div class="form-title">Welcome to login!</div>
    <el-form  :rules="state.rules" :model="state.ruleForm" ref="loginForm" class="login-form">
      <el-form-item class="input-item"   prop="username">

        <el-input class="input"
                  style="margin-top: 58px;"
                  type="text"
                  v-model.trim="state.ruleForm.username"
                  autocomplete="off">
          <template #prefix>
            <el-icon class="el-input__icon"><UserFilled /></el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item  class="input-item"  prop="password">
        <el-input class="input"
                  type="password"
                  v-model.trim="state.ruleForm.password"
                  autocomplete="off">
          <template #prefix>
            <el-icon class="el-input__icon"><Lock /></el-icon>
          </template>
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button style="width: 301px;background: #FFA113;height: 36px;margin-left: 50px;"
                   type="primary"
                   @click="submitForm">Login</el-button>
        <el-checkbox class="el-checkbox" v-model="state.checked"  @change="!state.checked">Remeber me</el-checkbox>
        <a class="el-checkbox" style="height: 19px;"  @change="">Forgot password?</a>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import { UserFilled, Lock } from '@element-plus/icons-vue'
import {ref,reactive} from "vue";
import axios from 'axios'
import router from "../../router";
const name = 'Login'
 const loginForm = ref(null)
 const state = reactive({
   ruleForm: {
     username: localStorage.getItem("username"),
     password: localStorage.getItem("password")
   },
   checked: false,
   rules: {
     username: [
       { required: 'true', message: '账户不能为空', trigger: 'blur' }
     ],
     password: [
       { required: 'true', message: '密码不能为空', trigger: 'blur' }
     ]
   }
 })
 const submitForm = () => {
   loginForm.value.validate((valid) => {
     if (valid) {
       axios.post('/api/adminUser/login', {
         username: state.ruleForm.username,
         password: state.ruleForm.password
       }).then(res => {
         if (state.checked){
           localStorage.setItem("username", state.ruleForm.username);
           localStorage.setItem("password", state.ruleForm.password);
           console.log(localStorage.getItem("username"),localStorage.getItem("password"))
         }else {
           // 否则移除
           localStorage.removeItem("username");
           localStorage.removeItem("password");
           console.log(localStorage.getItem("username"),localStorage.getItem("password"))
         }
         // 登录成功跳转
         router.push('/home')
         window.location.href = '/'
       })
     } else {
       console.log('error submit!!')
       return false;
     }
   })
 }
 const resetForm = () => {
   loginForm.value.resetFields();
 }

</script>

<style scoped>
.login{
  position: absolute;
  left: 708px;
  top: 146px;
  width: 400px;
  height: 320px;
}
.form-title{
  font-size: 26px;
  color: #30455A;
  letter-spacing: 0;
  margin-bottom: 31px;
}
.login-form{
  background: #30455A;
}
.input{
  width: 301px;
  height: 36px;
  background: #FFFFFF;
  margin-left: 50px;
  margin-right: 49px;
}
.el-checkbox{
  font-size: 16px;
  color: #FFFFFF;
  letter-spacing: 0;
  margin-left: 50px;
  margin-top: 10px;
  margin-bottom: 20px;
}
</style>
