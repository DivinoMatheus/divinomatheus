package br.edu.infnet.divinomatheus.domain.usecases.motorista;

import br.edu.infnet.divinomatheus.domain.entities.Motorista;
import br.edu.infnet.divinomatheus.domain.interfaces.MotoCombustaoRepository;
import br.edu.infnet.divinomatheus.domain.interfaces.MotoEletricaRepository;
import br.edu.infnet.divinomatheus.domain.interfaces.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaUseCaseImpl implements MotoristaUseCase {
    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private MotoEletricaRepository motoEletricaRepository;

    @Autowired
    private MotoCombustaoRepository motoCombustaoRepository;

    @Override
    public void cadastra(Motorista motorista) {
        if (motorista.getMotoEletrica() != null && motorista.getMotoEletrica().getId() == null) {
            motorista.setMoto(motoEletricaRepository.save(motorista.getMotoEletrica()));
        } else if (motorista.getMotoCombustao() != null && motorista.getMotoCombustao().getId() == null) {
            motorista.setMoto(motoCombustaoRepository.save(motorista.getMotoCombustao()));
        }

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
