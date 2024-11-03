package br.edu.infnet.divinomatheus.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "motos")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Moto {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private String id;
    private String modelo;
    private int ano;
    private String placa;
}
