package ru.tinkoff.edu.java.bot.model;

public class Link {

    private static Long nextId = 1L;
    private Long id;
    private String url;

    public Link(Long id, String url) {
        this.id = nextId;
        nextId++;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public Long getId() {
        return id;
    }

}
