<template>
  <div style="padding: 10px">
<!--    功能区-->
    <div style="margin: 10px 0">
<!--      TODO 新增昵称的查重判断-->
      <el-button type="primary" size="small" @click="addUser">新增</el-button>
      <el-button type="primary" size="small">导入</el-button>
      <el-button type="primary" size="small">导出</el-button>
    </div>
<!--    搜索区-->
    <div>
      <el-row :gutter="20">
        <el-input
            v-model="search"
            placeholder="输入姓名查找"
            style="width: 160px;margin-left: 10px"
            clearable
        />
        <el-button type="primary" style="margin-left: 5px" @click="load">查询</el-button>
      </el-row>
    </div>
    <el-table
        :data="tableData"
        border
        stripe
        style="width: 100%">
      <el-table-column type="selection" width="55" />
      <el-table-column prop="id" label="Id" sortable width="130" />
      <el-table-column prop="name" label="Name" width="110" />
      <el-table-column prop="nickName" label="nickName" width="110" />
      <el-table-column prop="password" label="password" width="110" />
      <el-table-column prop="age" label="age" width="80" />
      <el-table-column prop="gender" label="gender" width="80" />
      <el-table-column prop="phone" label="Phone" width="130" />
      <el-table-column prop="email" label="Email" width="180" />
      <el-table-column prop="vip" label="VIP"
                       :filters="[
                        { text: 'isVip', value: '是' },
                        { text: 'notVip', value: '否' },
                        ]"
                       :filter-method="filterTag"
                       width="80" />
      <el-table-column align="right" width="220px">
        <template #default="scope">
          <el-button size="mini"
                     type="primary"
                     @click="handleEdit(scope.row)"
          >编辑</el-button>
          <el-popconfirm
              confirm-button-text="确认"
              cancel-button-text="取消"
              :icon="InfoFilled"
              icon-color="red"
              title="确认删除吗？"
              @confirm="handleDelete(scope.row.id)"
          >
            <template #reference>
              <el-button
                  size="mini"
                  type="danger"
              >删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin:10px 0">
<!--      分页-->
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5, 10, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="1000">
      </el-pagination>
    </div>
    <div>
<!--      对话框  :model 和 v-model-->
      <el-dialog
          title="添加用户" v-model="dialogVisible" width="30%">
        <el-form :model="userForm" label-width="120px">
          <el-form-item label="用户名" prop="name">
            <el-input v-model="userForm.name" style="width: 80%;"></el-input>
          </el-form-item>
          <el-form-item label="昵称" prop="nickName">
            <el-input v-model="userForm.nickName" style="width: 80%;"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input v-model="userForm.password" style="width: 80%;"></el-input>
          </el-form-item>
          <el-form-item label="年龄" prop="age">
            <el-input v-model="userForm.age" style="width: 80%;"></el-input>
          </el-form-item>
          <el-form-item label="性别" prop="gender">
            <el-radio v-model="userForm.gender" label="1">男</el-radio>
            <el-radio v-model="userForm.gender" label="0">女</el-radio>
          </el-form-item>
          <el-form-item label="电话" prop="phone">
            <el-input v-model="userForm.phone" style="width: 80%;"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="userForm.email" style="width: 80%;"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="saveUser">确 定</el-button>
          </span>
        </template>
      </el-dialog>
    </div>
  </div>

</template>

<script>


import request from "@/utils/request";
import {ElMessage} from 'element-plus'
export default {
  name: 'User',
  components: {
  },
  data() {
    return {
      search: '',
      currentPage: 1,
      pageSize: 5, // 每页大小
      total: 100,
      userForm: {},
      tableData: [],
      dialogVisible: false,
    }
  },
  created() {
    this.load()
  },
  methods: {
    load(){
      request.get("/user/findUser",{
        params: {
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search: this.search
        }
      }).then(res =>{
        console.log(res)
        this.tableData = res.data.records
        this.total = res.data.total
        // this.pageSize = res.data.size
        // this.currentPage = res.data.current
      })
    },
    filterTag(value, row) {
      return row.vip === value
    },
    handleEdit(row) {
      this.userForm = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true
    },
    handleDelete(id) {
      request.delete("/user/deleteUser/" + id).then(res =>{
        if(res.code === '0'){
          ElMessage({
            message: '删除成功',
            type: 'success'
          })
        }else{
          ElMessage({
            message: res.msg,
            type: 'error'
          })
        }
        this.load() // 记得重新加载数据
      })
      console.log(id)
    },
    handleSizeChange(pageSize) { // 改变每页个数
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) { //改变当前页码
      this.currentPage = pageNum
      this.load()
    },
    addUser() {
      this.dialogVisible = true
      this.userForm  = {}
    },
    saveUser() {
      if (this.userForm.id){ // 更新
        request.put("/user/updateUser",this.userForm).then(res =>{
          console.log(res)
          if(res.code === '0'){
            ElMessage({
              message: '更新成功',
              type: 'success'
            })
          }else{
            ElMessage({
              message: res.msg,
              type: 'error'
            })
          }
          this.load() //
          console.log("页面刷新")
          this.dialogVisible = false
          console.log("关闭弹框")
        })
      }else{
        request.post("/user/saveUser",this.userForm).then(res =>{
          console.log(res)
          if(res.code === '0'){
            ElMessage({
              message: '添加成功',
              type: 'success'
            })
          }else{
            ElMessage({
              message: res.msg,
              type: 'error'
            })
          }
          this.load() //
          this.dialogVisible = false
        })
      }
    }
  },
}
</script>
