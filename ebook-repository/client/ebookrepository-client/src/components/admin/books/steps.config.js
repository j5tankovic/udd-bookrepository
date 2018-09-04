import Vue from 'vue';
import UploadBookForm from './UploadBookForm';
import BookForm from './BookForm';
import { postFile, post } from '../../../fetch';
import booksService from './books.service';
import { Toast } from 'buefy';

Vue.component('upload-book-form', UploadBookForm);
Vue.component('book-form', BookForm);

export default {
  total: 2,
  steps: [
    {
      label: 'Upload',
      component: Vue.component('upload-book-form'),
      onSubmit: () => {
        const file = booksService.getFileToUpload();
        return postFile('books/upload', file).then(response => {
          booksService.setUploadedDocInfo(response.data)
          return Promise.resolve();
        });
      },
    },
    {
      label: 'Overview/edit data',
      component: Vue.component('book-form'),
      onSubmit: () => {
        let book = booksService.getBook();
        book.cataloguerId = localStorage.getItem("userId");
        return post('books', booksService.getBook()).then(response => {
          Toast.open({
            message: 'Book successfully added',
            type: 'is-success',
            duration: 5000,
          });
          return Promise.resolve();
        })
      },
      onBack: () => {
        console.log("part 1");
      },
    }
  ]
}