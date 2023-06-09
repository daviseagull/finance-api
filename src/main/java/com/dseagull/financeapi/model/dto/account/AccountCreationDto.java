package com.dseagull.financeapi.model.dto.account;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Builder;

@Builder
public record AccountCreationDto(String description, BigDecimal initialBalance, String user)
    implements Serializable {}
