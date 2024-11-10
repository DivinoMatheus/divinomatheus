package br.edu.infnet.divinomatheus.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "entregas")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private Date enviadoAs;
    private Date recebidoAs;

    @ManyToOne
    @JoinColumn(name = "remetente_id")
    private Cliente remetente;

    @ManyToOne
    @JoinColumn(name = "destinatario_id")
    private Cliente destinatario;
}
