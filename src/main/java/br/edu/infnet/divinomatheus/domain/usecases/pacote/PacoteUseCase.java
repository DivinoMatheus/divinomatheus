package br.edu.infnet.divinomatheus.domain.usecases.pacote;

import br.edu.infnet.divinomatheus.domain.entities.Pacote;

import java.util.List;

public interface PacoteUseCase {
    void cadastra(Pacote pacote);
    Pacote obterPorId(String id);
    List<Pacote> obterLista();
}
