<template>
  <div class="home-page">
    <!-- 顶部导航栏组件 -->
    <top-nav />

    <!-- 页面主内容 -->
    <main class="main-content">
      <h1>首页</h1>

      <!-- 商品卡片区域 -->
      <div class="product-grid">
        <ProductCard />
        <ProductCard />
        <ProductCard />
        <ProductCard />
      </div>

      <!-- 模拟滚动内容 -->
      <div style="height: 2000px;">
        <p>滚动内容测试...</p>
      </div>
    </main>
  </div>
</template>

<script>
import topNav from './topNav.vue'
import ProductCard from "@/views/Products/productCard.vue";

export default {
  name: 'Home',
  components: {
    ProductCard,
    topNav
  }
}
</script>

<style scoped>
.product-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
  gap: 30px;
  padding: 20px;
  justify-content: center;
}



</style>
