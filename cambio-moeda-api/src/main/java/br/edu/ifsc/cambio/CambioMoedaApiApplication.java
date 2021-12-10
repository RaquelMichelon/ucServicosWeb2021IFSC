package br.edu.ifsc.cambio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CambioMoedaApiApplication {

	public static void main(String[] args) {
		MoedaDataSource.criarLista();
		SpringApplication.run(CambioMoedaApiApplication.class, args);
	}

}
