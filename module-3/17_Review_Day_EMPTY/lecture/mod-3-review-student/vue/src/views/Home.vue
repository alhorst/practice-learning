<template>
  <div class="home main mx-auto">
    <h1>Welcome User!</h1>
    <div class="prompt">What would you like to do?</div>
    <ul>
      <li class="choice">
        View your Balance
      </li>
      <li class="choice">
        View Customer List
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

.choice, .choice a {
  color: blue;
  font-weight: bold;
}
</style>
