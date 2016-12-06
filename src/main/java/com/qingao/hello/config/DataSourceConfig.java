package com.qingao.hello.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Created by qingao on 16-8-19.
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig {

    private static Logger logger = Logger.getLogger(DataSourceConfig.class);

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.userName}")
    private String userName;
    @Value("${jdbc.password}")
    private String passwd;

    @Value("${jdbc.initialSize:5}")
    private int initialSize;

    @Value("${jdbc.minIdle:5}")
    private int minIdle;

    @Value("${jdbc.maxIdle:20}")
    private int maxIdle;

    @Value("${jdbc.maxActive:100}")
    private int maxActive;

    @Value("${jdbc.maxWaitMills:120000}")
    private int maxWaitMills;

    @Value("${jdbc.defaultAutoCommit:false}")
    private boolean defaultAutoCommit;

    @Value("${jdbc.removeAbandoned:true}")
    private boolean removeAbandoned;

    @Value("${jdbc.removeAbandonedTimeOut:600}")
    private int removeAbandonedTimeOut;

    @Value("${jdbc.testWhileIdle:true}")
    private boolean testWhileIdle;

    @Value("${jdbc.timeBetweenEvictionRunsMills:60000}")
    private long timeBetweenEvictionRunsMills;

    @Value("${jdbc.numTestsPerEvictionRun:10}")
    private int numTestsPerEvictionRun;

    @Value("${jdbc.minEvictableIdleTimeMills:600000}")
    private long minEvictableIdleTimeMills;
    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(passwd);

        ds.setInitialSize(initialSize);
        ds.setMinIdle(minIdle);
        ds.setMaxIdle(maxIdle);
        ds.setMaxWaitMillis(maxWaitMills);
        ds.setDefaultAutoCommit(defaultAutoCommit);
        ds.setRemoveAbandonedOnMaintenance(removeAbandoned);
        ds.setRemoveAbandonedOnBorrow(removeAbandoned);
        ds.setRemoveAbandonedTimeout(removeAbandonedTimeOut);
        ds.setTestWhileIdle(testWhileIdle);
        ds.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMills);
        ds.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        ds.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMills);
        //logger.info("------->d_name="+env.getProperty("jdbc.driverClassName") +env.getProperty("jdbc.url") );

        /*String dbConnectionInfo = "\n" +
                "************************************************\n" +
                "" +
                "************************************************";*/
        return ds;
    }
}
