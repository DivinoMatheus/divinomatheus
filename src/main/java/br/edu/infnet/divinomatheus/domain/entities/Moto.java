package br.edu.infnet.divinomatheus.domain.entities;

import lombok.Getter;
import lombok.Setter;

// @Entity
// @Table(name = "motos")
// @Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Moto {
    private String modelo;
    private int ano;
    private String placa;
    private boolean temBauDeEntrega;
}
