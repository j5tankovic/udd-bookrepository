<template>
  <section>
    <div class="columns">
      <div class="column is-4 is-offset-4">
        <b-field horizontal label="Username">
            <b-input 
              name="username" 
              placeholder="Username"
              v-model="loginData.username"
              expanded 
            ></b-input>
        </b-field>

        <b-field horizontal label="Password">
            <b-input
              type="password"
              name="password"
              v-model="loginData.password"
              placeholder="Password" 
              expanded
              password-reveal>
            </b-input>
        </b-field>

        <b-field horizontal>
          <p class="control is-pulled-right">
            <button class="button is-primary" @click="login">Login</button>
          </p>
        </b-field>
      </div>
    </div>
  </section>
</template>


<script>
import RouteNames from '../router/routeNames'
import { post } from '../fetch'

export default {
  name: 'Login',
  data () {
    return {
      loginData: {},
    }
  },
  methods: {
    login () {
      post('users/login', this.loginData)
      .then(response => {
        localStorage.userId = response.data.id;
        localStorage.userType = response.data.type;
        this.$router.push({ name: RouteNames.HOME })
      })
    }
  }
}
</script>

<style>

</style>

