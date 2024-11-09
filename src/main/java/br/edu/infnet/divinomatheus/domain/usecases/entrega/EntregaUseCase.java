package br.edu.infnet.divinomatheus.domain.usecases.entrega;

import br.edu.infnet.divinomatheus.domain.entities.Entrega;

import java.util.List;

public interface EntregaUseCase {
    void cadastra(Entrega entrega);
    List<Entrega> obterLista();
}
