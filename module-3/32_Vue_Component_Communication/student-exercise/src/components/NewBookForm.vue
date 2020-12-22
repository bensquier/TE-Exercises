<template>
    <div class="new-book">
        <form v-on:submit.prevent="addNewBook" class="new-book-form">
            <input type="text" placeholder="Title" class="title-input" v-model="newBook.title" />
            <input type="text" placeholder="Author" class="author-input" v-model="newBook.author" />
            <input type="text" placeholder="ISBN" class="isbn-input" v-model="newBook.isbn" />

            <button type="submit">Add</button>
            <button v-on:click.prevent="resetForm">Cancel</button>
        </form>
    </div>
</template>

<script>
export default {
    data() {
        return {
            newBook: {
                read: false,
            }
        };
    },
    methods: {
        addNewBook() {
            this.$store.commit("ADD_BOOK", this.newBook);
            this.resetForm();
        },
        resetForm() {
            this.newBook = {
                read: false,
            };
        }
    }
}
</script>

<style>
div.form-element {
    margin-top: 10px;
}
div.form-element > label {
    display: block;
}
form > input[type="button"] {
    width: 100px;
}
form > input[type="submit"] {
    width: 100px;
    margin-right: 10px;
}
</style>