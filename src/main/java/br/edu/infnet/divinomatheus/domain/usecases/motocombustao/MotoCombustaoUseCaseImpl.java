package br.edu.infnet.divinomatheus.domain.usecases.motocombustao;

import br.edu.infnet.divinomatheus.domain.entities.MotoCombustao;
import br.edu.infnet.divinomatheus.domain.interfaces.MotoCombustaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoCombustaoUseCaseImpl implements MotoCombustaoUseCase {
    @Autowired
    private MotoCombustaoRepository motoCombustaoRepository;

    public void cadastra(MotoCombustao motoCombustao) {
        this.motoCombustaoRepository.save(motoCombustao);
    }

    public List<MotoCombustao> obterLista() {
        return this.motoCombustaoRepository.findAll();
    }
}
