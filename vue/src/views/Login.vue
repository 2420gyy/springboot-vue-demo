<template>
  <div style="width: 100%;height: 100vh; background-color: white; overflow: hidden">
    <div style="width: 400px;margin: 150px auto">
      <div style="color: #cccccc;font-size: 30px; text-align: center;padding: 30px 0">欢迎登录</div>
      <el-form ref="form" :model="form" label-width="80px" :rules="rules">
        <el-form-item prop="name">
          <el-input placeholder="请输入姓名" v-model="form.name">
            <template #prefix>
              <el-icon style="margin-top: 13px"><Avatar /></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input placeholder="请输入密码"
                    icon="el-icon-search" v-model="form.password" show-password>
            <template #prefix>
              <el-icon style="margin-top: 13px"><Lock /></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%;font-size: 20px" type="primary" @click="login">登 录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>

import {Avatar,Lock} from '@element-plus/icons-vue'
import {ElMessage} from "element-plus";
import request from "@/utils/request";

export default {
  name: "Login",
  components: {
    Avatar,
    Lock
  },
  data() {
    return {
      form: {},
      rules: {
        name: [
          {
            required: true,
            message: '请输入昵称',
            trigger: 'blur',
          },
          {
            min: 3,
            max: 8,
            message: '长度在三到八位之间',
            trigger: 'blur',
          },
        ],
        password: [
          {
            required: true,
            message: '请输入密码',
            trigger: 'blur',
          }
          ,
          {
            min: 1,
            max: 10,
            message: '长度在六到八位之间',
            trigger: 'blur',
          },
        ]
      }
    }
  },
  methods: {
    login() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          request.post("/user/login",this.form).then(res =>{
            if(res.code === '0'){
              ElMessage({
                message: '登录成功',
                type: 'success'
              })
              sessionStorage.setItem("user",JSON.stringify(res.data)) //缓存用户信息
              this.$router.push("/") // 页面跳转
            }else{
              ElMessage({
                message: res.msg,
                type: 'error'
              })
            }
          })
        }
      })
    }
  }
}
</script>

<style scoped>

</style>