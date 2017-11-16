package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
          .select()                                  
//          .apis(RequestHandledEvent.any())              
          .apis(RequestHandlerSelectors.basePackage("hello"))
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo()); //to customize contact and other stuff (see below)
    }
    
    private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title("Hello REST Sample with Swagger")
			.description("Hello description")
			// 1st arg: developer Name, 2nd arg: link for more documentation
			// 3rd arg: developer email
			.contact(new Contact("Fabio Fonseca", null, "fabio.l.fonseca@gmail.com"))
			.build();
    }
}