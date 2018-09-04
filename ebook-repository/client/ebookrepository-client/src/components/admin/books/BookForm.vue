<template>
  <section>
    <h2 class="title is-4">Create/edit book</h2>
    <b-field label="Title">
      <b-input v-model="book.title"></b-input>
    </b-field>
    <b-field label="Author">
      <b-input v-model="book.author"></b-input>
    </b-field>
    <b-field label="Keywords">
      <b-input v-model="book.keywords"></b-input>
    </b-field>
    <b-field label="Publication year">
      <b-input v-model="book.publicationYear"></b-input>
    </b-field>
    <b-field label="MIME type">
      <b-input v-model="book.mimeType" value="application/pdf"></b-input>
    </b-field>
    <b-field label="Category">
      <b-select placeholder="Select a category" expanded v-model="book.categoryId">
        <option 
              v-for="category of categories" 
              :key="category.id"
              :value="category.id">{{ category.name }} </option>
      </b-select>
    </b-field>
    <b-field label="Language">
      <b-select placeholder="Select a language" expanded v-model="book.languageId">
         <option 
              v-for="language of languages" 
              :key="language.id"
              :value="language.id">{{ language.name }} </option>
      </b-select>
    </b-field>
  </section>
</template>

<script>
import booksService from './books.service';
import { get } from '../../../fetch';

export default {
  name: 'BookForm',
  data() {
    return {
      book: {},
      categories: [],
      languages: [],
    };
  },
  created() {
    this.book = booksService.getUploadedDocInfo();
    get('categories').then(({data}) => this.categories = data);
    get('languages').then(({data}) => this.languages = data);
  },
  watch: {
    book(val) {
      booksService.setBook(val);
    }
  }
}
</script>

<style>

</style>
