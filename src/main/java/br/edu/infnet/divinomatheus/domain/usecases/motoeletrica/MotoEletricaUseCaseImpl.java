package br.edu.infnet.divinomatheus.domain.usecases.motoeletrica;

import br.edu.infnet.divinomatheus.domain.entities.MotoEletrica;
import br.edu.infnet.divinomatheus.domain.interfaces.MotoEletricaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoEletricaUseCaseImpl implements MotoEletricaUseCase {
    @Autowired
    private MotoEletricaRepository motoEletricaRepository;

    public void cadastra(MotoEletrica motoEletrica) {
        this.motoEletricaRepository.save(motoEletrica);
    }

    public List<MotoEletrica> obterLista() {
        return this.motoEletricaRepository.findAll();
    }
}
