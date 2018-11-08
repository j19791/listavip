package br.com.alura.listavip;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
// @Controller
public class Configuracao {

	/*
	 * @RequestMapping("/")
	 * 
	 * @ResponseBody String ola() { return "Olá. Está tudo funcionando"; }
	 */

	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}

	@Bean // o Spring Boot deve gerenciar , assim � poss�vel usa-lo onde voc� desejar
			// dentro da sua aplica��o atr�ves da inje��o de dependencia.
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
		dataSource.setUsername("root");
		dataSource.setPassword("pc1000");
		return dataSource;
	}

}
