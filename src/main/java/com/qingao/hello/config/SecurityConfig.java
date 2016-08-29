package com.qingao.hello.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by qingao on 16-8-16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.debug("--------->config the request");
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests()
                    .anyRequest()
                    .authenticated()
                .and()
                    .formLogin()
                .and()
                    .httpBasic()
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                    ;

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        logger.debug("--------> config user");
        auth.inMemoryAuthentication().withUser("user").password("123456").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("supadmin").password("123456").roles("SUPERADMIN");

    }
}
