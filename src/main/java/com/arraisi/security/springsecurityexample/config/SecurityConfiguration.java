package com.arraisi.security.springsecurityexample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    // CREATE USER
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("abdul").password("password").and()
//                .withUser("admin").password("password");
//    }

    // CONFIGURATION, ROLE, AUTHENTICATION AND AUTHORIZATION
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.
                authorizeRequests()
                .anyRequest()
                .permitAll()
                .and().httpBasic();
        httpSecurity.csrf().disable();
    }
}
