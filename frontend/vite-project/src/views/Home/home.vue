<template>
  <div class="home-page">
    <top-nav />

    <div class="page-container">
      <CategorySidebar class="home-category-sidebar" />
      <ImageCarousel />
      <main class="main-content">
        <h1>首页</h1>

        <div class="product-grid">
          <ProductCard />
          <ProductCard />
          <ProductCard />
          <ProductCard />
          <ProductCard />
          <ProductCard />
          <ProductCard />
          <ProductCard />
        </div>

        <div style="height: 1000px; padding: 20px;">
          <p>滚动内容测试...</p>
          <p>更多内容...</p>
        </div>
      </main>
    </div>
  </div>
</template>

<script>
import topNav from './topNav.vue'
import ProductCard from "@/views/Products/productCard.vue";
import CategorySidebar from "@/views/Home/CategorySidebar.vue";
import ImageCarousel from "@/views/Home/ImageCarousel.vue";

export default {
  name: 'Home',
  components: {
    ImageCarousel,
    CategorySidebar,
    ProductCard,
    topNav
  }
}
</script>

<style scoped>
.home-page {
  background-color: #f0f2f5;
  min-height: 100vh;
}

/* 页面主内容容器：实现居中和两侧留白 */
.page-container {
  max-width: 1500px; /* 设置最大宽度 */
  min-width: 960px;
  margin: 0 auto;
  padding: 10px 20px;
  box-sizing: border-box;
}

.main-content {
  padding-top: 20px;
}

h1 {
  text-align: center;
  margin-bottom: 30px;
  color: #333;
}

.product-grid {
  display: grid;
  grid-template-columns: repeat(4, 300px);
  row-gap: 40px;    /* 上下间距 */
  column-gap: 35px; /* 左右间距 */
  justify-content: center;
}

</style>