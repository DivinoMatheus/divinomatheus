package br.edu.infnet.divinomatheus.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "entregas")
@Getter
@Setter
public class Entrega {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private String id;

    @OneToOne()
    @JoinColumn(name = "id_pacote")
    private Pacote pacote;

    @ManyToOne()
    @JoinColumn(name = "id_origem")
    private Endereco enderecoOrigem;

    @ManyToOne()
    @JoinColumn(name = "id_destino")
    private Endereco enderecoDestino;

    private float precoTotal;
    private float precoLiquido;
    private float taxaDeServico;
    private int minutosEstimados;
    private Date enviadoAs;
    private Date recebidoAs;

    @ManyToOne
    @JoinColumn(name = "remetente_id")
    @JsonBackReference
    private Cliente remetente;

    @ManyToOne
    @JoinColumn(name = "destinatario_id")
    @JsonBackReference
    private Cliente destinatario;
}
