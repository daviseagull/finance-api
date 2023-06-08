package com.dseagull.financeapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  private static Info getInfo() {
    return new Info()
        .title("Finance API")
        .version("1.0.0-SNAPSHOT")
        .description("API responsible for dealing with requests from finance UI");
  }

  @Bean
  public OpenAPI customizeOpenAPI() {
    final String securitySchemeName = "bearer-jwt";
    return new OpenAPI()
        .info(getInfo())
        .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
        .components(
            new Components()
                .addSecuritySchemes(
                    securitySchemeName,
                    new SecurityScheme()
                        .name(securitySchemeName)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")));
  }
}
