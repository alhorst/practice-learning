<template>
  <div class="card">
    <h2 class="book-title">{{ book.title }}</h2>
    <img
      v-if="book.isbn"
      v-bind:src="
        'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'
      "
    />
    <h3 class="book-author">{{ book.author }}</h3>
    <button
      class="mark-read"
      v-if="book.read === false"
      v-on:click="readOrUnread('read')"
    >
      Mark Read
    </button>
    <button
      class="mark-unread"
      v-if="book.read === true"
      v-on:click="readOrUnread('unread')"
    >
      Mark Unread
    </button>
  </div>
</template>

<script>
export default {
  name: "book-card",
  props: ['book'],
  methods: {
      readOrUnread(status) {
          if (status === 'read') {
              document.querySelector(".card").classList.add('read');
              this.$store.commit("CHANGE_READ", this.book);
          } else {
              document.querySelector(".card").classList.remove('read');
              this.$store.commit("CHANGE_UNREAD", this.book);
          }
      }
  }
};
</script>

<style>
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
}

.card.read {
  background-color: lightgray;
}

.card .book-title {
  font-size: 1.5rem;
}

.card .book-author {
  font-size: 1rem;
}
</style>