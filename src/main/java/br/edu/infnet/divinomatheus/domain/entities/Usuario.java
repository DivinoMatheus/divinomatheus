package br.edu.infnet.divinomatheus.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Usuario {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private String id;

    @NotBlank(message = "É preciso fornecer um CPF")
    @NotNull(message = "O CPF não pode ser vazio")
    private String cpf;

    @NotBlank(message = "É preciso fornecer um nome")
    @NotNull(message = "O nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "É preciso fornecer um sobrenome")
    @NotNull(message = "O sobrenome não pode ser vazio")
    private String sobrenome;

    @NotBlank(message = "É preciso fornecer um email")
    @NotNull(message = "O email não pode ser vazio")
    private String email;

    @NotBlank(message = "É preciso fornecer um telefone")
    @NotNull(message = "O telefone não pode ser vazio")
    private String telefone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataDeNascimento;

    @PrePersist
    void onCreate() {
        if (this.getId() == null) {
            this.setId(String.valueOf(UUID.randomUUID()));
        }
    }
}
