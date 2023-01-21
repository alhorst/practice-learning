<template>
  <form class="new-book-form" v-on:keyup.enter="add">
    <input type="text" class="title-input" v-model="book.title" />
    <input type="text" class="author-input" v-model="book.author" />
    <input type="text" class="isbn-input" v-model="book.isbn" />
  </form>
</template>

<script>
export default {
  data() {
    return {
      book: {
        title: "",
        author: "",
        isbn: "",
        read: false,
      },
    };
  },
  methods: {
    add() {
      this.$store.commit("ADD_NEW", this.book);
    },
  },
};
</script>

<style>
</style>