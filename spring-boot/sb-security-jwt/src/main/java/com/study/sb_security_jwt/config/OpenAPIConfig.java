package com.study.sb_security_jwt.config;

/**
 * @author Avaruus Studios
 * @name OpenAPIConfig
 * @date 7/9/2024
 */

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;



@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Alibou",
                        email = "contact@aliboucoding.com",
                        url = "https://aliboucoding.com/course"
                ),
                description = "OpenApi documentation for Spring Security",
                title = "OpenApi specification - Alibou",
                version = "1.0",
                license = @License(
                        name = "Licence name",
                        url = "https://some-url.com"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8990"
                ),
                @Server(
                        description = "PROD ENV",
                        url = "https://aliboucoding.com/course"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenAPIConfig {

//    @Value("${openapi.dev-url}")
//    private String devUrl;
//
//    @Value("${openapi.prod-url}")
//    private String prodUrl;
//
//    @Bean
//    public OpenAPI myOpenAPI() {
//        Server devServer = new Server();
//        devServer.setUrl(devUrl);
//        devServer.setDescription("Server URL in Development environment");
//
//        Server prodServer = new Server();
//        prodServer.setUrl(prodUrl);
//        prodServer.setDescription("Server URL in Production environment");
//
//        Contact contact = new Contact();
//        contact.setEmail("sunny.aitawade@gmail.com");
//        contact.setName("SoftRider");
//        contact.setUrl("https://www.sunnya.com");
//
//        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");
//
//        Info info = new Info()
//                .title("Spring boot JWT API")
//                .version("1.0")
//                .contact(contact)
//                .description("This API exposes endpoints to core java tutorials.").termsOfService("https://www.sunnya.com/terms")
//                .license(mitLicense);
//
//        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
//    }
}