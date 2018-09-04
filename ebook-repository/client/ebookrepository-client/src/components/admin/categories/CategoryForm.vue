<template>
  <section>
    <h2 class="title is-4">Create/edit category</h2>
    <b-field label="Name">
      <b-input v-model="category.name"></b-input>
    </b-field>
    <b-field grouped>
      <p class="control">
        <button class="button is-primary" @click="save">Ok</button>
        <button class="button is-warning" @click="reset">Cancel</button>
      </p>
    </b-field>
  </section>
</template>

<script>
export default {
  name: "CategoryForm",
  data () {
    return {
      category: {},
    }
  },
  methods: {
    save () {
      this.$emit('saveCategory', this.category)
      this.reset()
    },

    reset () {
      this.category = {};
    }
  }
}
</script>

<style>

</style>
