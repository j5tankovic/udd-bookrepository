export default {
  columns: [
    {
      field: 'id',
      label: 'ID',
      width: '40',
      numeric: true
    },
    {
      field: 'title',
      label: 'Title',
    },
    {
      field: 'author',
      label: 'Author',
    },
    {
      field: 'keywords',
      label: 'Keywords',
    },
    {
      field: 'publicationYear',
      label: 'Publication Year',
    },
    {
      field: 'category',
      label: 'Category',
    },
    {
      field: 'cataloguer',
      label: 'Cataloguer',
    },
  ], 
  isPaginated: true,
  currentPage: 1,
  perPage: 10,
}