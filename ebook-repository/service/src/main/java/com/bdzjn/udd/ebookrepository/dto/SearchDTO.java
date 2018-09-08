package com.bdzjn.udd.ebookrepository.dto;

import java.util.List;

public class SearchDTO {

    private String searchValue;

    private List<String> fields;

    private String query;

    private String operator;

    public SearchDTO() {
    }

    public SearchDTO(String searchValue, List<String> fields, String query, String operator) {
        this.searchValue = searchValue;
        this.fields = fields;
        this.query = query;
        this.operator = operator;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public SearchDTO setSearchValue(String searchValue) {
        this.searchValue = searchValue;
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public SearchDTO setFields(List<String> fields) {
        this.fields = fields;
        return this;
    }

    public String getQuery() {
        return query;
    }

    public SearchDTO setQuery(String query) {
        this.query = query;
        return this;
    }

    public String getOperator() {
        return operator;
    }

    public SearchDTO setOperator(String operator) {
        this.operator = operator;
        return this;
    }
}
