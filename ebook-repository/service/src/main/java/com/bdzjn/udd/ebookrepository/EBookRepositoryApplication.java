package com.bdzjn.udd.ebookrepository;

import com.bdzjn.udd.ebookrepository.service.EBookService;
import com.bdzjn.udd.ebookrepository.storage.StorageProperties;
import com.google.gson.Gson;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.IndexSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class EBookRepositoryApplication {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public static void main(String[] args) {
        SpringApplication.run(EBookRepositoryApplication.class, args);
    }

    @Bean
    CommandLineRunner init(EBookService eBookService) {
        return (args) -> {
            eBookService.init();
            if (!elasticsearchTemplate.indexExists("erepository"))
                createIndex();
        };
    }

    private void createIndex() throws IOException {
        String indexSettings = new String (Files.readAllBytes(Paths.get("src/main/resources/indexsettings.json")));
        elasticsearchTemplate.createIndex("erepository", indexSettings);

        String mappingSettings = new String (Files.readAllBytes(Paths.get("src/main/resources/mapping.json")));
        elasticsearchTemplate.putMapping("erepository", "irebook", mappingSettings);
    }

}
