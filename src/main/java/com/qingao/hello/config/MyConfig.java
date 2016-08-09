package com.qingao.hello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import java.util.ArrayList;

@Configuration
@PropertySource("classpath:env.properties")
public class MyConfig {
    @Bean(name = "dataList")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ArrayList<String> getDataList() {
        System.out.println("--------> init dataList");
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add(env.getProperty("key_seven","default_seven"));
        return list;
    }

    @Autowired(required = true)
    Environment env;
}
