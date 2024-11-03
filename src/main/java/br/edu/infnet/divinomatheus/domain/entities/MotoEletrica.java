package br.edu.infnet.divinomatheus.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "motos_eletricas")
@Getter
@Setter
public class MotoEletrica extends Moto {
    private int bateriaMaximaAh;
}
