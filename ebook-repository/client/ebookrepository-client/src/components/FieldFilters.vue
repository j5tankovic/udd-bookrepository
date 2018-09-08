<template>
  <b-field grouped>
        <b-field label="Field">
            <b-select v-model="field">
                <option
                  v-for="(field, index) of fields"
                  :key="`field${index}`"
                  :value="field"
                >{{field}}</option>
            </b-select>
        </b-field>
        <b-field label="Query type">
            <b-select v-model="queryType">
                <option
                  v-for="(queryType, index) of queryTypes"
                  :key="`queryType${index}`"
                  :value="queryType"
                >{{queryType}}</option>
            </b-select>
        </b-field>
        <b-field label="Operator">
            <b-select v-model="operator">
                <option
                  v-for="(operator, index) of operators"
                  :key="`operator${index}`"
                  :value="operator"
                >{{operator}}</option>
            </b-select>
        </b-field>
        <b-field label="Search value" expanded>
            <b-input v-model="searchValue"></b-input>
        </b-field>
        <b-field>
          <button class="button is-rounded is-danger field-close-button" @click="removeFieldFilter">
            <i class="fas fa-times"></i>
          </button>
        </b-field>
    </b-field>
</template>

<script>

export default {
  name: "FieldFilters",
  props: ["formKey"],
  data() {
    return {
      field: "",
      queryType: "",
      operator: "",
      searchValue: "",
      fields: ["title", "author", "keywords", "text", "language"],
      queryTypes: ["standard", "phrase", "fuzzy"],
      operators: ["and", "or", "not", "none"]
    };
  },
  watch: {
    field(val) {
      this.$emit('fieldFilterChange', { id: this.formKey, param: 'field', value: val})
    },
    queryType(val) {
      this.$emit('fieldFilterChange', { id: this.formKey, param: 'queryType', value: val})
    },
    operator(val) {
      this.$emit('fieldFilterChange', { id: this.formKey, param: 'operator', value: val})
    },
    searchValue(val) {
      this.$emit('fieldFilterChange', { id: this.formKey, param: 'searchValue', value: val})
    }
  },
  methods: {
    removeFieldFilter() {
      this.$emit('filterRemove', this.formKey);
    }
  }
};
</script>

<style>
.field-close-button {
  max-height: 25px;
  margin-top: 35px;
}
</style>
