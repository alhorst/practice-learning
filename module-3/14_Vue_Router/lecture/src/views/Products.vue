<template>
     <div id="products">
          <h1>products</h1>
          <products-list />

     </div>
</template>

<script>
import ProductsList from "..components/ProductsList.vue"
export default {
     name: "products",
     components: {
          ProductsList
     },
};
</script>

<style>

</style>
