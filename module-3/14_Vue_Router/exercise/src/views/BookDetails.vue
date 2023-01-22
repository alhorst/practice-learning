<template>
  <div>
    <book-card v-bind:book="book" v-bind:key="book.isbn" />
  </div>
</template>

<script>
import BookCard from "../components/BookCard.vue";
export default {
  components: { BookCard },
  computed: {
    book() {
      return this.$store.state.books.find((book) => {
        return book.isbn === this.$route.params.isbn;
      });
    },
  },
};
</script>

<style>
</style>