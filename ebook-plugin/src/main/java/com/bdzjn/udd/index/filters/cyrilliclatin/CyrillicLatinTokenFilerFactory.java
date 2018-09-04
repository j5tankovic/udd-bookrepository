package com.bdzjn.udd.index.filters.cyrilliclatin;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

public class CyrillicLatinTokenFilerFactory extends AbstractTokenFilterFactory {

    public CyrillicLatinTokenFilerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(indexSettings, name, settings);
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new CyrillicToLatinFilter(tokenStream);
    }
}
