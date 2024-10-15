package br.edu.infnet.divinomatheus.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Entrega {
    private Cliente recebedor;
    private Cliente remetente;
    private Pacote pacote;
    private Motorista motorista;
    private float precoTotal;
    private float precoLiquido;
    private float taxaDeServico;
    private int minutosEstimados;
    private Date entregueAs;
    private Date recebidoAs;
}
