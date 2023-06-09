package com.dseagull.financeapi.security;

import com.dseagull.financeapi.document.User;
import com.dseagull.financeapi.repository.UserRepository;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class JwtToUserConverter implements Converter<Jwt, UsernamePasswordAuthenticationToken> {

  public static final String EMAIL = "email";

  private final UserRepository userRepository;

  @Override
  public UsernamePasswordAuthenticationToken convert(Jwt source) {
    User user =
        userRepository
            .findByUsername(source.getClaimAsString(EMAIL))
            .orElseGet(() -> createUser(source));
    return new UsernamePasswordAuthenticationToken(user, source, new ArrayList<>());
  }

  private User createUser(Jwt source) {
    log.info("Create user from jwt: { 'username': {}}", source.getClaimAsString(EMAIL));
    User user =
        User.builder().username(source.getClaimAsString(EMAIL)).enabled(Boolean.TRUE).build();
    return userRepository.save(user);
  }
}
