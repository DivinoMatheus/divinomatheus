package br.edu.infnet.divinomatheus.domain.usecases.pacote;

import br.edu.infnet.divinomatheus.domain.entities.Pacote;

public interface PacoteUseCase {
    void cadastra(Pacote pacote);
    Pacote obterPorId(String id);
}
