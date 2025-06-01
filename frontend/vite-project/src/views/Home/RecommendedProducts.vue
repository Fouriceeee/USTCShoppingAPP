<template>
  <div class="recommended-products-module" ref="moduleRef">
    <div class="module-header">
      <h3>为你推荐</h3>
      <a href="#" class="more-link">查看更多 ></a>
    </div>
    <div class="products-carousel">
      <div class="products-track">
        <div v-for="product in displayedProducts" :key="product.id" class="recommended-product-item">
          <img :src="product.imageUrl" :alt="product.name" class="product-image">
          <div class="product-price">¥{{ product.price.toFixed(2) }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted, onUnmounted, nextTick } from 'vue';

// 示例推荐商品数据
const recommendedProducts = ref([
  { id: 'rec1', name: '高性能固态硬盘', imageUrl: 'https://via.placeholder.com/120x120/FFDDC1/000000?text=SSD', price: 399.99 },
  { id: 'rec2', name: '电竞机械键盘', imageUrl: 'https://via.placeholder.com/120x120/C1FFDD/000000?text=Keyboard', price: 288.00 },
  { id: 'rec3', name: '27寸高刷显示器', imageUrl: 'https://via.placeholder.com/120x120/DDC1FF/000000?text=Monitor', price: 999.00 },
  { id: 'rec4', name: '无线游戏鼠标', imageUrl: 'https://via.placeholder.com/120x120/FFC1DD/000000?text=Mouse', price: 159.50 },
  { id: 'rec5', name: '内存条 16GB', imageUrl: 'https://via.placeholder.com/120x120/C1DDFF/000000?text=RAM', price: 189.00 },
  { id: 'rec6', name: '电脑散热器', imageUrl: 'https://via.placeholder.com/120x120/DDFFC1/000000?text=Cooler', price: 120.00 },
  { id: 'rec7', name: '机械硬盘 2TB', imageUrl: 'https://via.placeholder.com/120x120/FFDDFF/000000?text=HDD', price: 450.00 },
  { id: 'rec8', name: '游戏耳机', imageUrl: 'https://via.placeholder.com/120x120/DDF1FF/000000?text=Headset', price: 300.00 },
]);

// 用于引用模块根元素，以便获取其宽度
const moduleRef = ref(null);
// 存储模块的当前宽度
const moduleWidth = ref(0);

// 定义单个商品的宽度和间距 (与 CSS 保持一致)
const ITEM_WIDTH = 120; // recommended-product-item 的宽度
const ITEM_GAP = 15;    // products-track 的 gap

// 计算属性：根据模块宽度，计算最多能显示的商品数量
const maxVisibleItems = computed(() => {
  if (moduleWidth.value === 0) return 0; // 模块宽度为0时，不显示任何商品

  // 计算一个商品及其右侧间距所占的总宽度
  const itemTotalWidth = ITEM_WIDTH + ITEM_GAP;

  // 模块可用内容区域的宽度 (减去 padding)
  // 注意：这里的 30px 是 .recommended-products-module 的左右 padding 之和 (15px + 15px)
  // 如果 .products-carousel 也有 padding，还需要减去
  const availableWidth = moduleWidth.value - 30; // 减去模块自身的左右内边距

  // 计算可以放多少个商品
  let count = Math.floor((availableWidth + ITEM_GAP) / itemTotalWidth); // +ITEM_GAP 是为了处理最后一个商品后面没有间距的情况

  // 确保至少显示一个（如果空间允许）
  return Math.max(0, count);
});

// 计算属性：根据 maxVisibleItems，切分出需要显示的商品数组
const displayedProducts = computed(() => {
  return recommendedProducts.value.slice(0, maxVisibleItems.value);
});

// ResizeObserver 用于监听模块尺寸变化
let resizeObserver = null;

onMounted(() => {
  // 确保 DOM 元素已经渲染，moduleRef 才有值
  nextTick(() => {
    if (moduleRef.value) {
      // 初始化时获取一次宽度
      moduleWidth.value = moduleRef.value.offsetWidth;

      // 创建 ResizeObserver 实例
      resizeObserver = new ResizeObserver(entries => {
        for (let entry of entries) {
          if (entry.target === moduleRef.value) {
            moduleWidth.value = entry.contentRect.width;
          }
        }
      });

      // 监听模块元素
      resizeObserver.observe(moduleRef.value);
    }
  });
});

onUnmounted(() => {
  // 组件卸载时停止监听
  if (resizeObserver) {
    resizeObserver.disconnect();
  }
});
</script>

<style scoped>
.recommended-products-module {
  background-color: #ffffff; /* 模块背景色 */
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  padding: 15px; /* 模块内边距 */
  margin-bottom: 20px; /* 与下方元素的间距 */
  box-sizing: border-box;

  /* 根据窗口大小调整长短，并设置最长和最短值 */
  /* 强制高度为 ImageCarousel 的一半 */
  overflow: hidden; /* 确保内容超出时被裁剪 */
  width: 100%; /* 默认填充父容器宽度 */
  min-width: 300px; /* 模块最小宽度 */
  max-width: 600px; /* 模块最大宽度 */
  display: flex; /* 使用 flex 垂直布局头部和内容区域 */
  flex-direction: column;
}

.module-header {
  display: flex;
  height: 10px;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 0px;   /* 与下方元素的间距 */
  padding-bottom: 10px;   /* 模块内边距 */
  flex-shrink: 0;   /* 头部不压缩 */
}

.module-header h3 {
  margin: 0;
  font-size: 1.1em;
  color: #333;
}

.more-link {
  font-size: 0.9em;
  color: #0b78ea;
  text-decoration: none;
  transition: color 0.2s ease;
}

.more-link:hover {
  color: #0a407e;
}

.products-carousel {
  padding-top: 10px; /* 模块内边距 */
  /* 可以选择性地添加以下，如果需要确保内部 flex 容器不超出 */
  overflow-x: hidden; /* 防止 track 溢出 carousel 容器 */
}

.products-track {
  display: flex; /* 使用 flexbox 进行横向排列 */
  gap: 15px; /* 商品之间的间距 */
  /* transition: transform 0.3s ease; /* 如果将来需要滑动效果可以添加 */
}

.recommended-product-item {
  flex-shrink: 0; /* 确保商品项在空间不足时不会收缩 */
  width: 120px; /* 单个商品的固定宽度 */
  text-align: center;
  cursor: pointer;
  padding: 5px; /* 内部留白 */
  border-radius: 4px;
  transition: transform 0.2s ease, box-shadow 0.2s ease;
}

.recommended-product-item:hover {
  transform: translateY(-3px); /* 悬停微动 */
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* 悬停阴影 */
}

.product-image {
  width: 100%;
  height: 120px; /* 图片固定高度 */
  object-fit: contain; /* 确保图片完整显示，不裁剪 */
  display: block;
  margin-bottom: 5px;
  border-radius: 4px;
  background-color: #f5f5f5; /* 简单的背景色，防止图片是透明的 */
}

.product-price {
  font-size: 1.1em;
  color: #0b78ea; /* 价格颜色 */
  font-weight: bold;
}
</style>