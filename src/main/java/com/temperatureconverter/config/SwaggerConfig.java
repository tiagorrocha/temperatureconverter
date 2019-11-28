package com.temperatureconverter.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.temperatureconverter.controller"))
				.paths(PathSelectors.any()).build()
				.globalResponseMessage(RequestMethod.GET, responseMessageForGET())
				.globalResponseMessage(RequestMethod.POST, responseMessageForPOST())
				.apiInfo(apiInfo());
	}
	private List<ResponseMessage> responseMessageForGET() {
		return new ArrayList<ResponseMessage>() {
			private static final long serialVersionUID = 1L;
			{
				add(new ResponseMessageBuilder().code(200).message("Ok!").build());
			}
		};
	}
	
	private List<ResponseMessage> responseMessageForPOST() {
		return new ArrayList<ResponseMessage>() {
			private static final long serialVersionUID = 1L;
			{
				add(new ResponseMessageBuilder()
			            .code(500)
			            .message("Number format exception")
			            .build());
				add(new ResponseMessageBuilder().code(200)
						.message("Ok!")
						.build());
			}
		};
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Temperature Converter")
				.description("Temperature Converter is an application that"
						+ " allows you to convert degrees celsius to fahrenheit"
						+ " and vice versa and access a conversion history.")
				.version("1.0.0").license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.contact(new Contact("Tiago", "https://tiagorrocha.github.io", "tiagorocha.tiago@gmail.com"))
				.build();
	}
}
