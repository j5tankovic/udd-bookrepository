<template>
  <div class="container">
    <div class="search-container">
      <b-field>
        <b-input v-model="searchParams.searchValue" placeholder="Search" expanded></b-input>
        <p class="control">
          <button class="button is-success" @click="search">Search</button>
        </p>
      </b-field>
      <div class="has-text-left">
        <b-collapse :open="false">
          <a class="is-primary" slot="trigger">Advanced search</a>
          <div class="notification">
              <div class="content">
                <search-panel v-on:applyFilters="applyFilters"></search-panel>
              </div>
          </div>
        </b-collapse>
      </div>
      <div class="search-by-category-container has-text-left">
        <b-field label="Browse by category" horizontal>
          <b-select placeholder="Select a category" v-model="selectedCategory" expanded>
            <option 
              v-for="category of categories"
              :key="`category-search-${category.id}`"
              :value="category.id">
              {{category.name}}
            </option>
        </b-select>
        </b-field>
      </div>
    </div>
    <div class="tile is-vertical is-ancestor">
      <div 
        v-for="(searchHit, index) of searchHits"
        :key="`searchHit${index}`"
        class="tile notification is-block has-text-left">
        <div class="is-size-5 search-title">
          {{searchHit.title}}
          <a class="is-size-7 download-link">Download</a>
        </div>
        <div v-if="searchHit.text">
          <p class="is-size-7 has-text-left text-container" v-html="getShortText(searchHit.text)"></p>
        </div>
      </div>
      <b-loading :is-full-page="false" :active.sync="isFetchInProgress"></b-loading>
    </div>
  </div>
</template>

<script>
import { post, get } from "../fetch";
import SearchPanel from "./SearchPanel";

export default {
  name: "Home",
  components: {
    SearchPanel
  },
  data() {
    return {
      radioButton: "",
      searchParams: {
        searchValue: "",
        fields: [],
        query: "",
        operator: ""
      },
      searchHits: [],
      isFetchInProgress: false,
      categories: [],
      selectedCategory: ""
    };
  },
  created() {
    get("categories").then(({ data }) => {
      this.categories = data;
    });
  },
  methods: {
    search() {
      this.isFetchInProgress = true;
      post("books/search", { ...this.searchParams })
        .then(({ data }) => {
          this.isFetchInProgress = false;
          this.searchHits = data;
        })
        .catch(() => (this.isFetchInProgress = false));
    },
    saveSearchParam({ param, value }) {
      this.searchParams[param] = value;
      if (param === "fields") this.redefineSearchValue(value[value.length - 1]);
    },
    getShortText(fullText) {
      return `${fullText.substring(0, 200)}...`;
    },
    redefineSearchValue(fieldParam) {
      this.searchParams.searchValue = `${fieldParam}:${
        this.searchParams.searchValue
      }`;
    },
    applyFilters(filters) {
      this.formQuery(filters);
    },
    formQuery(filters) {
      const queryParts = filters.map((filter, index) => {
        return `${operatorMappings[filter.operator]} ${
          filter.field
        }:${queryTypeMappings[filter.queryType](filter.searchValue)}`;
      });

      this.searchParams.searchValue = queryParts.join(" ");
    }
  },
  watch: {
    selectedCategory(val) {
      this.isFetchInProgress = true;
      get(`categories/${val}/books`).then(({data}) => {
        this.isFetchInProgress = false;
        this.searchHits = data;
      }).catch(() => this.isFetchInProgress = false);
    }
  }
};

const operatorMappings = {
  and: "AND",
  or: "OR",
  none: "",
  not: "NOT"
};

const queryTypeMappings = {
  standard: placeholder => `${placeholder}`,
  fuzzy: placeholder => `${placeholder}~`,
  phrase: placeholder => `"${placeholder}"`
};
</script>

<style>
.search-container {
  margin-bottom: 5%;
}

.tile {
  margin-left: 10px;
  margin-right: 10px;
  display: block;
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

.text-container {
  max-width: 60%;
}

.download-link {
  color: #7957d5 !important;
}

.is-block {
  display: block;
}
</style>
