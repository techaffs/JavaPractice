package com.learningByDoing.restful_web_services.security.basic;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class SpringSecurityConfiguration {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        return
        httpSecurity
            .authorizeHttpRequests(
                 auth -> auth
                         .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Permit all requests with Options method to in-flight chek
                         .anyRequest().authenticated() // 1. All requests should be authenticated
                 )
            .httpBasic(Customizer.withDefaults()) // 2. If a request is not authenticated, a web page is shown.
            .sessionManagement(
                 session -> session.sessionCreationPolicy
                 (SessionCreationPolicy.STATELESS)) //  All REST APIs Stateless
            .csrf().disable() // 3. CSRF -> POST, PUT
            .build();
    }

}
