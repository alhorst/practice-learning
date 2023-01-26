<template>
  <header>
    <h1>Bits & Bytes</h1>
    <nav id="site-nav">
      <ul>
        <li><a href="#">Menu</a></li>
        <li><a href="#">Events</a></li>
        <li><a href="#">About Us</a></li>
      </ul>
    </nav>
  </header>
</template>

<script>
export default {
  name: 'page-header'
};
</script>

<style scoped>
header {
    padding: 0 10px;
    text-align: center;
}
nav#site-nav ul {
    padding-left: 0;
}

nav#site-nav li {
    display: inline-block;
    list-style: none;
    padding-left: 10px;
    padding-right: 10px;
}

nav#site-nav li a {
    text-transform: uppercase;
    text-decoration: none;
}
</style>