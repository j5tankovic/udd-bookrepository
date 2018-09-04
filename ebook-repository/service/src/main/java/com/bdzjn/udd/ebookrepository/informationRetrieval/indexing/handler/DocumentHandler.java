package com.bdzjn.udd.ebookrepository.informationRetrieval.indexing.handler;

import com.bdzjn.udd.ebookrepository.informationRetrieval.model.IREBook;
import com.bdzjn.udd.ebookrepository.model.EBook;
import org.apache.lucene.document.Document;

import java.io.File;
import java.nio.file.Path;

public abstract class DocumentHandler {

    public abstract IREBook getIREBook(EBook eBook, Path filepath);
    public abstract IREBook getIREBook(File file);
    public abstract String getText(File file);
    public abstract String getText(Document document);
}
