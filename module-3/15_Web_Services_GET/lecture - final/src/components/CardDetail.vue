<template>
  <div>
    <div class="loading" v-if="isLoading">
      <img src="../assets/ping_pong_loader.gif" />
    </div>
    <div v-else>
      <h1>{{ card.title }}</h1>
      <p>{{ card.description }}</p>
      <!-- v-bind: is to pass as a prop -->
      <!-- comments is what it will be called in comments-list -->
      <!-- card.comments is what is is called in this component -->
      <comments-list v-bind:comments="card.comments" />
    </div>
  </div>
</template>

<script>
import boardService from "../services/BoardService";
import CommentsList from "./CommentsList.vue";
export default {
  components: { CommentsList },
  name: "card-detail",
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
    boardService
      .getCard(this.$route.params.boardID, this.$route.params.cardID)
      .then((response) => {
        this.card = response;
        this.isLoading = false;
      });
  },
};
</script>
