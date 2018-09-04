const BooksService = () => {
  const filesToUpload = [];
  const uploadedDocInfo = {};
  const book = {};

  const api = {
    getFielsToUpload() {
      return this.filesToUpload;
    },
    setFilesToUpload(files) {
      this.filesToUpload = files;
    },
    getFileToUpload() {
      return this.filesToUpload[0];
    },
    getUploadedDocInfo() {
      return this.uploadedDocInfo;
    },
    setUploadedDocInfo(info) {
      this.uploadedDocInfo = info;
    },
    getBook(){
      return this.book;
    },
    setBook(book){
      this.book = book;
    }
  }

  return api;
}

export default BooksService();