//package com.run.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @author: edxuanlen
// * @date: 2020-06-02 17:11
// * @version: 1.0
// **/
//
//@EnableWebMvc
//@EnableSwagger2
//@Configuration
//public class SwaggerConfig {
//
//	@Bean
//	public Docket createRestApi(){
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(apiInfo())
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.run.controller"))
//				.paths(PathSelectors.any())
//				.build();
//	}
//
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder()
//				.title("接口列表 v1.1.0")
//				.description("api test")
//				.termsOfServiceUrl("http://localhost:666/swagger-ui.html")
//				.contact("edxuanlen")
//				.version("1.1.0")
//				.build();
//	}
//
//}
