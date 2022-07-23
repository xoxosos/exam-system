import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueJsx from '@vitejs/plugin-vue-jsx'

// https://vitejs.dev/config/
export default defineConfig({
  server: {  //跨域请求设置
    open: true,// 是否自动启动浏览器
    proxy: { // 本地开发环境通过代理实现跨域
      // 正则表达式写法
      '/api': {     // api代理target 所有api的请求都会被拦截
        target: 'http://localhost:8080/',  // 后端服务实际地址
        changeOrigin: true, //开启代理，是否跨域
        rewrite: (path) => path.replace(/^\/api/, '') //重写路径
      }
    }
  },
  plugins: [vue(), vueJsx()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  css:{
    devSourcemap:true,
  }
})
