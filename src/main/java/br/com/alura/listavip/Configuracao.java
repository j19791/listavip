package br.com.alura.listavip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @Controller
public class Configuracao {

	/*
	 * @RequestMapping("/")
	 * 
	 * @ResponseBody String ola() { return "OlÃ¡. EstÃ¡ tudo funcionando"; }
	 */

	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}

	// utilizando agora o application.properties para a configuração do bd

	/*
	 * @Bean // o Spring Boot deve gerenciar , assim é possível usa-lo onde você
	 * desejar // dentro da sua aplicação atráves da injeção de dependencia. public
	 * DataSource dataSource() { DriverManagerDataSource dataSource = new
	 * DriverManagerDataSource();
	 * dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	 * dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
	 * dataSource.setUsername("root"); dataSource.setPassword("pc1000"); return
	 * dataSource; }
	 */

}
