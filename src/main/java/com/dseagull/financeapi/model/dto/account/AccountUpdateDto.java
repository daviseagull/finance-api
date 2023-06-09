package com.dseagull.financeapi.model.dto.account;

import java.io.Serializable;
import lombok.Builder;

@Builder
public record AccountUpdateDto(String id, String description) implements Serializable {}
