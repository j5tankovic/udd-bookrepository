import Vue from 'vue';
import UploadBookForm from './UploadBookForm';
import BookForm from './BookForm';
import Summary from './Summary';
import { postFile, post, put, del } from '../../../fetch';
import booksService from './books.service';
import { Toast } from 'buefy';

Vue.component('upload-book-form', UploadBookForm);
Vue.component('book-form', BookForm);
Vue.component('book-summary', Summary);

export default {
  total: 3,
  steps: [
    {
      label: 'Upload',
      component: Vue.component('upload-book-form'),
      props: [{ filename: booksService.getFileName() }],
      onSubmit: () => {
        const file = booksService.getFileToUpload();
        if (file) {
          return postFile('books/upload', file).then(response => {
            booksService.setUploadedDocInfo(response.data)
            return Promise.resolve();
          });
        } else {
          booksService.setUploadedDocInfo(booksService.getBook());
          return Promise.resolve();
        }
      },
    },
    {
      label: 'Overview/edit data',
      component: Vue.component('book-form'),
      onSubmit: () => {
        return Promise.resolve();
      },
      onBack: () => {
        console.log("part 1");
      },
    }, {
      label: 'Summary',
      component: Vue.component('book-summary'),
      onSubmit: () => {
        let book = booksService.getBook();
        book.cataloguerId = localStorage.getItem("userId");
        console.log(book);
        if (!book.id) {
          return post('books', booksService.getBook()).then(response => {
            Toast.open({
              message: 'Book successfully added',
              type: 'is-success',
              duration: 5000,
            });
            return Promise.resolve();
          })
        } else {
          return put('books', booksService.getBook()).then(response => {
            Toast.open({
              message: 'Book successfully updated',
              type: 'is-sucess',
              duration: 5000,
            })
          });
        }
      },
      onCancel: () => {
        let book = booksService.getBook();
        //book.filename = "nekiFajl";
        del(`books/${book.filename}`).then(() => {
          return Promise.resolve();
        });
      }
    }
  ]
}