package br.edu.infnet.divinomatheus.model.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Endereco {
    private String cep;
    private String bairro;
    private String rua;
    private String estado;
    private String complemento;
    private int numero;
}
