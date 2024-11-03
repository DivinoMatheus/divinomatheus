package br.edu.infnet.divinomatheus.domain.usecases.moto;

import br.edu.infnet.divinomatheus.domain.entities.Moto;

import java.util.List;

public interface MotoUseCase {
    List<Moto> obterLista();
    Moto obterPorPlaca(String placa);
}
