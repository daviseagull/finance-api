package com.dseagull.financeapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
@AllArgsConstructor
@RequiredArgsConstructor
public class Transaction {

  private String account;

  private String card;

  private String description;

  private LocalDate date;

  private BigDecimal value;
}
