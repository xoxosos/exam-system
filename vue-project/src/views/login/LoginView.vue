<template>
  <div class="login-container">
    <div class="login-logo">
      <img class="logo" src="./img/login.png"/>
      <div class="title">Online Exam System</div>
    </div>
    <LoginForm/>
    <div class="login-foot" >
      Copyright © 2019 Augmentum，Inc. All Rights Reserved.
    </div>
  </div>

</template>

<script setup>

import LoginForm from "./LoginForm.vue";
</script>

<style scoped>

.login-container{
  min-height: 800px;
  width:1280px;
  margin:0 auto;
  position: relative;
}
.title{
  line-height:36px;
  font-size: 30px;
  color: #304558;
  letter-spacing: 0;
  margin-top: 36px;

}
.login-foot{
  /*固定位置 难点定位 flex布局  fixed以Body*/
  position: fixed;
  right: 0;
  left: 0;
  bottom: 0;
  height: 144px;
  /*0-255 255白色 RGB*/
  border-top: 1px solid #000;
  text-align: center;
  padding-top: 42px;
  font-size: 12px;
  /*空间行高*/
  line-height: 14px;
}
.login-logo{
  position: absolute;
  left: 176px;
  top: 304px;
}
</style>