<template>
  <div>
    <b-table 
      :data="users" 
      :paginated="config.isPaginated"
      :currentPage.sync="config.currentPage"
      :per-page="config.perPage"
    >
      <template slot-scope="props">
        <b-table-column :field="config.columns[0].field" :label="config.columns[0].label" width="40" numeric>
            {{ props.row.id }}
        </b-table-column>

        <b-table-column :field="config.columns[1].field" :label="config.columns[1].label">
            {{ props.row.firstname }}
        </b-table-column>

        <b-table-column :field="config.columns[2].field" :label="config.columns[2].label">
            {{ props.row.lastname }}
        </b-table-column>

        <b-table-column :field="config.columns[3].field" :label="config.columns[3].label">
            {{ props.row.type }}
        </b-table-column>

        <b-table-column :field="config.columns[4].field" :label="config.columns[4].label">
            {{ props.row.username }}
        </b-table-column>

        <b-table-column :field="config.columns[5].field" :label="config.columns[5].label">
          <span>
            <a @click="setUserToEdit(props.row.id)">
              <b-icon
               package="fas"
               icon="user-edit">
              </b-icon>
            </a>
          </span>
        </b-table-column>
      </template>
    </b-table>
    <user-form 
      v-on:saveUser="save"
      v-on:cancel="cancel"
      :userForForm="userForForm"
      ></user-form>
  </div>
</template>

<script>
import UserForm from "./UserForm";
import { post, get, put } from "../../../fetch";
import config from "./grid.config";

const mode = {
  CREATE: "CREATE",
  EDIT: "EDIT"
};

export default {
  name: "Users",
  data() {
    return {
      users: [],
      config,
      selectedUserId: -1
    };
  },
  components: {
    UserForm
  },
  created() {
    get("users").then(({ data }) => (this.users = data));
  },
  methods: {
    save({ user, formMode }) {
      if (formMode === mode.CREATE) {
        post("users", user).then(({ data }) => {
          this.selectedUserId = -1;
          this.users.push(data);
        });
      } else {
        put("users", user).then(({data}) => {
          this.selectedUserId = -1;
          get("users").then(({ data }) => (this.users = data));
        });
      }
    },
    setUserToEdit(id) {
      this.selectedUserId = this.users.find(u => u.id === id) ? id : -1;
    },
    cancel() {
      this.selectedUserId = -1;
    }
  },
  computed: {
    userForForm() {
      if (this.selectedUserId !== -1) {
        return this.users.find(u => u.id === this.selectedUserId);
      }
      return {};
    }
  }
};
</script>

<style>
</style>
