package org.example;
import org.example.parsers.AbstractLink;
import org.example.parsers.GitLink;
import org.example.parsers.StackLink;
import org.example.results.ParseResult;

public class LinkParser {
    public ParseResult parseUrl(String url) {
        AbstractLink parser1 = new GitLink(null);
        AbstractLink parser2 = new StackLink(parser1);

        return parser2.parseResult(url);
    }

}

