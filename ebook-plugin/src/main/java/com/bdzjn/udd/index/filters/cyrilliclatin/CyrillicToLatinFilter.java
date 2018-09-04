package com.bdzjn.udd.index.filters.cyrilliclatin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class CyrillicToLatinFilter extends TokenFilter {

    private static final Logger LOGGER = LogManager.getLogger(CyrillicToLatinFilter.class);

    private CharTermAttribute termAttribute;

    public CyrillicToLatinFilter(TokenStream input) {
        super(input);
        termAttribute=(CharTermAttribute)input.addAttribute(CharTermAttribute.class);
    }

    public boolean incrementToken()throws IOException {
        LOGGER.error("CALLING incrementToken METHOD");
        if (input.incrementToken()) {
            LOGGER.error("IF IS TRUE IN incrementToken METHOD");
            String text=termAttribute.toString();
            termAttribute.setEmpty();
            termAttribute.append(CyrillicLatinConverter.cir2lat(text));
            return true;
        }
        return false;
    }

}