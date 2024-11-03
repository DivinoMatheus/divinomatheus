package br.edu.infnet.divinomatheus.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "motoristas")
@Getter
@Setter
public class Motorista extends Usuario {
    private boolean temBauDeEntrega;

    @OneToOne
    @JoinColumn(name = "moto_id")
    private Moto moto;
}
