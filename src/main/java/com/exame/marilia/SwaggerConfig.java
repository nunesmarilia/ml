package com.exame.marilia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket detalheApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.exame.marilia"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(this.informacoesApi().build());

		return docket;
	}
	
	private ApiInfoBuilder informacoesApi() {
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		/*
		apiInfoBuilder
		.title(Translator.toLocale("api.swagger.title"))
		.description(Translator.toLocale("api.swagger.description"))
		.version(Translator.toLocale("api.swagger.version"));
		*/
		return apiInfoBuilder;
	}
}
