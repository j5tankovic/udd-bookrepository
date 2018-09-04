<template>
  <section>
    <div class="columns">
        <div class="column is-narrow">
          <div class="card">
            <div class="card-image">
              <figure class="image is-4by3">
                <img src="https://bulma.io/images/placeholders/1280x960.png" alt="Placeholder image">
              </figure>
            </div>
            <div class="card-content">
              <div class="media">
                <div class="media-content">
                  <p class="title is-4">John Doe</p>
                  <p class="subtitle is-6">@john</p>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="column">
          <div class="tabs is-centered">
            <ul>
              <li class="is-active"><a @click="option='profile'">Profile</a></li>
              <li><a @click="option='users'">Users</a></li>
              <li><a @click="option='books'">Books</a></li>
              <li><a @click="option='categories'">Categories</a></li>
            </ul>
          </div>
          <div class="box has-text-left">
            <basicInfo v-if="option==='profile'"></basicInfo>
            <users v-if="option==='users'"></users>
            <books v-if="option==='books'"></books>
            <categories v-if="option==='categories'"></categories>
          </div>
        </div>
    </div>
  </section>
</template>

<script>
import BasicInfo from './BasicInfo';
import Users from './users/Users';
import Books from './books/Books';
import Categories from './categories/Categories';
export default {
  name: 'AdminProfile',
  data () {
    return {
      option: 'profile',
    }
  },
  components: {
    basicInfo: BasicInfo,
    users: Users,
    books: Books,
    categories: Categories,
  }
}
</script>

<style>
  section {
    padding: 8px 10px !important;
  }
</style>
