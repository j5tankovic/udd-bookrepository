<template>
  <section>
    <h4 class="title is-6">Please select one file fom your device</h4>
    <p v-if="isForEdit" class="is-size-7 has-text-primary">*Click upload if you want to change file</p>
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
import booksService from './books.service';

export default {
  name: "UploadBookForm",
  props: ['filename'],
  data() {
    return {
      files: [],
      //yep, pretty dummy
      isForEdit: false,
    }
  },
  created() {
    eventHub.$on('bookSelected', () => {
      this.isForEdit = true;
    });
  },
  computed: {
    chosenFileName() {
      return this.isForEdit && booksService.getFileName() ? booksService.getFileName() : this.files.length ? this.files[0].name : "";
    },
  },
  watch: {
    files(val) {
      bookService.setFilesToUpload(val);
    }
  },
  // methods: {
  //   handleBookSelection() {
  //     this.$forceUpdate();
  //   }
  // }
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

