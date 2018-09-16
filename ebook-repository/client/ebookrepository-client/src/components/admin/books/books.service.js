const BooksService = () => {
  let filesToUpload = [];
  let uploadedDocInfo = {};
  let book = {};

  const api = {
    getFielsToUpload() {
      return filesToUpload;
    },
    setFilesToUpload(files) {
      filesToUpload = files;
    },
    getFileToUpload() {
      return filesToUpload[0];
    },
    getUploadedDocInfo() {
      return uploadedDocInfo;
    },
    setUploadedDocInfo(info) {
      uploadedDocInfo = info;
    },
    getBook(){
      return book;
    },
    setBook(b){
      book = b;
    },
    getFileName() {
      return Object.keys(book).length ? book.filename : "";
    }

  }

  return api;
}

export default BooksService();