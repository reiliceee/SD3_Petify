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
            .csrf(csrf -> csrf.disable()) // ✅ disable CSRF for all
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/", "/index", "/login", "/register", "/home", "/homepage",
                    "/shop", "/community", "/appointments", "/about", "/services", "/contacts", 
                    "/api/**", "/images/**", "/config/**", "/homepage/**", "/profile/**", "/overview/**",
                    "/inbox/**", "/pet-management", "/pet-management/**", "/Adminprofile/**",
                    "/dashboard/**", "/forgot-password/**", "/medical-services/**", "/grooming-services/**",
                    "/pet-care-services/**", "/analytics", "/purchase-pets/**", "/admin/**",
                    "/book-appointment/**", "/url", "/api/pets/**", "/api/products/**"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form.disable());

        return http.build();
    }
}


