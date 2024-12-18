package br.com.ebac.servico_memes.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Configuration
@EnableDiscoveryClient
public class CategoriaMemeClient {

    @Autowired
    private CMClient cmClient;

    @FeignClient(name = "servico-categoria-memes")
    interface CMClient {
        @RequestMapping(path = "/categorias/{id}", method = RequestMethod.GET)
        ResponseEntity<?> buscaCategoriaPorId(@PathVariable Long id);
    }

    public ResponseEntity<?> buscaCategoriaPorId(Long id) {
        return cmClient.buscaCategoriaPorId(id);
    }
}
