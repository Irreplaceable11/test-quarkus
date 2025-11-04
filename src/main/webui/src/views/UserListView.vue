<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { ElMessage } from 'element-plus'
import { getUserList, type User } from '@/api/user'

const users = ref<User[]>([])
const loading = ref(false)

const fetchUsers = async () => {
  loading.value = true
  try {
    const result = await getUserList()
    users.value = result.data || []
    ElMessage.success('数据加载成功')
  } catch (error) {
    console.error('获取用户列表失败:', error)
    ElMessage.error('获取用户列表失败')
  } finally {
    loading.value = false
  }
}

onMounted(() => {
  fetchUsers()
})
</script>

<template>
  <div class="user-list-container">
    <el-card>
      <template #header>
        <div class="card-header">
          <h2>用户列表</h2>
          <el-button type="primary" @click="fetchUsers" :loading="loading">
            刷新
          </el-button>
        </div>
      </template>

      <el-table :data="users" v-loading="loading" stripe style="width: 100%">
        <el-table-column prop="id" label="ID" width="80" />
        <el-table-column prop="name" label="姓名" min-width="150" />
        <el-table-column prop="gender" label="性别" min-width="200">
          <template #default="{ row }">
            {{ row.gender || '-' }}
          </template>
        </el-table-column>
      </el-table>

      <el-empty v-if="!loading && users.length === 0" description="暂无数据" />
    </el-card>
  </div>
</template>

<style scoped>
.user-list-container {
  padding: 20px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.card-header h2 {
  margin: 0;
  font-size: 20px;
  color: #303133;
}
</style>
