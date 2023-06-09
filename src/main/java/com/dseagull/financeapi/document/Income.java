package com.dseagull.financeapi.document;

import com.dseagull.financeapi.model.Transaction;
import com.dseagull.financeapi.model.enums.IncomeCategoryEnum;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Income extends Transaction {

  @Id private String id;

  private IncomeCategoryEnum category;

  @Builder(builderMethodName = "incomeBuilder")
  public Income(
      String account,
      String card,
      String description,
      LocalDate date,
      BigDecimal value,
      String id,
      IncomeCategoryEnum category) {
    super(account, card, description, date, value);
    this.id = id;
    this.category = category;
  }
}
