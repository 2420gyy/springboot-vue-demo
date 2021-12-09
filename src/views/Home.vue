<template>
  <div style="padding: 10px">
<!--    功能区-->
    <div style="margin: 10px 0">
      <el-button type="primary" size="small">新增</el-button>
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
      <el-table-column prop="name" label="Name" width="130" />
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
      tableData: [
        {
          id: '20181107134',
          name: 'Tom',
          phone: '18727897867',
          email:'2420191325@qq.com',
          vip:'是'
        },
        {
          id: '20181107135',
          name: 'James',
          phone: '18727897867',
          email:'2420191325@qq.com',
          vip:'是'
        },
        {
          id: '20181107136',
          name: 'Jerry',
          phone: '18727897867',
          email:'2420191325@qq.com',
          vip:'否'
        },
      ],
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
  },
}
</script>
