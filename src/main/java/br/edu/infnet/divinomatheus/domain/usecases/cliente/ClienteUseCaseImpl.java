package br.edu.infnet.divinomatheus.domain.usecases.cliente;

import br.edu.infnet.divinomatheus.domain.entities.Cliente;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClienteUseCaseImpl implements ClienteUseCase{
    private final Map<String, Cliente> clientes = new HashMap<String, Cliente>();

    @Override
    public void cadastra(Cliente cliente) {
        clientes.put(cliente.getCpf(), cliente);
    }

    public Cliente buscaPorCpf(String cpf) {
        return clientes.get(cpf);
    }

    @Override
    public List<Cliente> listaClientes() {
        return clientes.values().stream().toList();
    }
}
