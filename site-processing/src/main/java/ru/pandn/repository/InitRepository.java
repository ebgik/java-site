package ru.pandn.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

public class InitRepository {
    private static final Logger logger = LoggerFactory.getLogger(InitRepository.class);

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    public void init() {
        logger.info("InitRepository init()");
        jdbc = new JdbcTemplate(dataSource);
    }
}
