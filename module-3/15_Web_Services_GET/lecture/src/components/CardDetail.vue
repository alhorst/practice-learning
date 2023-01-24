<template>
  <div>
    <div class="loading"></div>
    <h1>{{ card.title }}</h1>
    <p>{{ card.description }}</p>
    <comments-list v-bind:comments="card.comments" />
  </div>
</template>

<script>
import boardService from "../services/BoardService"
import CommentsList from "./CommentsList.vue";

export default {
  name: "card-detail",
  components: { CommentsList },
  data() {
    return {
      card: {
        title: "",
        description: "",
        status: "",
        comments: [],
      },
      isLoading: true,
    };
  },
  created() {
    this.card = boardService.getCard(this.$route.params.boardID, this.$route.params.cardID)
      .then((response) => {
        this.card = response;
        this.isLoading = false;
      })
  }
};
</script>
