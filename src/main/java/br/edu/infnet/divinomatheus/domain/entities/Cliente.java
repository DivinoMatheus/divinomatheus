package br.edu.infnet.divinomatheus.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Cliente extends Usuario {
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "remetente_id")
    // @JsonManagedReference
    private List<Entrega> envios;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "destinatario_id")
    // @JsonManagedReference
    private List<Entrega> recebimentos;
}
