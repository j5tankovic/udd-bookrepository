<template>
  <div>
    <b-table 
      :data="users" 
      :columns="config.columns"
      :paginated="config.isPaginated"
      :currentPage.sync="config.currentPage"
      :per-page="config.perPage"
    ></b-table>
    <user-form v-on:saveUser="save"></user-form>
  </div>
</template>

<script>
import UserForm from "./UserForm";
import { post, get } from "../../../fetch";
import config from './grid.config';

export default {
  name: "Users",
  data() {
    return {
      users: [],
      config,
    }
      
  },
  components: {
    UserForm
  },
  created() {
    get('users').then(({data}) => this.users = data);
  },
  methods: {
    save(user) {
      post("users", user).then(({ data }) => {
        this.users.push(data);
      });
    }
  }
};
</script>

<style>
</style>
