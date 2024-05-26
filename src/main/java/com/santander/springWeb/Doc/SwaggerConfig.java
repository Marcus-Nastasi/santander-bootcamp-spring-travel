/*package com.santander.springWeb.Doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Contact contact() {
        return new Contact(
            "Marcus Vinicius Rolemberg",
            "http://www.examlpe.com",
            "vinnie.nsts@gmail.com"
        );
    }

    private ApiInfoBuilder apiInfo() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Travel agency RESTful API.");
        apiInfoBuilder.description("RESTful API consuming data from mySQL's database viagensDIO.");
        apiInfoBuilder.version("1.0.1");
        apiInfoBuilder.termsOfServiceUrl("Open source");
        apiInfoBuilder.contact(this.contact());

        return apiInfoBuilder;
    }

    @Bean
    public Docket detalheApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.santander.springWeb.Controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfo().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }
}

*/

