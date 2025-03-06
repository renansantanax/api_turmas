package com.example.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

	@Bean
	OpenAPI customOpenApi() {
		
		var openAPI = new OpenAPI()
				.components(new Components())
				.info(new Info()
				.title("API para controle de turmas")
				.description("API Spring Boot com Spring Data para gerenciamento de turmas, alunos, professores e matriculas")
				.version("v1"));
				
		return openAPI;
	}
	
}	