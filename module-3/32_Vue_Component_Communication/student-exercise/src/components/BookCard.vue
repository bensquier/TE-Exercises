<template>
  <div class="card" v-bind:class="{ read: book.read }">
        <h1 class="book-title">{{ book.title }}</h1>
        <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
        <p class="book-author">{{ book.author }}</p>
        <button 
            v-bind:class="readOrUnread()"
            v-on:click="readSwitch(book)">
            {{book.read?'Mark Unread':'Mark Read'}}
        </button>
    </div>
</template>

<script>
export default {
    name: 'book-card',
    props: ['book'],
    methods: {
        readSwitch(book) {
            this.$store.commit('FLIP_READ', book);
        },
        readOrUnread() {
            if(this.book.read){
                return 'mark-unread';
            }else {
                return 'mark-read';
            }
        }
    }
}
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