package br.edu.infnet.divinomatheus.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "pacotes")
@Getter
@Setter
public class Pacote {
    @Id
    private String id;

    @NotNull
    @NotBlank(message = "O conteúdo não pode ser vazio")
    private String conteudo;

    @NotNull(message = "Uma largura precisa ser especificada")
    private int largura;

    @NotNull(message = "Um comprimento precisa ser especificado")
    private int comprimento;

    @NotNull(message = "Um altura precisa ser especificado")
    private int altura;

    @NotNull(message = "Um pesoEmKg precisa ser especificado")
    private Double pesoEmKg;

    @PrePersist
    void onCreate() {
        if (this.getId() == null) {
            this.setId(String.valueOf(UUID.randomUUID()));
        }
    }
}
