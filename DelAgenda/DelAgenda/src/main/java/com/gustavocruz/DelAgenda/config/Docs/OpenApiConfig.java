package com.gustavocruz.DelAgenda.config.Docs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Backend for delAgenda Application")
                        .version("v1")
                        .description("RestFull java + springboot API")
                        .termsOfService("https://github.com/GustavoCruzzz")
                        .license(new License().name("license").url("https://github.com/GustavoCruzzz")));
    }


}
