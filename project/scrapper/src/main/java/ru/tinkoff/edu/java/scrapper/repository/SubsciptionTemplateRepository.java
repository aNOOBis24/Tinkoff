package ru.tinkoff.edu.java.scrapper.repository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.tinkoff.edu.java.scrapper.mapper.LinkRowMapper;
import ru.tinkoff.edu.java.scrapper.mapper.SubscriptionRowMapper;
import ru.tinkoff.edu.java.scrapper.model.Link;
import ru.tinkoff.edu.java.scrapper.model.Relation;
import ru.tinkoff.edu.java.scrapper.model.User;

import java.util.List;

@Repository
@Slf4j
public class SubscriptionTemplateRepository implements SubscriptionRepository {

    private final JdbcTemplate jdbcTemplate;

    private final SubscriptionRowMapper subscriptionRowMapper;

    private final LinkRowMapper linkRowMapper;

    public SubscriptionTemplateRepository(JdbcTemplate jdbcTemplate, SubscriptionRowMapper subscriptionRowMapper, LinkRowMapper linkRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.subscriptionRowMapper = subscriptionRowMapper;
        this.linkRowMapper = linkRowMapper;
    }