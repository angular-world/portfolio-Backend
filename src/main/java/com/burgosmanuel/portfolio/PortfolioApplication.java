package com.burgosmanuel.portfolio;

import com.burgosmanuel.portfolio.security.repository.RoleRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="API Portfolio Web - #YoProgramo", description="<b>Descripción:</b> Este proyecto se trata de una <b>API REST</b> realizada con <b>Java Spring Boot</b> encargada de realizar las operaciones <i>CRUD</i> en nuestra base de datos <b>MySQL</b>, además de autenticar y autorizar usuarios a través de <b>JWT (JSON Web Token)</b>, trabajando en conjunto con nuestro <i>Frontend</i> a través de peticiones HTTP. <br><br> <b>Autor: <a href='https://burgosmanuel.ar' target='_BLANK'>Burgos Manuel</a></b>", version="1.0"))
@SecurityScheme(name = "Authorization", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

}
