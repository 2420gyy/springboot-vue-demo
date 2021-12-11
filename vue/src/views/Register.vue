<template>
  <div style="width: 100%;height: 100vh; background-color: white; overflow: hidden">
    <div style="width: 400px;margin: 150px auto">
      <div style="color: #cccccc;font-size: 30px; text-align: center;padding: 30px 0">欢迎注册</div>
      <el-form ref="form" :model="form" label-width="80px" :rules="rules">
        <el-form-item prop="name">
          <el-input placeholder="请输入姓名" v-model="form.name" @blur.prevent="judgeName">
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
        <el-form-item prop="confirm">
          <el-input placeholder="再次输入密码"
                    icon="el-icon-search" v-model="form.confirm" show-password>
            <template #prefix>
              <el-icon style="margin-top: 13px"><Lock /></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%;font-size: 20px" type="primary" @click="register">注 册</el-button>
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
        ]
      }
    }
  },
  methods: {
    register() {

      if (this.form.password != this.form.confirm) {
        this.$message({
          type: 'error',
          message: '2次输入密码不一致'
        })
        return
      }

      this.$refs["form"].validate((valid) => {
        if (valid) {
          request.post("/user/register", this.form).then(res => {
            if (res.code === '0') {
              ElMessage({
                message: '注册成功',
                type: 'success'
              })
              this.$router.push("/login") // 页面跳转
            } else {
              ElMessage({
                message: res.msg,
                type: 'error'
              })
            }
          })
        }
      })
    },
    judgeName() {
      if (this.form.name != null) {
        request.get("/user/judgeName",{
          params: {
            nickName: this.form.name
          }
        }).then(res =>{
          if (res.code === '0') {
            ElMessage({
              message: '昵称可用',
              type: 'success'
            })
          } else {
            ElMessage({
              message: res.msg,
              type: 'error'
            })
          }
        })
      }
    }
  }
}
</script>

<style scoped>

</style>