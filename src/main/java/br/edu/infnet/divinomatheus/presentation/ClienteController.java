package br.edu.infnet.divinomatheus.presentation;

import br.edu.infnet.divinomatheus.domain.entities.Cliente;
import br.edu.infnet.divinomatheus.domain.usecases.cliente.ClienteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController()
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private ClienteUseCase clienteUseCase;

    @PostMapping()
    public void cadastraCliente(@RequestBody Cliente cliente) {
        clienteUseCase.cadastra(cliente);
    }

    @GetMapping("/{cpf}")
    public Cliente buscaClientePorCpf(@PathVariable String cpf) {
        var cliente = clienteUseCase.buscaPorCpf(cpf);

        if (cliente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }

        return cliente;
    }

    @GetMapping()
    public List<Cliente> listaClientes() {
        var clientes = clienteUseCase.listaClientes();

        return clientes;
    }
}
