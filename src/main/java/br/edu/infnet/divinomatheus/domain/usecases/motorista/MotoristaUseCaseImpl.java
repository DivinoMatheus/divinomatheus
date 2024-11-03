package br.edu.infnet.divinomatheus.domain.usecases.motorista;

import br.edu.infnet.divinomatheus.domain.entities.Motorista;
import br.edu.infnet.divinomatheus.domain.interfaces.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaUseCaseImpl implements MotoristaUseCase {
    @Autowired
    private MotoristaRepository motoristaRepository;

    @Override
    public void cadastra(Motorista motorista) {
        motoristaRepository.save(motorista);
    }

    @Override
    public Motorista obterPorCpf(String cpf) {
        return motoristaRepository.findByCpf(cpf);
    }

    @Override
    public List<Motorista> obterLista() {
        return motoristaRepository.findAll();
    }
}
