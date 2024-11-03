package br.edu.infnet.divinomatheus.domain.usecases.cliente;

import br.edu.infnet.divinomatheus.domain.entities.Cliente;
import br.edu.infnet.divinomatheus.domain.interfaces.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteUseCaseImpl implements ClienteUseCase{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void cadastra(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Cliente obterPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    public List<Cliente> obterLista() {
        return clienteRepository.findAll();
    }
}
