package ru.tinkoff.edu.java.bot.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.example.parsers.LinkParser;

@Configuration
public class LinkParserConfiguration {

    @Bean
    public LinkParser linkParser(){
        return new LinkParser();
    }
}