package com.bdzjn.udd.ebookrepository;

import com.bdzjn.udd.ebookrepository.service.EBookService;
import com.bdzjn.udd.ebookrepository.storage.StorageProperties;
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

    private void createIndex() {
        String indexSettings = "{\n" +
                "        \"analysis\" : {\n" +
                "            \"analyzer\" : {\n" +
                "                \"serbian-analyzer\" : {\n" +
                "                   \"type\": \"custom\", \n" +
                "                    \"tokenizer\" : \"standard\",\n" +
                "                    \"filter\" : [\"sr_cyrillic_to_latin\", \"sr_lowercase\", \"sr_stopwords\", \"sr_stemmer\"]\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "     }\n";

        elasticsearchTemplate.createIndex("erepository", indexSettings);

        String mappingSettings = "{\n" +
                "         \"properties\":{\n" +
                "            \"fileName\": {\n" +
                "               \"type\":\"text\"\n" +
                "            },\n" +
                "            \"text\": {\n" +
                "            \t\"type\": \"text\",\n" +
                "            \t\"analyzer\": \"serbian-analyzer\"\n" +
                "            },\n" +
                "            \"keywords\": {\n" +
                "            \t\"type\": \"text\",\n" +
                "            \t\"analyzer\": \"serbian-analyzer\"\n" +
                "            }\n" +
                "\n" +
                "         }\n" +
                "      }";
        elasticsearchTemplate.putMapping("erepository", "irebook", mappingSettings);
    }

}
