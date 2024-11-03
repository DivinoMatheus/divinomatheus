package br.edu.infnet.divinomatheus.domain.usecases.usuario;

import br.edu.infnet.divinomatheus.domain.entities.Usuario;

import java.util.List;

public interface UsuarioUseCase {
    List<Usuario> obterLista();
    Usuario obterPorCpf(String cpf);
}
