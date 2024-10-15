package br.edu.infnet.divinomatheus.domain.usecases.motorista;

import br.edu.infnet.divinomatheus.domain.entities.Motorista;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MotoristaUseCaseImpl implements MotoristaUseCase {
    private final Map<String, Motorista> motoristas = new HashMap<String, Motorista>();

    @Override
    public void cadastra(Motorista motorista) {
        motoristas.put(motorista.getCpf(), motorista);
    }

    @Override
    public Motorista buscaPorCpf(String cpf) {
        return motoristas.get(cpf);
    }

    @Override
    public List<Motorista> listaMotoristas() {
        return motoristas.values().stream().toList();
    }
}
