package br.edu.infnet.divinomatheus.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
    private String titulo;
    private String descricao;
    private int pesoEmKg;
}
