package com.dseagull.financeapi.document;

import java.math.BigDecimal;
import java.util.Set;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@Document
@AllArgsConstructor
@RequiredArgsConstructor
public class Account {

  @Id private String id;

  @Setter private String description;

  private BigDecimal balance;

  private String user;

  private Set<String> creditCards;
}
