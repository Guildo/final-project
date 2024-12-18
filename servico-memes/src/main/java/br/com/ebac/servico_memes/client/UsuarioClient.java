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
public class UsuarioClient {

    @Autowired
    private CategoriaMemeClient categoriaMemeClient;

    @FeignClient(name = "servico-usuarios")
    interface CategoriaMemeClient {
        @RequestMapping(path = "/usuarios/{id}", method = RequestMethod.GET)
        ResponseEntity<?> buscaUsuarioPorId(@PathVariable Long id);
    }

    public ResponseEntity<?> buscaUsuarioPorID(Long id) {
        return categoriaMemeClient.buscaUsuarioPorId(id);
    }
}
