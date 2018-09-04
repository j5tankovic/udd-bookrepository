package com.bdzjn.udd.index.filters.stopwords;

import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

public class StopWordsTokenFilterFactory extends AbstractTokenFilterFactory {

    public static final String[] STOP_WORDS = {
            "biti", "ne",
            "jesam", "sam", "jesi", "si", "je", "jesmo", "smo", "jeste", "ste", "jesu", "su",
            "nijesam", "nisam", "nijesi", "nisi", "nije", "nijesmo", "nismo", "nijeste", "niste", "nijesu", "nisu",
            "budem", "budeš", "bude", "budemo", "budete", "budu",
            "budes",
            "bih", "bi", "bismo", "biste", "biše",
            "bise",
            "bio", "bili", "budimo", "budite", "bila", "bilo", "bile",
            "ću", "ćeš", "će", "ćemo", "ćete",
            "neću", "nećeš", "neće", "nećemo", "nećete",
            "cu", "ces", "ce", "cemo", "cete",
            "necu", "neces", "nece", "necemo", "necete",
            "mogu", "možeš", "može", "možemo", "možete",
            "mozes", "moze", "mozemo", "mozete",
            "li", "da"
    };

    public StopWordsTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(indexSettings, name, settings);
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new StopFilter(tokenStream, StopFilter.makeStopSet(STOP_WORDS));
    }
}
