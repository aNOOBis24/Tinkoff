package ru.tinkoff.edu.java.bot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.java.bot.client.GitHubClient;
import ru.tinkoff.edu.java.bot.client.StackOverflowClient;

@Configuration
public class ClientConfiguration {

    @Value("${gh.baseurl}")
    private String gitHubBaseUrl;

    @Value("${so.baseurl}")
    private String stackOverflowBaseUrl;


    //Регистрируем клиентов как бины
    @Bean
    public GitHubClient gitHubClientService() {
        return new GitHubClient(gitHubBaseUrl);
    }

    @Bean
    public StackOverflowClient stackOverflowClientService() {
        return new StackOverflowClient(stackOverflowBaseUrl);
    }

}
