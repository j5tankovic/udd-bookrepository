<template>
  <section>
    <b-table 
      :data="categories"
      :paginated="config.isPaginated"
      :currentPage.sync="config.currentPage"
      :per-page="config.perPage"
    >
    <template slot-scope="props">
        <b-table-column :field="config.columns[0].field" :label="config.columns[0].label" width="40" numeric>
            {{ props.row.id }}
        </b-table-column>

        <b-table-column :field="config.columns[1].field" :label="config.columns[1].label">
            {{ props.row.name }}
        </b-table-column>

        <b-table-column :field="config.columns[2].field" :label="config.columns[2].label">
          <span>
            <a @click="setCategoryToEdit(props.row.id)">
              <b-icon
               package="fas"
               icon="edit">
              </b-icon>
            </a>
          </span>
        </b-table-column>
      </template>
    
    </b-table>
    <category-form 
      v-on:saveCategory="save"
      v-on:cancel="cancel"
      :categoryForForm="categoryForForm">
    </category-form>
  </section>
</template>

<script>
import CategoryForm from "./CategoryForm";
import { get, post, put } from "../../../fetch";
import config from "./grid.config";

const mode = {
  CREATE: "CREATE",
  EDIT: "EDIT"
};

export default {
  name: "Categories",
  data() {
    return {
      categories: [],
      config,
      selectedCategoryId: -1
    };
  },
  components: {
    CategoryForm
  },
  created() {
    get("categories").then(({ data }) => (this.categories = data));
  },
  methods: {
    save({ category, mode }) {
      if (mode === mode.CREATE) {
        post("categories", category).then(({ data }) => {
          this.selectedCategoryId = -1;
          this.categories.push(data);
        });
      } else {
        put("categories", category).then(({data}) => {
          this.selectedCategoryId = -1;
          get("categories").then(({ data }) => (this.categories = data));
        });
      }
    },
    setCategoryToEdit(id) {
      this.selectedCategoryId = this.categories.find(cat => cat.id === id)
        ? id
        : -1;
    },
    cancel() {
      this.selectedCategoryId = -1;
    }
  },
  computed: {
    categoryForForm() {
      if (this.selectedCategoryId !== -1) {
        return this.categories.find(cat => cat.id === this.selectedCategoryId);
      }
      return {};
    }
  }
};
</script>

<style>
</style>
