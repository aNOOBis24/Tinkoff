package ru.tinkoff.edu.java.bot.dto.dto;
import ru.tinkoff.edu.java.scrapper.model.Link;

import java.util.List;

public record ListLinkResponse(List<Link> links, int size) {
}
