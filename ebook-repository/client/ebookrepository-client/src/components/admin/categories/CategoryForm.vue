<template>
  <section>
    <h2 class="title is-4">Create/edit category</h2>
    <b-field label="Name">
      <b-input v-model="category.name"></b-input>
    </b-field>
    <b-field grouped>
      <p class="control">
        <button class="button is-primary" @click="save">Ok</button>
        <button class="button is-warning" @click="cancel">Cancel</button>
      </p>
    </b-field>
  </section>
</template>

<script>

const mode = {
  CREATE: "CREATE",
  EDIT: "EDIT"
};

export default {
  name: "CategoryForm",
  props: ['categoryForForm'],
  methods: {
    save () {
      this.$emit('saveCategory', { category: this.category, mode: this.mode });
      //this.reset();
    },
    cancel() {
      this.$emit('cancel');
    },
    // reset () {
    //   this.category = {};
    // }
  },
  computed: {
    category() {
      return {...this.categoryForForm};
    },
    mode() {
      return Object.keys(this.category).length !== 0 ? mode.EDIT : mode.CREATE;
    }
  }
}
</script>

<style>

</style>
