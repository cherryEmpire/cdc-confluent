package com.cherry.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.stereotype.Component;
import springfox.documentation.oas.web.OpenApiTransformationContext;
import springfox.documentation.oas.web.WebMvcOpenApiTransformationFilter;
import springfox.documentation.spi.DocumentationType;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/1/7 0:12
 * @Description: Workaround
 */
@Component
public class SwaggerWorkaroundConfig implements WebMvcOpenApiTransformationFilter {

    @Override
    public OpenAPI transform(OpenApiTransformationContext<HttpServletRequest> context) {
        OpenAPI openApi = context.getSpecification();
        Server localServer = new Server();
        localServer.setDescription("DEV");
        localServer.setUrl("http://localhost:8081");

        Server testServer = new Server();
        testServer.setDescription("PROD");
        testServer.setUrl("http://127.0.0.1:8081");
        openApi.setServers(Arrays.asList(localServer, testServer));
        return openApi;
    }

    @Override
    public boolean supports(DocumentationType documentationType) {
        return documentationType.equals(DocumentationType.OAS_30);
    }
}
