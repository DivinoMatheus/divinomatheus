package br.edu.infnet.divinomatheus.domain.entities;

import lombok.Getter;
import lombok.Setter;

// @Entity
// @Table(name = "enderecos")
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
