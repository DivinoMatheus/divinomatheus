package br.edu.infnet.divinomatheus.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "enderecos")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {
    @Id
    private String id;
    private String cep;
    private String bairro;
    private String rua;
    private String estado;
    private String complemento;
    private int numero;

    @PrePersist
    void onCreate() {
        if (this.getId() == null) {
            this.setId(String.valueOf(UUID.randomUUID()));
        }
    }
}
