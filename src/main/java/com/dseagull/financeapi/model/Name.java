package com.dseagull.financeapi.model;

import java.io.Serializable;
import lombok.Builder;

@Builder
public record Name(String firstName, String lastName) implements Serializable {}
