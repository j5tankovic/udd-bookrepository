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
                <a class="navbar-item" @click="goToProfile">John john</a>
                <div class="navbar-item">
                    Logout
                </div>
            </div>
        </div>
    </nav>
</template>

<script>
import RouteNames from '../router/routeNames';
export default {
  name: 'Navbar',
  methods: {
      goToProfile ()  {
          this.$router.push({name: RouteNames.ADMIN_PROFILE, params: {id: 1}});
      }
  }
}
</script>

<style scoped>

</style>
