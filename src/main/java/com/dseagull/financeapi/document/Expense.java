package com.dseagull.financeapi.document;

import com.dseagull.financeapi.model.Transaction;
import com.dseagull.financeapi.model.enums.ExpenseCategoryEnum;
import com.dseagull.financeapi.model.enums.ExpenseTypeEnum;
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
public class Expense extends Transaction {

  @Id private String id;

  private ExpenseTypeEnum type;

  private ExpenseCategoryEnum category;

  @Builder(builderMethodName = "expenseBuilder")
  public Expense(
      String account,
      String card,
      String name,
      LocalDate date,
      BigDecimal value,
      String id,
      ExpenseTypeEnum type,
      ExpenseCategoryEnum category) {
    super(account, card, name, date, value);
    this.id = id;
    this.type = type;
    this.category = category;
  }
}
