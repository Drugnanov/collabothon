package com.commerz.dvadnyvtahu.ai.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI customizedOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Collabothon API")
                .description("AI image generation of Dva dny v tahu team"));
    }

}
