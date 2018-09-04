<template>
  <section>
    <b-table 
      :data="categories" 
      :columns="config.columns"
      :paginated="config.isPaginated"
      :currentPage.sync="config.currentPage"
      :per-page="config.perPage"
    ></b-table>
    <category-form v-on:saveCategory="save"></category-form>
  </section>
</template>

<script>
import CategoryForm from "./CategoryForm";
import { get, post } from "../../../fetch";
import config from "./grid.config";

export default {
  name: "Categories",
  data() {
    return {
      categories: [],
      config
    };
  },
  components: {
    CategoryForm
  },
  created() {
    get("categories").then(({ data }) => (this.categories = data));
  },
  methods: {
    save(category) {
      post('categories', category).then(({data}) => this.categories.push(data))
    }
  }
};
</script>

<style>
</style>
