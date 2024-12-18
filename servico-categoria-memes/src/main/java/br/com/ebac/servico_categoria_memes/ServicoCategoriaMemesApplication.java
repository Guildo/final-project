package br.com.ebac.servico_categoria_memes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories("br.com.ebac.servico_categoria_memes.repository")
public class ServicoCategoriaMemesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicoCategoriaMemesApplication.class, args);
	}
}