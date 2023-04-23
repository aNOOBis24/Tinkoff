package org.example;
import org.example.parsers.AbstractLinkParser;
import org.example.parsers.GitLink;
import org.example.parsers.StackLink;
import org.example.results.ParseResult;

public class LinkParser {
    public ParseResult parseUrl(String url) {
        AbstractLinkParser parser1 = new GitLink(null);
        AbstractLinkParser parser2 = new StackLink(parser1);

        return parser2.parseResult(url);
    }

}

