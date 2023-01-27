<template>
<div class="main mx-auto">

</div>
</template>

<script>
import TenmoService from '../services/TenmoService';

export default{
     name: 'view-balance',
     data() {
          return {
               balance: Number,
          };
     },
     created() {
          TenmoService.getBalance().then((response) => {
               this.balance = response.data;
               this.balance = this.balance.toFixed(2);
          });
     },
};
</script>

<style>
</style>