package br.edu.infnet.divinomatheus.domain;

import br.edu.infnet.divinomatheus.domain.entities.Endereco;
import br.edu.infnet.divinomatheus.domain.valueobjects.ViaCepEndereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoAdapter {
    public Endereco adapt(ViaCepEndereco endereco) {
        return Endereco.builder()
                .cep(endereco.getCep())
                .rua(endereco.getLogradouro())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .estado(endereco.getUf())
                .build();
    }
}
