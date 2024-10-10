package br.edu.infnet.divinomatheus.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Entrega {
    private Recebedor recebedor;
    private Remetente remetente;
    private Produto produto;
    private Motorista motorista;
    private float precoTotal;
    private float precoLiquido;
    private float taxaDeServico;
    private int minutosEstimados;
    private Date entregueAs;
    private Date recebidoAs;
}
