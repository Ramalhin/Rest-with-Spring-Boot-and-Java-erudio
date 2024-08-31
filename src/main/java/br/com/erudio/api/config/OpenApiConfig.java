package br.com.erudio.api.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Restful with java and spring boot")
                        .version("v1")
                        .description("My api ")
                        .termsOfService("none")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://pub.erudio.com.br/meus-cursos")));
    }
}
