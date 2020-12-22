<template>
  <div class="topic-list">
    <div class="topic" 
      v-for="topic in topics" 
      v-bind:key="topic.id"
      >
      <router-link v-bind:to="{ name: 'Messages', params: { id: topic.id }}">
      {{ topic.title }}
      </router-link>
    </div>
  </div>
</template>

<script>
import topicsServices from '../services/TopicsServices.js';

export default {
  name: 'topic-list',
  data() {
    return {
      topics: []
    }
  },
  methods: {
    viewTopic(id) {
      this.$router.push(`/:${id}`);
    }
  },
  created() {
    topicsServices.getTopics().then((response) => {
      this.topics = response.data;
    });
  }
}
</script>

<style>
.topic-list {
  padding: 20px 20px;
  margin: 0 auto;
  max-width: 600px;
}
.topic {
  font-size: 24px;
  border-bottom: 1px solid #f2f2f2;
  padding: 10px 20px;
}
.topic:last-child {
  border: 0px;
}
</style>