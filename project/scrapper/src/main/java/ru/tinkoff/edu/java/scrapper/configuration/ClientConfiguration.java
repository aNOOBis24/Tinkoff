package ru.tinkoff.edu.java.scrapper.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.java.scrapper.client.GitHubClient;
import ru.tinkoff.edu.java.scrapper.client.StackOverflowClient;
import ru.tinkoff.edu.java.scrapper.client.BotClient;

@Configuration
public class ClientConfiguration {


    private String gitHubBaseUrl;


    private String stackOverflowBaseUrl;

    private String botBaseUrl;


    @Bean
    public GitHubClient gitHubClientService() {
        return new GitHubClient(gitHubBaseUrl);
    }

    @Bean
    public StackOverflowClient stackOverflowClientService() {
        return new StackOverflowClient(stackOverflowBaseUrl);
    }

    @Bean
    public BotClient botClient() {return new BotClient(botBaseUrl);}

    @Bean
    public WebClient gitWebClient(){return WebClient.create(gitHubBaseUrl);}

    @Bean
    public WebClient stackWebClient(){ return WebClient.create(stackOverflowBaseUrl);}

}
