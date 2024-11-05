package br.edu.infnet.divinomatheus.domain.usecases.endereco;

import br.edu.infnet.divinomatheus.domain.entities.Endereco;

public interface EnderecoUseCase {
    void cadastra(Endereco endereco);
    Endereco obterPorId(String id);
}
