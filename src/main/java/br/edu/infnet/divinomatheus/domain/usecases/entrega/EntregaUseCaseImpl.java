package br.edu.infnet.divinomatheus.domain.usecases.entrega;

import br.edu.infnet.divinomatheus.domain.entities.Entrega;
import br.edu.infnet.divinomatheus.domain.interfaces.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntregaUseCaseImpl implements EntregaUseCase {
    @Autowired
    private EntregaRepository entregaRepository;

    public void cadastra(Entrega entrega) {
        entregaRepository.save(entrega);
    }

    @Override
    public List<Entrega> obterLista() {
        return entregaRepository.findAll();
    }
}
