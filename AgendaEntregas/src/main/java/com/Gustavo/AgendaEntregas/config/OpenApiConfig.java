package com.Gustavo.AgendaEntregas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

   @Bean
   OpenAPI customOpenAPI(){
       return new OpenAPI().info(new Info().title("API de agendamento de entregas").version("v1").description("Api de agendamento de entregas").termsOfService("Sei la").license(new License().name("Nome da licensa").url("https://nãosei.com.br")));
   }




}
