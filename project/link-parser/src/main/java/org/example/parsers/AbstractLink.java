package org.example.parsers;

import org.example.results.ParseResult;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public abstract class AbstractLink {
        protected Parser nextParser;

        public Parser(Parser nextParser) {
            this.nextParser = nextParser;
        }

        abstract ParsedObject parseLinkImpl(URL url);

        public ParsedObject parseLink(URL url) {
            ParsedObject res = parseLinkImpl(url);
            if (res != null) {
                return res;
            }
            if (nextParser != null) {
                return nextParser.parseLink(url);
            }
            return null;
        }
    }