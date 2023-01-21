<template>
  <div id="prod-detail">
    <h1>{{ product.name }}</h1>
    <p class="description">{{ product.description }}</p>
    <div class="actions">
      <router-link v-bind:to="{ name: 'products' }"
        >Back to Products</router-link
      >&nbsp;|
      <router-link
        v-bind:to="{ name: 'add-review', params: { id: product.id } }"
        >Add Review</router-link
      >
    </div>
    <div class="well-display">
      <average-summary />
      <star-summary rating="1" />
      <star-summary rating="2" />
      <star-summary rating="3" />
      <star-summary rating="4" />
      <star-summary rating="5" />
    </div>
    <review-list />
  </div>
</template>

<script>
import AverageSummary from "AverageSummary.vue";
import StarSummary from "StarSummary.vue";
import ReviewList from "ReviewList.vue";

export default {
  components: {
    AverageSummary,
    StarSummary,
    ReviewList,
  },
  props: ["product"],
};
</script>

<style>
</style>