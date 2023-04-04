package ru.tinkoff.edu.java.bot.model;

public class Link {

    private static Long nextId = 1L;
    private Long id;
    private String url;

    public Link(String url) {
        this.id = nextId;
        nextId++;
        this.url = url;
    }
}
