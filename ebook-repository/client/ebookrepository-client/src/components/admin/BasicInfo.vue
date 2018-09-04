<template>
  <section>
  <p class="title is-4">Basic info</p>
  <div class="is-divider"></div>
  <div class="columns">
      <div class="column is-1 is-narrow">
      <p class="has-text-weight-semibold">Name:</p>
      </div>
      <div class="column">
      <p class="has-text-weight-normal">John</p>
      </div>
  </div>
  <div class="columns">
      <div class="column is-1 is-narrow">
      <p class="has-text-weight-semibold">Surname:</p>
      </div>
      <div class="column">
      <p class="has-text-weight-normal">Doe</p>
      </div>
  </div>
  <div class="columns">
      <div class="column is-1 is-narrow">
      <p class="has-text-weight-semibold">Username:</p>
      </div>
      <div class="column">
      <p class="has-text-weight-normal">johndoe</p>
      </div>
  </div>
  <p class="title is-4">Change password</p>
  <div class="is-divider"></div>
  <div>
      <div class="field is-horizontal">
      <div class="field-label has-text-left is-narrow">
      <label class="label">Current password</label>
      </div>
      <div class="field-body">
          <div class="field is-narrow">
          <div class="control">
              <input class="input" type="password" v-model="passwordChangeModel.oldPassword" password-reveal/>
          </div>
          </div>
      </div>
      </div>
      <div class="field is-horizontal">
      <div class="field-label has-text-left is-narrow">
      <label class="label">New password</label>
      </div>
      <div class="field-body">
          <div class="field is-narrow">
          <div class="control">
              <input class="input" type="password" v-model="passwordChangeModel.newPassword" password-reveal/>
          </div>
          </div>
      </div>
      </div>
      <div class="field is-horizontal">
      <div class="field-label has-text-left is-narrow">
      <label class="label">Repeat password</label>
      </div>
      <div class="field-body">
          <div class="field is-narrow">
          <div class="control">
              <input class="input" type="password"  v-model="passwordChangeModel.repeatPassword" password-reveal/>
          </div>
          </div>
      </div>
      </div>
      <div class="field is-horizontal">
      <div class="field-label">
      </div>
      <div class="field-body">
          <div class="field is-narrow">
          <div class="control is-pulled-right">
              <button class="button is-primary" @click="changePassword">
              Change
              </button>
          </div>
          </div>
      </div>
      </div>
  </div>
  </section>
</template>

<script>
import { post } from "../../fetch";

export default {
  name: "BasicInfo",
  data() {
    return {
      userId: this.$route.params.id,
      passwordChangeModel: {}
    };
  },
  methods: {
    changePassword() {
      const isChangeOk = this.verifyPassword();

      if (isChangeOk) {
        post(`users/${this.userId}/change-password`, {
          newPassword: this.passwordChangeModel.newPassword
        }).then(response => console.log(respone.data))
      }
		},
		
		verifyPassword() {
			return this.passwordChangeModel.newPassword === this.passwordChangeModel.repeatPassword;
		}
  }
};
</script>

<style>
</style>


