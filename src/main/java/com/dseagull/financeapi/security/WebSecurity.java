package com.dseagull.financeapi.security;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurity {

  private static final String[] PERMITTED_URIS = {
    "/v3/api-docs/**", "/v3/api-docs/", "/swagger-ui/**", "/swagger-ui.html"
  };

  private final JwtToUserConverter converter;

  @Bean
  public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            auth -> auth.requestMatchers(PERMITTED_URIS).permitAll().anyRequest().authenticated())
        .csrf(withDefaults())
        .cors(withDefaults())
        .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
        .oauth2ResourceServer(
            oauth2 -> oauth2.jwt(customizer -> customizer.jwtAuthenticationConverter(converter)))
        .exceptionHandling(
            exceptions ->
                exceptions
                    .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
                    .accessDeniedHandler(new BearerTokenAccessDeniedHandler()));

    return http.build();
  }
}
