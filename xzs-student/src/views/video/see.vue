<template>
  <vueVideoPlayer :src="data.url" :cover_url="data.cover_url" />
</template>

<script>
import vueVideoPlayer from './vueVideoPlayer'
export default {
  name: 'vueVideoPlayer',
  props: {
    src: {
      type: String
    },
    cover_url: {
      type: String
    }
  },
  // 不要忘记注册
  components: {
    vueVideoPlayer
  }
}
