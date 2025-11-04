import request from '@/utils/request'

export interface User {
  id: number
  name: string
  email?: string
  [key: string]: any
}

export interface Result<T> {
  code: number
  message: string
  data: T
}

// 获取用户列表
export const getUserList = () => {
  return request.get<any, Result<User[]>>('/user/list')
}
