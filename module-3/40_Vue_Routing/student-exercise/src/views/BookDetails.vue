<template>
  <div>
    <h1>{{book.title}}</h1>
    <h1>{{book.author}}</h1>
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
  </div>
</template>

<script>

export default {
    name: 'book-details',
    computed: {
        book() {
            return this.$store.state.books.find(
                book => book.isbn == this.$store.state.activeBook
            );
        }
    },
    created() {
        const activeBookISBN = this.$route.params.isbn;
        this.$store.commit('SET_ACTIVE_BOOK', activeBookISBN);
    }
}
</script>

<style>

</style>