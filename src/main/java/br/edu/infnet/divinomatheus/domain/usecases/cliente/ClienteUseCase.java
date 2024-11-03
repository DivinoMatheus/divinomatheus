package br.edu.infnet.divinomatheus.domain.usecases.cliente;

import br.edu.infnet.divinomatheus.domain.entities.Cliente;

import java.util.List;

public interface ClienteUseCase {
    public void cadastra(Cliente cliente);

    public Cliente obterPorCpf(String cpf);

    public List<Cliente> obterLista();
}
