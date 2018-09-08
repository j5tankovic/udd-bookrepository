<template>
  <section>
    <div class="container">
      <a 
      v-for="(item, index) of items" 
      :key="index"
      :class="isActive(index)"
      @click="selectButton(index)"
      class="button is-rounded">{{item}}</a>
    </div>
  </section>
</template>

<script>
import Vue from 'vue';

export default {
  name: "SelectButtons",
  props: ["isSingleSelect", "items", "itemsProvider"],
  data() {
    return {
      selectedIndices: [],
    }
  },
  methods: {
    selectButton(index) {
      if (this.isSingleSelect) {
        const value = this.selectedIndices[0] !== index ? index: -1;
        Vue.set(this.selectedIndices, 0, value);
        value === -1 ? this.$emit('unselect', index) : this.$emit('select', index);
        
      } else {
        const arrIdx = this.selectedIndices.findIndex(idx => idx === index);
        if (arrIdx !== -1) {
          this.selectedIndices.splice(arrIdx, 1);
          this.$emit('unselect', index);
        }
        else {
          this.selectedIndices.push(index);
          this.$emit('select', index);
        }
      }
    },
    isActive(index) {
      let result = {
        active: false
      }
      if (this.selectedIndices.includes(index)) {
        result.active = true;
      }

      return result;
    }
  },
  computed: {
    seletedItem() {
      return this.selectedIndices !== -1 ? this.items[this.selectedIndex] : "";
    },
  }
}
</script>

<style>
  .active {
    background-color: hsl(262, 28%, 92%);
  }

  .container {
    padding: 5px;
  }

  .container a {
    margin-left: 3px;
    min-width: 50px;
    height: 25px;
    max-height: 25px;
    font-size: 0.85rem;
  }

</style>


