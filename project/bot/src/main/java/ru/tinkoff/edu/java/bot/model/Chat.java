package ru.tinkoff.edu.java.bot.model;

import lombok.Data;
import ru.tinkoff.edu.java.bot.model.Link;

import java.util.HashSet;
import java.util.Set;

@Data
public class Chat {

    private Long id;
    private Set<Link> links;

    public Chat(long id) {
        this.id = id;
        links = new HashSet<>();
    }
}