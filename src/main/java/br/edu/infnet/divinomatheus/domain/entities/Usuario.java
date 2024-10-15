package br.edu.infnet.divinomatheus.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class Usuario {
    private String cpf;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private Date dataDeNascimento;
}
