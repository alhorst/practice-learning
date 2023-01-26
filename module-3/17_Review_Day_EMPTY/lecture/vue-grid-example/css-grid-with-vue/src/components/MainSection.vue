<template>
  <main>
            <h2>Sandwiches</h2>
            <div class="food-item">
                <h3>Full Stack Sandwich</h3>
                <img src="@/assets/full-stack-sandwich.png" />
                <p>With an array of ingredients, it's got everything you want. C# Drumsticks, HTML-dogs, JavaScript Tomatoes, CSS Cheese, and Machine Learning Mayo.
                    <br />
                    Served with a side of SQL
                </p>
            </div>
            <div class="food-item">
                <h3>Universal Serial Burger</h3>
                <img src="@/assets/USBurger.png" />
                <p>For years, food connectivity relied on plethora of incompatible plates and tastes. Now we have the Universal Serial Burger!
                    <br />
                    Upgrade to USBurger 3.0 for just $5
                </p>
            </div>
        </main>

</template>

<script>
export default {
    name: 'main-section'
}
</script>

<style scoped>

main h2 {
    text-align: center;
    font-size: 2em;
}

div.food-item {
    text-align: center;
    padding-left: 25px;
    padding-right: 25px;
}
div.food-item img {
    max-width: 100%;
}
div.food-item p {
    line-height: 2em;
}
</style>