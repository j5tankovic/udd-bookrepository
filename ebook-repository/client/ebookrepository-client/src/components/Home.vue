<template>
  <div class="container">
    <div class="search-container">
      <b-field>
        <b-input v-model="search" placeholder="Search" expanded></b-input>
        <p class="control">
          <button class="button is-success">Search</button>
        </p>
      </b-field>
      <div class="search-by-category-container has-text-left">
        <b-field label="Browse by category" horizontal>
          <b-select placeholder="Select a category" expanded>
            <option value="SUBSCRIBER">Subscriber</option>
            <option value="ADMIN">Admin</option>
        </b-select>
        </b-field>
      </div>
    </div>
    <div class="tile is-vertical is-ancestor">
      <div class="tile notification has-border">
        <span>Book1</span>
      </div>
      <div class="tile notification">
        <span>Book2</span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      search: ""
    };
  }
};
</script>

<style>
.search-container {
  margin-bottom: 5%;
}

.tile {
  margin-left: 10px;
  margin-right: 10px;
}

label {
  text-align: left;
}

.has-border {
  border: 1px solid hsl(0, 0%, 86%);
}

.search-by-category-container {
  margin-top: 2%;
}
</style>
