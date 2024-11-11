package br.edu.infnet.divinomatheus.domain.usecases.pacote;

import br.edu.infnet.divinomatheus.domain.entities.Pacote;
import br.edu.infnet.divinomatheus.domain.interfaces.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacoteUseCaseImpl implements PacoteUseCase {
    @Autowired
    private PacoteRepository pacoteRepository;

    public void cadastra(Pacote pacote){
        pacoteRepository.save(pacote);
    }

    public Pacote obterPorId(String id) {
        return pacoteRepository.findById(id).get();
    }

    public List<Pacote> obterLista() {
        return pacoteRepository.findAll();
    }
}
