<template>
  <div>
    <el-menu
        style="width: 200px; min-height: calc(100vh - 50px)"
        default-active="path"
        router
        class="el-menu-vertical-demo">
<!--        :collapse="isCollapse"-->
<!--        @open="handleOpen"-->
<!--        @close="handleClose"-->

      <el-menu-item index="/user">
        <el-icon><avatar /></el-icon>
        <template #title>用户管理</template>
      </el-menu-item>
      <el-menu-item index="/course">
        <el-icon><icon-menu /></el-icon>
        <template #title>课程管理</template>
      </el-menu-item>
      <el-menu-item index="/money">
        <el-icon><document /></el-icon>
        <template #title>收益信息</template>
      </el-menu-item>
      <el-menu-item index="/other">
        <el-icon><setting /></el-icon>
        <template #title>其他</template>
      </el-menu-item>
    </el-menu>
<!--    <el-radio-group v-model="isCollapse" style="margin-bottom: 20px">-->
<!--      <el-radio-button :label="false">展开</el-radio-button>-->
<!--      <el-radio-button :label="true">折叠</el-radio-button>-->
<!--    </el-radio-group>-->
  </div>
</template>

<script>
import { defineComponent, ref } from 'vue'
import {
  Avatar,
  Document,
  Menu as IconMenu,
  Setting,
} from '@element-plus/icons'

export default defineComponent({
  name: "Aside",
  components: {
    Avatar,
    Document,
    Setting,
    IconMenu,
  },
  data (){
    return {
      path: this.$route.path
    }
  },
  setup() {
    const isCollapse = ref(true)
    const handleOpen = (key, keyPath) => {
      console.log(key, keyPath)
    }
    const handleClose = (key, keyPath) => {
      console.log(key, keyPath)
    }
    return {
      isCollapse,
      handleOpen,
      handleClose,
    }
  },
})
</script>

<style scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
</style>