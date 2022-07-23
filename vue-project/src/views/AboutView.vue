<template>
  <div class="login">
    <h1>This is an about page</h1>
    <el-form ref="aboutRef"  :model="loginForm" :rules="loginRules">
      <el-form-item prop="username">
        <el-input
                   type="text"
                   size="large"
                   auto-complete="off"
                   placeholder="账号"
        >
        </el-input>
      </el-form-item>
    </el-form>
  </div>
</template>
<script setup>

</script>
<style>

</style>
