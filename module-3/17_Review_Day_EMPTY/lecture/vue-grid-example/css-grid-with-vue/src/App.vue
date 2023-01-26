<template>
  <div id="app">
    <div class="container">
      <page-header />
      <side-bar />
      <main-section />
      <aside-section />
      <footer-section />
    </div>
  </div>
</template>

<script>
import AsideSection from "./components/AsideSection.vue";
import FooterSection from "./components/FooterSection.vue";
import MainSection from "./components/MainSection.vue";
import PageHeader from "./components/PageHeader.vue";
import SideBar from "./components/SideBar.vue";

export default {
  name: "App",
  components: {
    PageHeader,
    SideBar,
    MainSection,
    AsideSection,
    FooterSection,
  },
};
</script>

<style>
/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */

html {
  
    font-size: 16px;
}
#app {
  /* margin: 0;
    padding: 0;
    background-color: rgba(192, 192, 192, 0.35);
     */
    box-sizing: border-box;
    font-family: Tahoma, Verdana, Segoe, sans-serif;
}
header {
    grid-area: header;
}

header h1 {
    font-size: 3em;
}


.sidebar li, .sidebar h3 {
    text-transform: uppercase;
}


.sidebar ul {
    padding-left: 0;
    margin-top: 10px;
}

.sidebar li {
    display: list-item;
    list-style-type: none;
    padding-bottom: 20px;
}


nav#menu-nav {
    grid-area: menu-nav;
}

main {
    grid-area: main;
}

aside {
    grid-area: upcoming-events;
}

footer {
    grid-area: footer;
}

header,
.sidebar,
main,
footer {
  border: solid black 1px;
}


.container {
  padding: 0.5rem;
    display: grid;
    grid-template-columns: 200px 1fr 200px;
    grid-template-areas:
        "header header header"
        "menu-nav main upcoming-events"
        "footer footer footer"
    ;
    height: 100vh;
    gap: 10px;
}

a {
  color: blue;
  text-decoration: none;
}


body {
    margin: 0;
    padding: 0;
    background-color: rgba(192, 192, 192, 0.35);
}

</style>
