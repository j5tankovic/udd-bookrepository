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
            </ul>
          </div>
          <div class="box has-text-left">
            <basicInfo v-if="option==='profile'"></basicInfo>
          </div>
        </div>
    </div>
  </section>
</template>

<script>
import BasicInfo from '../admin/BasicInfo';
export default {
  name: 'SubscriberProfile',
  data () {
    return {
      option: 'profile',
    }
  },
  components: {
    basicInfo: BasicInfo
  },
}
</script>

<style>
  section {
    padding: 8px 10px !important;
  }
</style>
