package br.edu.infnet.divinomatheus.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

// @Entity
// @Table(name = "motos_combustao")
@Getter
@Setter
public class MotoACombustao extends Moto {
    private int tamanhoDoTanqueLitros;
}
