<template>
    <section>
        <b-table 
            :data="books" 
            :columns="config.columns"
            :paginated="config.isPaginated"
            :currentPage.sync="config.currentPage"
            :per-page="config.perPage"
        ></b-table>
      <step-progress :steps="stepsConfig.steps" :total="stepsConfig.total"></step-progress> 
    </section>
</template>

<script>
import BookForm from './BookForm';
import config from './grid.config';
import stepsConfig from './steps.config';
import StepProgress from '../../StepProgress';
import { get } from '../../../fetch';

export default {
  name: "Books",
  data() {
    return {
      books: [],
      config,
      stepsConfig,
    };
  },
  components: {
    StepProgress
  },
  created() {
    get('books').then(({data}) => this.books = data);
  }
};
</script>

<style>
</style>
