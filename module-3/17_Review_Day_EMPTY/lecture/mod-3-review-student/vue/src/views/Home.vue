<template>
  <div class="home main mx-auto">
    <h1>Welcome User!</h1>
    <div class="prompt">What would you like to do?</div>
    <ul>
      <li class="choice">
        <router-link v-bind:to="{ name: 'balance' }">
          View your Balance
        </router-link>
      </li>
      <li class="choice">
        <router-link v-bind:to="{ name: 'customers' }">
        View Customer List
        </router-link>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style scoped>
.prompt {
  font-size: 18px;
  font-weight: bold;

  border: 2px solid black;
  padding: 10px;
  width: 70%;
}

.choice,
.choice a {
  color: blue;
  font-weight: bold;
}
</style>
