<template>
  <div style="padding: 10px">
<!--    功能区-->
    <div style="margin: 10px 0">
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
        />
      </el-row>
    </div>
    <el-table
        :data="tableData.filter(
        (data) =>
          !search || data.name.toLowerCase().includes(search.toLowerCase())
      )"
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
                     @click="handleEdit(scope.$index, scope.row)"
          >编辑</el-button>
          <el-popconfirm
              confirm-button-text="OK"
              cancel-button-text="No, Thanks"
              :icon="InfoFilled"
              icon-color="red"
              title="确认删除吗？"
          >
            <template #reference>
              <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)"
              >删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin:10px 0">
      <el-pagination background
                     layout="prev, pager, next"
                     :total="100">
      </el-pagination>
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
            <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
          </span>
        </template>
      </el-dialog>
    </div>
  </div>

</template>

<script>


export default {
  name: 'Home',
  components: {
  },
  data() {
    return {
      userForm: {},
      tableData: [

        {
          id: '20181107134',
          name: 'Tom',
          nickName: 'Tom',
          password: '123',
          age: '12',
          gender: '男',
          phone: '18727897867',
          email:'2420191325@qq.com',
          vip:'是'
        }

      ],
      dialogVisible: false,
      search: ''
    }
  },
  methods: {
    filterTag(value, row) {
      return row.vip === value
    },
    handleEdit(index, row) {
      console.log(index, row)
    },
    handleDelete(index, row) {
      console.log(index, row)
    },
    addUser() {
      this.dialogVisible = true
      this.userForm  = {}
    }
  },
}
</script>
