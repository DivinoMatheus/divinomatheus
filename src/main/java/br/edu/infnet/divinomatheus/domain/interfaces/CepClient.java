package br.edu.infnet.divinomatheus.domain.interfaces;

import br.edu.infnet.divinomatheus.domain.valueobjects.ViaCepEndereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "cepClient")
public interface CepClient {

    @GetMapping(value = "/{cep}/json")
    ViaCepEndereco buscaPorCep(@PathVariable String cep);
}
