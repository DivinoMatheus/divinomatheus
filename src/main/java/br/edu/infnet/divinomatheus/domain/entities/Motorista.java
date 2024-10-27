package br.edu.infnet.divinomatheus.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "motoristas")
@Getter
@Setter
public class Motorista extends Usuario {
    // private Moto moto;
    private boolean temBauDeEntrega;
}
