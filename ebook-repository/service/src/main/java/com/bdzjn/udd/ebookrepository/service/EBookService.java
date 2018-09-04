package com.bdzjn.udd.ebookrepository.service;

import com.bdzjn.udd.ebookrepository.informationRetrieval.indexing.handler.PdfDocumentHandler;
import com.bdzjn.udd.ebookrepository.informationRetrieval.model.IREBook;
import com.bdzjn.udd.ebookrepository.informationRetrieval.repository.IREBookRepository;
import com.bdzjn.udd.ebookrepository.model.EBook;
import com.bdzjn.udd.ebookrepository.repository.EBookRepository;
import com.bdzjn.udd.ebookrepository.storage.StorageProperties;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.List;

@Service
public class EBookService {

    private IREBookRepository irEbookRepository;

    private EBookRepository eBookRepository;

    private PdfDocumentHandler pdfDocumentHandler;

    private Path dirLocation;

    @Autowired
    public EBookService(StorageProperties properties,
                        IREBookRepository irEbookRepository,
                        EBookRepository eBookRepository,
                        PdfDocumentHandler pdfDocumentHandler) {
        this.dirLocation = Paths.get(properties.getLocation());
        this.irEbookRepository = irEbookRepository;
        this.eBookRepository = eBookRepository;
        this.pdfDocumentHandler = pdfDocumentHandler;
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
        }
        catch (IOException e) {
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
}
