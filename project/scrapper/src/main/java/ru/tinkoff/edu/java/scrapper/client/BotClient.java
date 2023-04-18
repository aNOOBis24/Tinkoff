package ru.tinkoff.edu.java.scrapper.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.tinkoff.edu.java.scrapper.dto.LinkUpdate;
import ru.tinkoff.edu.java.scrapper.exception.BotClientException;

@Slf4j
public class BotClient {

    private String botBaseUrl;

    private final WebClient webClient;

    public BotClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public BotClient(String botBaseUrl) {
        this.webClient = WebClient.create(botBaseUrl);
    }

    public void updateLink(LinkUpdate request) {
        log.info("Sending update request to Bot");
        webClient.post().uri("/updates").bodyValue(request).exchangeToMono(r -> {
            if (r.statusCode().equals(HttpStatus.BAD_REQUEST)) {
                throw new BotClientException("No registred chat with that ID");
            }
            return Mono.empty();
        }).block();
    }

}