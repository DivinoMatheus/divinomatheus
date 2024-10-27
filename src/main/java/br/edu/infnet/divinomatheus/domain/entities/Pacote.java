package br.edu.infnet.divinomatheus.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

// @Entity
// @Table(name = "pacotes")
@Getter
@Setter
public class Pacote {
    private String conteudo;
    private int largura;
    private int comprimento;
    private int altura;
    private int pesoEmKg;
}
