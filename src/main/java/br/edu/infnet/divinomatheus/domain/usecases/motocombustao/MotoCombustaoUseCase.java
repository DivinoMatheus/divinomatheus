package br.edu.infnet.divinomatheus.domain.usecases.motocombustao;

import br.edu.infnet.divinomatheus.domain.entities.MotoCombustao;

import java.util.List;

public interface MotoCombustaoUseCase {
    void cadastra(MotoCombustao motoCombustao);
    List<MotoCombustao> obterLista();
}
