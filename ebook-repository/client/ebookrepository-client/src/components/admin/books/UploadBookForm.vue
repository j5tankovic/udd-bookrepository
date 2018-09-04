<template>
  <section>
    <h4 class="title is-6">Please select one file fom your device</h4>
    <b-field label="File name" horizontal>
      <span class="file-name">{{chosenFileName}}</span>
    </b-field>
    <b-upload v-model="files">
      <a class="button is-primary">
        <b-icon icon="upload"></b-icon>
        <span>Click to upload</span>
      </a>
    </b-upload>
  </section>
</template>

<script>
import bookService from './books.service';

export default {
  name: "UploadBookForm",
  data() {
    return {
      files: [],
    }
  },
  computed: {
    chosenFileName() {
      return this.files.length ? this.files[0].name : "";
    }
  },
  watch: {
    files(val) {
      bookService.setFilesToUpload(val);
    }
  }
};
</script>

<style>
  label {
    text-align: left;
  }

  .file-name {
    margin-left: -10%;
    border-left: 1px solid #dbdbdb;
  }
</style>

