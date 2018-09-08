<template>
  <section>
    <button class="button is-rounded add-form" @click="addFieldFilters">
      <i class="fas fa-plus"></i>
    </button>
    <field-filters
      v-for="(fieldFilters, index) of fieldFilters"
      :key="`fieldFilters${index}`"
      :formKey="fieldFilters.formId"
      v-on:fieldFilterChange="setFieldFilter"
      v-on:filterRemove="removeFilter"
    >
    </field-filters>
    <button v-if="fieldFilters.length" class="button is-primary" @click="apply">Apply</button>
  </section>
</template>

<script>
import FieldFilters from './FieldFilters';

export default {
  name: 'NewSearchPanel',
  components: {
    FieldFilters
  },
  data() {
    return {
      fieldFilters: [],
    }
  },
  methods: {
    addFieldFilters() {
      this.fieldFilters.push({
        formId: this.nextFormId,
      });
    },
    setFieldFilter({id, param, value}) {
      const fieldFilter = this.fieldFilters.find(ff => ff.formId === id);
      fieldFilter[param] = value;
    },
    apply() {
      this.$emit('applyFilters', this.fieldFilters)
    },
    removeFilter(filterId) {
      const idx = this.fieldFilters.findIndex(ff => ff.formId === filterId);
      this.fieldFilters.splice(idx, 1);
    }
  },
  computed: {
    nextFormId() {
      return this.fieldFilters.length;
    }
  }
}
</script>

<style>
  .add-form {
    max-height: 25px;
  }
</style>


