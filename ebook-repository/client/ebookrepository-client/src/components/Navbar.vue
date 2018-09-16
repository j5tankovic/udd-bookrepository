<template>
    <nav class="navbar is-primary is-fixed-top" role="navigation" aria-label="main navigation">
        <div class="navbar-brand">
            <router-link class="navbar-item" to="/">
                <img src="https://www.freeiconspng.com/uploads/book-bookmark-icon-5.png"/>
                <span class="is-4 has-text-weight-semibold"> EBook Repository </span>
            </router-link>
        </div>
        <div class="navbar-menu">
            <div class="navbar-end">
                <a class="navbar-item" @click="goToProfile">{{username}}</a>
                <a v-if="isLogged" class="navbar-item" @click="logout">Logout</a>
                <a v-if="!isLogged && $router.history.current.name !== 'login'" class="navbar-item" @click="login">Login</a>
            </div>
        </div>
    </nav>
</template>

<script>
import RouteNames from "../router/routeNames";
export default {
  name: "Navbar",
  data() {
    return {
        username: '',
        isLogged: false,
    }
  },
  created() {
    this.username = localStorage.getItem("userInfo");
    this.isLogged = !!localStorage.getItem("userInfo");
    eventHub.$on('localStorageChanged', this.handleLocalStorageChange);
  },
  methods: {
    goToProfile() {
      let userType = localStorage.getItem("userType");
      let route = userType === "ADMIN" ? RouteNames.ADMIN_PROFILE : RouteNames.SUBSCRIBER_PROFILE;

      let userId = +localStorage.getItem("userId");

      this.$router.push({ name: route, params: { id: userId } });
    },
    logout() {
      localStorage.removeItem("userId");
      localStorage.removeItem("userType");
      localStorage.removeItem("userInfo");
      localStorage.removeItem("subscribedCategory");

      eventHub.$emit('localStorageChanged');
      this.$router.push({ name: RouteNames.LOGIN });
    },
    login() {
      this.$router.push({ name: RouteNames.LOGIN });
    },
    handleLocalStorageChange() {
      let username = localStorage.getItem("userInfo");
      this.username = username ? username : "";
      this.isLogged = !!username;
    }
  },
};
</script>

<style scoped>
</style>
