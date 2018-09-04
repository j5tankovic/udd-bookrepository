package com.bdzjn.udd.plugin;

import com.bdzjn.udd.index.filters.cyrilliclatin.CyrillicLatinTokenFilerFactory;
import com.bdzjn.udd.index.filters.lowercase.LCTokenFilterFactory;
import com.bdzjn.udd.index.filters.stemming.SnowballTokenFilterFactory;
import com.bdzjn.udd.index.filters.stopwords.StopWordsTokenFilterFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.HashMap;
import java.util.Map;


public class ERepositoryPlugin extends Plugin implements AnalysisPlugin {

    private static final Logger LOGGER = LogManager.getLogger(ERepositoryPlugin.class);

    public ERepositoryPlugin() {
        super();
        LOGGER.warn("Create erepository plugin and install it to elasticsearch");
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();
        extra.put("sr_cyrillic_to_latin", CyrillicLatinTokenFilerFactory::new);
        extra.put("sr_lowercase", LCTokenFilterFactory::new);
        extra.put("sr_stopwords", StopWordsTokenFilterFactory::new);
        extra.put("sr_stemmer", SnowballTokenFilterFactory::new);

        return extra;
    }
}
