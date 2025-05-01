package com.arise.petify;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/login", "/register", "/home","/homepage", "/shop", "/appointments", "/about", "/services", "/contacts", "/api/**", "/images/**", "/config/**","/homepage/**","/profile/**","/overview/**","/inbox/**","/pet-management", "/pet-management/**","/Adminprofile/**","/dashboard/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form.disable());

        return http.build();
    }
}

