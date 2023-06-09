package com.dseagull.financeapi.document;

import com.dseagull.financeapi.model.Name;
import java.util.ArrayList;
import java.util.Collection;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@Document
@AllArgsConstructor
@RequiredArgsConstructor
public class User implements UserDetails {

  @Id private String id;

  private Name name;

  private String username;

  private String password;

  private boolean enabled;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return new ArrayList<>();
  }

  @NonNull
  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  @NonNull
  @Override
  public String getPassword() {
    return password;
  }
}
