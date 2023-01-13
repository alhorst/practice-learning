<template>
  <div class="todo-list">
     <input type="text" v-model="filterText"/>
     <h1>My Daily Routine</h1>
     <ul>
          <li v-for="todo in todos" 
          v-bind:key="todo.name"
          v-bind:class="{ finished: todo.done}">
          <input type="checkbox" 
          v-model="todo.done" />
          {{ todo.name }}
          </li>
     </ul>
  </div>
</template>

<script>
export default {
     data() {
          return {
               filterText: '',
               todos: [
                    {
                         name: 'Wake Up',
                         done: false
                    },
                    {
                         name: '5 Minute Movement',
                         done: false
                    },
                    {
                         name: 'Meditate',
                         done: false
                    },
                    {
                         name: 'Shower',
                         done: false
                    }
               ]
               }
          }
          }
</script>

<style>
input[type=text] {
     width: 75%;
     margin: auto;
  font-size: 2em;
  display: block;
}
.todo-list {
     width: 450px;
     background: #fff;
     margin: 50px auto;
     font-family: 'Roboto Condensed', sans-serif;
     border-radius: 10px;
}
h1 {
    background: #f2f2f2;
    color: #4b86A6;
    padding: 10px;
    font-size: 24px;
    text-transform: uppercase;
    text-align: center;
    margin-bottom: 0px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}
ul {
    list-style-type: none;
    margin: 0px;
    padding: 0px;
}
li {
    font-size: 24px;
    border-bottom: 1px solid #f2f2f2;
    padding: 10px 20px;
}
li:last-child {
    border: 0px;
}

.finished {
     background-color: grey;
}
</style>