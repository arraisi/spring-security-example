package com.arraisi.security.springsecurityexample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // CREATE USER
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())              // (NEW) KALAU TIDAK MENGGUNAKAN SYNTAX INI BERIKAN "{noop}" DI SEBELAH PASSWORD
                .withUser("user").password("password").roles("USER");   // .password("{noop}password") *TIDAK DIREKOMENDASIKAN source : https://spring.io/blog/2017/11/01/spring-security-5-0-0-rc1-released#password-encoding
    }

    // CONFIGURATION, ROLE, AUTHENTICATION AND AUTHORIZATION
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .anyRequest()
                .fullyAuthenticated()
                .and().httpBasic();
        httpSecurity.csrf().disable();
    }
}
