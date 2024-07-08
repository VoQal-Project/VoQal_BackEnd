package Capstone.VoQal.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "VoQal",
                        url = "https://github.com/VoQal-Project/VoQal_BackEnd"
                ),
                description = "VoQal application",
                title = "VoQal",
                version = "v0.0.1"
        ),
        security = {
                @SecurityRequirement(name = "bearerAuth")
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT를 사용한 인증",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Set<String> protocols = new HashSet<>();
        protocols.add("http");
        protocols.add("https");

        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info().title("VoQal")
                        .description("VoQal application")
                        .version("v0.0.1")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("VoQal")
                                .url("https://github.com/VoQal-Project/VoQal_BackEnd")))
                .servers(List.of(
                        new io.swagger.v3.oas.models.servers.Server().url("http://localhost:8080").description("Local HTTP server"),
                        new io.swagger.v3.oas.models.servers.Server().url("https://voqal.codns.com").description("Production HTTPS server")
                ));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/**")
                .build();
    }
}
