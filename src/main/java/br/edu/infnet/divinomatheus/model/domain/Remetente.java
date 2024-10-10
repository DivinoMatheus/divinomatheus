package br.edu.infnet.divinomatheus.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Remetente {
    private String nome;
    private String sobrenome;
    private Endereco endereco;
    private String telefone;
    private String email;
}
