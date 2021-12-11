git add . ->将修改添加至本地缓存
git commit -m 'msg' ->将本地缓存保存到本地仓库中
git push ->将本地仓库推送至服务器
git pull ->将服务器的代码更新到本地仓库中

实体字段加 @TableLogic 在进行查询时会自动加上IS_DELETE=0

user.vue
:data="tableData
.filter(
(data) =>
!search || data.name.toLowerCase().includes(search.toLowerCase())
)"

