package com.qingao.hello.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by qingao on 16-8-10.
 */
@Configuration
@ComponentScan("com.qingao.hello")
public class RootConfig {
}
