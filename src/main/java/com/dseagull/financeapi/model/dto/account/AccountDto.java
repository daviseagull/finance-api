package com.dseagull.financeapi.model.dto.account;

import java.math.BigDecimal;
import java.util.Set;

public record AccountDto(
    String id, String description, BigDecimal balance, String user, Set<String> creditCards) {}
