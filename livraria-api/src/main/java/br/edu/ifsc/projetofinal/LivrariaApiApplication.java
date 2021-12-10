package br.edu.ifsc.projetofinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariaApiApplication {

	public static void main(String[] args) {
		DataSourceLivro.criarLista();
		SpringApplication.run(LivrariaApiApplication.class, args);
	}

}
