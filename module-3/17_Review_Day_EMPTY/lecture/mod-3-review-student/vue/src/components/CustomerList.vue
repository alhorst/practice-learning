<template>
     <div class="main mx-auto">
          <p v-for="customer in customers" :key="customer.id">
               {{ customer.customerName }}</p>
     </div>
</template>

<script>
import tenmoService from "../services/TenmoService"
export default {
     name: 'customer-list',
     data() {
          return {
               customers: []
          }
     },
     created() {
          tenmoService.getCustomers().then(response => {
               this.customers = response.data;
               this.$store.commit("SET_CUSTOMERS", this.customers); //
          })

     }
}
</script>

<style>

</style>