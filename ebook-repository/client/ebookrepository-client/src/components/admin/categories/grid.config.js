export default {
  columns: [
    {
      field: 'id',
      label: 'ID',
      width: '40',
      numeric: true
    },
    {
      field: 'name',
      label: 'Name',
    },
    {
      field: 'editAction',
      label: 'Edit'
    }
  ], 
  isPaginated: true,
  currentPage: 1,
  perPage: 10,
}