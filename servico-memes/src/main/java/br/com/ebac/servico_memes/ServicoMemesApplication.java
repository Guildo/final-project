package br.com.ebac.servico_memes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableJpaRepositories("br.com.ebac.servico_memes.repository")
public class ServicoMemesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicoMemesApplication.class, args);
	}
}
