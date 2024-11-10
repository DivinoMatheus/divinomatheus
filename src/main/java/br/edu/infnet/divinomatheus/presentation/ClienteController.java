package br.edu.infnet.divinomatheus.presentation;

import br.edu.infnet.divinomatheus.domain.entities.Cliente;
import br.edu.infnet.divinomatheus.domain.usecases.cliente.ClienteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController()
@RequestMapping("usuarios/clientes")
public class ClienteController {
    @Autowired
    private ClienteUseCase clienteUseCase;

    @PostMapping()
    public void cadastraCliente(@RequestBody Cliente cliente) {
        clienteUseCase.cadastra(cliente);
    }

    @GetMapping("/{cpf}")
    public Cliente buscaClientePorCpf(@PathVariable String cpf) {
        return this.clienteUseCase.obterPorCpf(cpf);
    }

    @GetMapping("/listar")
    public List<Cliente> listaClientes() {
        return clienteUseCase.obterLista();
    }
}
