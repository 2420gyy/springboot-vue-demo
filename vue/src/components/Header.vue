<template>
  <div style="height: 50px;line-height: 50px;border-bottom: 1px solid #cccccc;display: flex">
    <div style="width: 200px; padding-left: 30px; font-weight: bold; color: dodgerblue">后台管理</div>
    <div style="flex: 1"></div>
    <div style="width: 100px">
      <el-dropdown>
<!--        <span class="el-dropdown-link">-->
<!--          <el-avatar :size="30" :src="user.avatar" style="position: relative; top: 10px"></el-avatar>-->
<!--           {{ user.nickName }}-->
<!--          <i class="el-icon-arrow-down el-icon&#45;&#45;right"></i>-->
<!--        </span>-->
        <span class="el-dropdown-link">
          张三
          <el-icon class="el-icon--right">
            <arrow-down/>
          </el-icon>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="$router.push('/person')">个人信息</el-dropdown-item>
            <el-dropdown-item @click="$router.push('/password')">修改密码</el-dropdown-item>
            <el-dropdown-item @click.native="$router.push('/login')">退出</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>

export default {
  name: "Header"
}
</script>

<style scoped>

</style>