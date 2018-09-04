export default {
  columns: [
    {
      field: 'id',
      label: 'ID',
      width: '40',
      numeric: true
    },
    {
      field: 'firstname',
      label: 'FirstName',
    },
    {
      field: 'lastname',
      label: 'Last name',
    },
    {
      field: 'type',
      label: 'Type',
    },
    {
      field: 'username',
      label: 'Username',
    },
  ], 
  isPaginated: true,
  currentPage: 1,
  perPage: 10,
}