package br.edu.infnet.divinomatheus.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Moto {
    private String modelo;
    private int ano;
    private String placa;
    private boolean temBauDeEntrega;
}
