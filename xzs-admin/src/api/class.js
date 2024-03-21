import { post } from '@/utils/request'
export default {
  selectByClass: query => post('/api/admin/class/classlist', query),
  selectByMajor: query => post('api/admin/class/majorlist', query)
}
