package br.com.livraria_dh.catalogo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI customizarSwagger() {
		return new OpenAPI().info(new Info().title("API Catálogo de Livros - Projeto Integrador")
				.description("Backend Santander - Digital House - Nov/2021")
				.description("Elaine Jeremias ❤️, Salomão Cunha 😎, Daniel Baião 🤓, Carlos Augusto 🏃")
				.termsOfService("http://swagger.io/terms")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
}
