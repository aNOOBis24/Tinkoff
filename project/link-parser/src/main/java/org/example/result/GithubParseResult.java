package org.example.result;


public record GithubParseResult(String username, String repository) implements ParseResult {

}