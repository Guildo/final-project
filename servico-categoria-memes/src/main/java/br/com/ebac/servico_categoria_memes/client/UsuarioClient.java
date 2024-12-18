package br.com.ebac.servico_categoria_memes.client;

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
@EnableFeignClients
@EnableDiscoveryClient
public class UsuarioClient {

    @Autowired
    private UClient uClient;

    @FeignClient(name = "servico-usuarios")
    interface UClient {
        @RequestMapping(path = "/usuarios/{id}", method = RequestMethod.GET)
        ResponseEntity<?> buscaUsuarioPorId(@PathVariable Long id);
    }

    public ResponseEntity<?> buscaUsuarioPorID(Long id) {
        return uClient.buscaUsuarioPorId(id);
    }
}
