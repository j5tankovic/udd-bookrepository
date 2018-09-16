package com.bdzjn.udd.ebookrepository.informationRetrieval.indexing.handler;

import com.bdzjn.udd.ebookrepository.informationRetrieval.model.IREBook;
import com.bdzjn.udd.ebookrepository.model.EBook;
import org.apache.lucene.document.Document;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Component
public class PdfDocumentHandler extends DocumentHandler {

    @Override
    public IREBook getIREBook(EBook eBook, Path filepath) {
        IREBook ireBook = new IREBook();

        ireBook.setFilename(eBook.getFilename());
        ireBook.setLanguage(eBook.getLanguage().getName());
        ireBook.setCategory(String.valueOf(eBook.getCategory().getId()));
        ireBook.setTitle(eBook.getTitle());

        File bookFile = filepath.toFile();
        ireBook.setText(getText(bookFile));

        if (eBook.getAuthor() != null) {
            ireBook.setAuthor(eBook.getAuthor());
        }

        if (eBook.getKeywords() != null) {
            ireBook.setKeywords(eBook.getKeywords());
        }

        return ireBook;
    }

    @Override
    public IREBook getIREBook(File file) {
        return null;
    }

    @Override
    public String getText(File file) {
        try {
            PDFParser parser = new PDFParser(new RandomAccessFile(file, "r"));
            parser.parse();
            PDFTextStripper textStripper = new PDFTextStripper();
            String text = textStripper.getText(parser.getPDDocument());
            return text;
        } catch (IOException e) {
            System.err.println("Error while converting document to pdf");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getText(Document document) {
        return null;
    }

}
