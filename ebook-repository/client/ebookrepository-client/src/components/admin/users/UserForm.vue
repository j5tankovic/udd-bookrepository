<template>
  <section>
    <h2 class="title is-4">Create/edit user</h2>
    <b-field label="Name">
      <b-input v-model="user.firstname"></b-input>
    </b-field>
    <b-field label="Surname">
      <b-input v-model="user.lastname"></b-input>
    </b-field>
    <b-field label="Username">
      <b-input v-model="user.username"></b-input>
    </b-field>
    <b-field label="Password">
      <b-input type="password" v-model="user.password"></b-input>
    </b-field>
     <b-field
        label="Type">
        <b-select placeholder="Select a type" expanded v-model="user.type">
            <option value="SUBSCRIBER">Subscriber</option>
            <option value="ADMIN">Admin</option>
        </b-select>
      </b-field>
      <b-field grouped>
        <p class="control">
          <button class="button is-primary" @click="save">OK</button>
          <button class="button is-warning" @click="reset">Cancel</button>
        </p>
      </b-field>
  </section>
</template>

<script>

const mode = {
  CREATE: "CREATE",
  EDIT: "EDIT"
}

export default {
  name: "UserForm",
  props: ["userForForm"],
  data () {
    return {
     // user: {...this.userForForm},
    }
  },
  methods: {
    save() {
      this.$emit('saveUser', { user: this.user, mode: this.mode});
      this.reset();
    },

    reset() {
      this.$emit('cancel');
      this.user = {}
    }
  },
  computed: {
    mode() {
      return Object.keys(this.user).length !== 0 ? mode.EDIT : mode.CREATE;
    },
    user: {
      get() {
        return {...this.userForForm};
      },
      set(newValue){
      }
    }
  }
}
</script>

<style>

</style>
