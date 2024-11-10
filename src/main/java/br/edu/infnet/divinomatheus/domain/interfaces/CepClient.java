package br.edu.infnet.divinomatheus.domain.interfaces;

import br.edu.infnet.divinomatheus.domain.valueobjects.ViaCepEndereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "viacep", url = "https://www.viacep.com.br")
public interface CepClient {

    @RequestMapping(method = RequestMethod.GET, value = "/ws/{cep}/json", produces = "application/json")
    ViaCepEndereco buscaPorCep(String cep);
}
