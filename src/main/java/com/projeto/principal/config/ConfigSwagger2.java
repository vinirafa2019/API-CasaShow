package com.projeto.principal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ConfigSwagger2 implements WebMvcConfigurer{ 

	@Bean
	public Docket apiDocket() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.projeto.principal.api.resources"))
				.build()
				.apiInfo(apiInfo());
				//.tags(new Tags("Casas","Eventos","Usuarios","Vendas"));
	
	
	}		
	
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Api do Gerenciador de Eventos")
				.description("Projeto API do Gerenciador de Eventos")
				.version("1")
				.contact(new Contact("Vinicius", "https:www.algaworks.com", "vinirafa2013@hotmail.com")).build();
	}
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		
	}
}
