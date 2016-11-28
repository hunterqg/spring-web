package com.qingao.hello.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

/**
 * Created by qingao on 16-8-19.
 */
@Configuration
public class DataSourceConfig {

    private static Logger logger = Logger.getLogger(DataSourceConfig.class);

    @Autowired(required = true)
    private Environment env;


    @Bean
    public DataSource dataSource() {
        BasicDataSource ds =new BasicDataSource();
        ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        ds.setUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.username"));
        ds.setPassword(env.getProperty("jdbc.password"));

        logger.info("------->d_name="+env.getProperty("jdbc.driverClassName") +env.getProperty("jdbc.url") );
        return ds;
    }
}
