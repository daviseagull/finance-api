package com.dseagull.financeapi.security;

import com.dseagull.financeapi.document.User;
import java.util.ArrayList;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class JwtToUserConverter implements Converter<Jwt, UsernamePasswordAuthenticationToken> {

  @Override
  public UsernamePasswordAuthenticationToken convert(Jwt source) {
    User user = User.builder().username(source.getClaimAsString("email")).build();
    return new UsernamePasswordAuthenticationToken(user, source, new ArrayList<>());
  }
}
