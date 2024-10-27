package br.edu.infnet.divinomatheus.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;


@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Usuario {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private String id;
    private String cpf;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private Date dataDeNascimento;
}
