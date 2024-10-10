package br.edu.infnet.divinomatheus.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Motorista {
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private Moto moto;
    private boolean temBauDeEntrega;
}
