<template>
    <div>
        <reading-list />
        <div class="actions">
            <router-link v-bind:to="{ name: 'add-book' }">Add Book to Reading List</router-link>
        </div>
    </div>
</template>

<script>
import ReadingList from '../components/ReadingList.vue'
export default {
  components: { 
    ReadingList,
    },

}
</script>

<style>

</style>