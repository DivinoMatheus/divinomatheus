package br.edu.infnet.divinomatheus.domain.usecases.endereco;

import br.edu.infnet.divinomatheus.domain.entities.Endereco;
import br.edu.infnet.divinomatheus.domain.interfaces.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoUseCaseImpl implements EnderecoUseCase {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public void cadastra(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public Endereco obterPorId(String id) {
        return enderecoRepository.findById(id).get();
    }
}
