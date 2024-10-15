package br.edu.infnet.divinomatheus.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Motorista extends Usuario {
    private Moto moto;
    private boolean temBauDeEntrega;
}
