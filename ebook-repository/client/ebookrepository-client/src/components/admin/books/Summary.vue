<template>
  <section>
    <div class="column">
      <h2 class="is-size-5">Filename:</h2>
      <h3 class="is-size-6">{{summaryBook.filename}}</h3>
    </div>
    <hr/>
    <div class="column">
      <h2 class="is-size-5">Title:</h2>
      <h3 class="is-size-6">{{summaryBook.title}}</h3>
    </div>
    <hr/>
    <div class="column">
      <h2 class="is-size-5">Author:</h2>
      <h3 class="is-size-6">{{summaryBook.author}}</h3>
    </div>
    <hr/>
    <div class="column">
      <h2 class="is-size-5">Keywords:</h2>
      <h3 class="is-size-6">{{summaryBook.keywords}}</h3>
    </div>
    <hr/>
    <div class="column">
      <h2 class="is-size-5">Category:</h2>
      <h3 class="is-size-6">{{summaryBook.category.name}}</h3>
    </div>
    <hr/>
    <div class="column">
      <h2 class="is-size-5">Language:</h2>
      <h3 class="is-size-6">{{summaryBook.language.name}}</h3>
    </div>
    <hr/>
     <div class="column">
      <h2 class="is-size-5">Publicatiion year:</h2>
      <h3 class="is-size-6">{{summaryBook.publicationYear}}</h3>
    </div>
    <hr/>
     <div class="column">
      <h2 class="is-size-5">Mime type:</h2>
      <h3 class="is-size-6">{{summaryBook.mimeType}}</h3>
    </div>
  </section>
</template>

<script>
import booksService from "./books.service";

export default {
  name: "Summary",
  data() {
    return {
      summaryBook: {}
    };
  },
  created() {
    this.summaryBook = booksService.getUploadedDocInfo();
  }
};
</script>

<style>
</style>

