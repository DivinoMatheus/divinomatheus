package br.edu.infnet.divinomatheus.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
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
    private String conteudo;
    private int largura;
    private int comprimento;
    private int altura;
    private Double pesoEmKg;

    @PrePersist
    void onCreate() {
        if (this.getId() == null) {
            this.setId(String.valueOf(UUID.randomUUID()));
        }
    }
}
