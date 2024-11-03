package br.edu.infnet.divinomatheus.domain.usecases.moto;

import br.edu.infnet.divinomatheus.domain.entities.Moto;
import br.edu.infnet.divinomatheus.domain.interfaces.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoUseCaseImpl implements MotoUseCase {
    @Autowired
    private MotoRepository motoRepository;

    public List<Moto> obterLista() {
        return motoRepository.findAll();
    }

    public Moto obterPorPlaca(String placa){
        return motoRepository.findByPlaca(placa);
    }
}
