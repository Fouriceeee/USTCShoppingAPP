<script setup>

</script>

<template>
  <div style="width: 100vw; height: 100vh; overflow: hidden; display: flex">
    <div style="flex: 1; background-color: black">
      <el-image style="width: 100%; height: 100%"
          src="https://img-s-msn-com.akamaized.net/tenant/amp/entityid/BB1msIoR?w=0&h=0&q=60&m=6&f=jpg&u=t"></el-image>
    </div>
    <div class="right-card">
      我是aaaaaaaaaaa
    </div>
    <router-view/>
  </div>
</template>

<style scoped>
.right-card {
  width: 400px;
  z-index: 1;
  background-color: white;
}
</style>