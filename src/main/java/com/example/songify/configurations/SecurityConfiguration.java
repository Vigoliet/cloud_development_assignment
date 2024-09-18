package com.example.songify.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf
                        .ignoringRequestMatchers("/api/addSong"))
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/", "/styles.css").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/songs").authenticated() // Changed from permitAll() to authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/addSong").authenticated()
                        .anyRequest().authenticated())
                .oauth2Login(Customizer.withDefaults())
                .logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer.logoutSuccessUrl("/"));

        var logoutSuccessHandler = new CognitoLogoutSuccessHandler(clientRegistrationRepository);
        http.logout(c -> c.logoutSuccessHandler(logoutSuccessHandler));

        return http.build();
    }
}