package br.edu.infnet.divinomatheus.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pacote {
    private String conteudo;
    private int largura;
    private int comprimento;
    private int altura;
    private int pesoEmKg;
}
