package org.example.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
@Slf4j
@Data
public class ConnectionPool {

    private final HikariDataSource ds;


    final Logger logger = LoggerFactory.getLogger(ConnectionPool.class);


    String url;


    String user;


    String password;


    //      WITH SPRING PROPERTY SOURCE
    public ConnectionPool(
	    @Value("${spring.datasource.url}")
	    String dbUrl,

	    @Value("${spring.datasource.username}")
	    String dbUser,

	    @Value("${spring.datasource.password}")
	    String dbPassword) {
	this.url = dbUrl;
	this.user = dbUser;
	this.password = dbPassword;
	logger.debug(new StringBuilder().append(url).append("url prishel").append(user).append("user prishel").append(password).append("pass prishel").toString());

	HikariConfig config = new HikariConfig();

	config.setJdbcUrl(dbUrl);
	config.setUsername(dbUser);
	config.setPassword(dbPassword);

	ds = new HikariDataSource(config);
    }


    public Connection getConnection() throws SQLException {
	return ds.getConnection();
    }
}