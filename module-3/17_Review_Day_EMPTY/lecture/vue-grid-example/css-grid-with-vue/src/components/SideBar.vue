<template>
  <nav id="menu-nav" class="sidebar">
            <h3>Menu</h3>
            <ul>
                <li><a href="#">Breakfast</a></li>
                <li><a href="#">Lunch</a></li>
                <li><a href="#">Dinner</a>
                    <ul class="sub-menu">
                        <li class="sub-menu-item"><a href="#">Appetizers</a></li>
                        <li class="sub-menu-item active"><a href="#">Sandwiches</a></li>
                        <li class="sub-menu-item"><a href="#">Platters</a></li>
                    </ul>
                </li>
                <li><a href="#">Dessert</a></li>
                <li><a href="#">Beverages</a></li>
            </ul>
        </nav>
</template>

<script>
export default {
    name: 'side-bar'

}
</script>

<style scoped>


nav#menu-nav {
    text-align: center;
}


.sidebar li, .sidebar h3 {
    text-transform: uppercase;
}

.sidebar li.sub-menu-item {
    display: list-item;
    text-transform: capitalize;
    font-size: 0.9em;
}

.sidebar a {
    text-decoration: none;
}
.sidebar a:hover, nav#site-nav li a:hover {
    text-decoration: underline;
}
.sidebar .active {
    font-weight: bold;
}



ul.sub-menu {
    border-top: solid rgba(0, 0, 0, 0.25) 1px;
    border-bottom: solid rgba(0, 0, 0, 0.25) 1px;
    color: rgba(0, 0, 0, 0.6);
    width: 75%;
    margin: 10px auto;
}

</style>