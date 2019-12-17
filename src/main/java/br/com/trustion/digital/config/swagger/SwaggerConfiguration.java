package br.com.trustion.digital.config.swagger;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.trustion.digital.entities.User;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public Docket forumApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.trustion.digital.controllers"))
				.paths(PathSelectors.any())
				.build()
				.ignoredParameterTypes(disableTemplateClassesModels())
				
				// Setting global parameter
				.globalOperationParameters(Arrays.asList(
						new ParameterBuilder()
						.name("Authorization")
						.description("Header for token JWT")
						.modelRef(new ModelRef("string"))//Type parameter
						.parameterType("header")
						.required(false)
						.build()))
						.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        	.title("Trustion Digital API")
            .description("Serviço fornecido pela Trustion para solução de problemas referente a conciliação de cartoes digitais.")
            .contact(new Contact("Trustion", "https://www.trustion.com/", "contato@trustion.com.br"))
            .license("License: trustion-digital-api 1.0.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .version("1.0.0")
            .build();
    }
	
	//Method that returns templates that will be hidden in the API documentation
	@SuppressWarnings("rawtypes")
	private Class[] disableTemplateClassesModels(){
		ArrayList<Class> classForDisable = new ArrayList<>();
		
		//Entities - Models - DTO and others...
		classForDisable.add(User.class);
		
		return classForDisable.toArray(new Class[classForDisable.size()]);
	}
	
}
