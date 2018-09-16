<template>
    <section>
        <b-table 
            :data="books"
            :paginated="config.isPaginated"
            :currentPage.sync="config.currentPage"
            :per-page="config.perPage"
        >

        <template slot-scope="props">
          <b-table-column :field="config.columns[0].field" :label="config.columns[0].label" width="40" numeric>
              {{ props.row.id }}
          </b-table-column>

          <b-table-column :field="config.columns[1].field" :label="config.columns[1].label">
              {{ props.row.title }}
          </b-table-column>

          <b-table-column :field="config.columns[2].field" :label="config.columns[2].label">
              {{ props.row.author }}
          </b-table-column>

          <b-table-column :field="config.columns[3].field" :label="config.columns[3].label">
              {{ props.row.publicationYear }}
          </b-table-column>

          <b-table-column :field="config.columns[4].field" :label="config.columns[4].label">
              {{ props.row.category.name }}
          </b-table-column>

          <b-table-column :field="config.columns[5].field" :label="config.columns[5].label">
            <span>
              <a @click="setBookToEdit(props.row.id)">
                <b-icon
                package="fas"
                icon="edit">
                </b-icon>
              </a>
            </span>
          </b-table-column>
        </template>
        
        </b-table>
      <br/>
      <br/>
      <h2 class="title is-4">Create/edit book</h2>
      <step-progress :steps="stepsConfig.steps" :total="stepsConfig.total"></step-progress> 
    </section>
</template>

<script>
import BookForm from "./BookForm";
import config from "./grid.config";
import stepsConfig from "./steps.config";
import StepProgress from "../../StepProgress";
import { get } from "../../../fetch";
import booksService from './books.service';
import Vue from 'vue';

export default {
  name: "Books",
  data() {
    return {
      books: [],
      config,
      stepsConfig
    };
  },
  components: {
    StepProgress
  },
  created() {
    get("books").then(({ data }) => (this.books = data));
  },
  methods: {
    setBookToEdit(id) {
      booksService.setBook(this.books.find(b => b.id === id));
      eventHub.$emit('bookSelected');
    }
  }
};
</script>

<style>
</style>
