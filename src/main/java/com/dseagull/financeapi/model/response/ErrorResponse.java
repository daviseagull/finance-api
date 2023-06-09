package com.dseagull.financeapi.model.response;

import java.io.Serializable;
import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ErrorResponse(HttpStatus status, String message) implements Serializable {}
