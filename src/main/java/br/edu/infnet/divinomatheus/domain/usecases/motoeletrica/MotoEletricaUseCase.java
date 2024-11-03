package br.edu.infnet.divinomatheus.domain.usecases.motoeletrica;

import br.edu.infnet.divinomatheus.domain.entities.MotoEletrica;

import java.util.List;

public interface MotoEletricaUseCase {
    void cadastra(MotoEletrica motoEletrica);
    List<MotoEletrica> obterLista();
}
