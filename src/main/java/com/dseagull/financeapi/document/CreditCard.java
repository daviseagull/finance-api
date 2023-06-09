package com.dseagull.financeapi.document;

import com.dseagull.financeapi.model.enums.CardTypeEnum;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
@AllArgsConstructor
@RequiredArgsConstructor
public class CreditCard {

    @Id private String id;

    private String description;

    private CardTypeEnum type;

    @Min(1)
    @Max(31)
    private Integer closingDay;

    private Set<String> expenses;

}
