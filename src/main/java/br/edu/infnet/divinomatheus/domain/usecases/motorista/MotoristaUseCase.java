package br.edu.infnet.divinomatheus.domain.usecases.motorista;

import br.edu.infnet.divinomatheus.domain.entities.Motorista;

import java.util.List;

public interface MotoristaUseCase {
    public void cadastra(Motorista motorista);
    public Motorista buscaPorCpf(String cpf);
    public List<Motorista> listaMotoristas();
}
