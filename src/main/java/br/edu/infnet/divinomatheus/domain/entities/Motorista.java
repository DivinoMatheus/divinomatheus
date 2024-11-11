package br.edu.infnet.divinomatheus.domain.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "motoristas")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Motorista extends Usuario {
    private boolean temBauDeEntrega;

    @OneToOne
    @JoinColumn(name = "moto_id")
    private Moto moto;

    @Transient
    private MotoEletrica motoEletrica;

    @Transient
    private MotoCombustao motoCombustao;

    @OneToMany
    @JoinColumn(name = "motorista_id")
    private List<Entrega> entregas;
}
