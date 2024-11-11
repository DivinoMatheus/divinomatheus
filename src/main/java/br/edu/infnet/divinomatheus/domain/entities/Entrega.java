package br.edu.infnet.divinomatheus.domain.entities;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.core.util.Json;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "entregas")
@Getter
@Setter
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
    @JsonIgnore
    private Cliente remetente;

    @ManyToOne
    @JoinColumn(name = "destinatario_id")
    @JsonIgnore
    private Cliente destinatario;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    @JsonIgnore
    private Motorista motorista;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String destinatarioCpf;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull
    private String remetenteCpf;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull
    private String motoristaCpf;
}
