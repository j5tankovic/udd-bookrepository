package com.bdzjn.udd.ebookrepository.informationRetrieval.model;

import com.bdzjn.udd.ebookrepository.model.Category;
import com.bdzjn.udd.ebookrepository.model.Language;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "erepository", createIndex = false)
public class IREBook {

    @Id
    @Field(type = FieldType.Keyword, index = false, store = true)
    private String filename;

    private String text;

    private String title;

    private String keywords;

    private String author;

    private String language;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
