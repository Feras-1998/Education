package com.education.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

    private static final String DEV_URL = "http://localhost:8080";
    private static final String PROD_URL = "http://localhost:8080";

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(DEV_URL);
        devServer.setDescription("Local Server");

        Server prodServer = new Server();
        prodServer.setUrl(PROD_URL);
        prodServer.setDescription("Prod Server");

        Info info = new Info()
                .title("Education")
                .version("1.0")
                .description("This API exposes endpoints Education Project.");

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}