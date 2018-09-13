package com.bdzjn.udd.ebookrepository.service;

import com.bdzjn.udd.ebookrepository.dto.EBookDTO;
import com.bdzjn.udd.ebookrepository.dto.SearchDTO;
import com.bdzjn.udd.ebookrepository.dto.SearchHitDTO;
import com.bdzjn.udd.ebookrepository.informationRetrieval.indexing.handler.PdfDocumentHandler;
import com.bdzjn.udd.ebookrepository.informationRetrieval.model.IREBook;
import com.bdzjn.udd.ebookrepository.informationRetrieval.repository.IREBookRepository;
import com.bdzjn.udd.ebookrepository.model.EBook;
import com.bdzjn.udd.ebookrepository.repository.EBookRepository;
import com.bdzjn.udd.ebookrepository.storage.StorageProperties;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EBookService {

    private IREBookRepository irEbookRepository;

    private EBookRepository eBookRepository;

    private PdfDocumentHandler pdfDocumentHandler;

    private Path dirLocation;

    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    public EBookService(StorageProperties properties,
                        IREBookRepository irEbookRepository,
                        EBookRepository eBookRepository,
                        PdfDocumentHandler pdfDocumentHandler,
                        ElasticsearchTemplate elasticsearchTemplate) {
        this.dirLocation = Paths.get(properties.getLocation());
        this.irEbookRepository = irEbookRepository;
        this.eBookRepository = eBookRepository;
        this.pdfDocumentHandler = pdfDocumentHandler;
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    public void save(EBook ebook) {
        IREBook ireBook = pdfDocumentHandler
                .getIREBook(ebook, dirLocation.resolve(ebook.getFilename()));
        irEbookRepository.save(ireBook);
        eBookRepository.save(ebook);
    }

    public File storeFile(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            Files.copy(inputStream, this.dirLocation.resolve(filename),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.dirLocation.resolve(filename).toFile();
    }

    public void init() {
        try {
            Files.createDirectories(dirLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public EBook getMetadata(File file) {
        EBook ebook = null;
        try {
            ebook = new EBook();
            PDDocument document = PDDocument.load(file);
            PDDocumentInformation info = document.getDocumentInformation();
            ebook.setAuthor(info.getAuthor());
            ebook.setKeywords(info.getKeywords());
            ebook.setTitle(info.getTitle());
            ebook.setFilename(file.getName());
            ebook.setPublicationYear(info.getCreationDate().get(Calendar.YEAR));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ebook;
    }

    public List<EBook> findAll() {
        return eBookRepository.findAll();
    }

    public List<SearchHitDTO> search(SearchDTO searchDTO) {
        List<SearchHitDTO> result = new ArrayList<>();
        SearchResponse response = elasticsearchTemplate.getClient().prepareSearch("erepository")
                .setTypes("irebook")
                .setQuery(formQuery(searchDTO))
                .highlighter(new HighlightBuilder()
                        .field("text")
                        .numOfFragments(1)
                        .fragmentSize(200)
                        .preTags("<b><em>")
                        .postTags("</em></b>")
                )
                .get();

        Iterator<SearchHit> iterator = response.getHits().iterator();
        Gson gson = new GsonBuilder().create();
        while (iterator.hasNext()) {
            SearchHit searchHit = iterator.next();
            String searchSource = searchHit.getSourceAsString();
            if (searchSource != null) {
                SearchHitDTO searchHitDTO = gson.fromJson(searchSource, SearchHitDTO.class);
                searchHit.getHighlightFields().values().forEach(field -> {
                    searchHitDTO.setText(extractHighlightedText(field));
                });
                result.add(searchHitDTO);
            }
        }

        return result;
    }

    private QueryStringQueryBuilder formQuery(SearchDTO searchDTO) {
        return QueryBuilders.queryStringQuery(searchDTO.getSearchValue().trim());
    }

    private String extractHighlightedText(HighlightField highlightField) {
        return Arrays.stream(highlightField.getFragments())
                .map(t -> t.string() + "...")
                .collect(Collectors.joining());
    }

    public Optional<Resource> loadBookAsResource(String fileName) {
        try {
            Path filePath = this.dirLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return Optional.of(resource);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
