<template>
  <el-card class="product-card">
    <div class="product-image">
      <img src="https://via.placeholder.com/150" alt="Product Image">
    </div>
    <div class="product-info">
      <h3 class="product-title">商品名称</h3>
      <p class="product-description">这里是商品的简要描述，可以放置商品的特色、卖点等信息。</p>
      <div class="product-price">
        <span>¥</span>
        <span class="price-value">199.99</span>
      </div>
      <el-button type="primary" class="add-to-cart-button">
        <img class="cart-for-productCard-icon" src="@/assets/icons/cart-for-product-card.png" alt="">
        加入购物车
      </el-button>
    </div>
  </el-card>
</template>

<script setup>
// If you're using Composition API with <script setup>
// No specific script logic is needed for this basic card,
// but you might add props for product data in a real application.
</script>

<style scoped>
.product-card {
  /* Set the background color of the card based on the image */
  background-color: #ffffff;
  border: none;
  border-radius: 30px;
  width: 300px;
  height: 350px;
  padding: 15px;
  box-sizing: border-box;
  margin: 0px;

  /* Apply the custom box-shadows */
  box-shadow:
      10px 10px 30px 0px rgba(0, 0, 0, 0.7),   /* Dark shadow */
      -5px -5px 30px 0px rgba(255, 255, 255, 0.1); /* Light shadow */

  /* Optional: Add transition for hover effects */
  transition: all 0.3s ease;
}

.product-card:hover {
  /* Optional: Slight lift or change on hover */
  transform: translateY(-5px);
  box-shadow:
      30px 30px 80px 0px rgba(0, 0, 0, 1),
      -30px -30px 80px 0px rgba(255, 255, 255, 0.18);
}

.product-image img {
  width: 100%;
  height: auto;
  border-radius: 8px; /* Slightly rounded corners for the image */
  margin-bottom: 15px;
  display: block; /* Remove extra space below image */
}

.product-info {
  color: #f0f0f0; /* Light text color for contrast */
}

.product-title {
  font-size: 1.2em;
  margin-bottom: 8px;
  color: #fff; /* Slightly brighter for title */
}

.product-description {
  font-size: 0.9em;
  line-height: 1.5;
  margin-bottom: 15px;
  color: #ccc;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2; /* Limit description to 2 lines */
  -webkit-box-orient: vertical;
}

.product-price {
  font-size: 1.4em;
  font-weight: bold;
  margin-bottom: 15px;
  color: #000205; /* Element Plus primary color for price */
}

.product-price .price-value {
  margin-left: 5px;
}

.add-to-cart-button {
  background-color: #0c4781;
  border: none;
  width: 80%;
  padding-left: 0px;
  padding-right: 5px;
}

.cart-for-productCard-icon {
  width: 20px;
  height: 20px;
  margin-right: 15px;
}
</style>