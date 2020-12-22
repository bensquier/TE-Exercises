<template>
  <div>
      <h1>{{ product.name }}</h1>
      <p class="description">{{ product.description }}</p>
      <div class="actions">
          <router-link v-bind:to="{ name: 'products' }"> Return to Products </router-link>
          <router-link v-bind:to="{ name: 'add-review', params: {id: product.id}}"> Add a Review </router-link>
      </div>
      <div class="well-display">
          <average-summary />
          <star-summary rating="1"></star-summary>
          <star-summary rating="2"></star-summary>
          <star-summary rating="3"></star-summary>
          <star-summary rating="4"></star-summary>
          <star-summary rating="5"></star-summary>
      </div>
      <review-list />
  </div>
</template>

<script>
import AverageSummary from '../components/AverageSummary.vue';
import StarSummary from '../components/StarSummary.vue';
import AddReview from '../components/AddReview.vue'
import ReviewList from '../components/ReviewList.vue';

export default {
    name: 'product-detail',
    components: {
        AverageSummary, 
        ReviewList,
        StarSummary,
        AddReview
    },
    computed: {
        product() {
            return this.$store.state.products.find(
                prod => prod.id == this.$store.state.activeProduct
            );
        }
    },
    created() {
        const activeProductID = this.$route.params.id;
        this.$store.commit('SET_ACTIVE_PRODUCT', activeProductID);
    }
    
}
</script>

<style>
img {
    height: 2rem;
}
</style>