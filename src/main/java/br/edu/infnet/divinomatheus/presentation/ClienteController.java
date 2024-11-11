package br.edu.infnet.divinomatheus.presentation;

import br.edu.infnet.divinomatheus.domain.entities.Cliente;
import br.edu.infnet.divinomatheus.domain.usecases.cliente.ClienteUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("usuarios/clientes")
public class ClienteController {
    @Autowired
    private ClienteUseCase clienteUseCase;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastraCliente(@Valid @RequestBody Cliente cliente) {
        clienteUseCase.cadastra(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso");
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> buscaClientePorCpf(@PathVariable String cpf) {
        var cliente = this.clienteUseCase.obterPorCpf(cpf);

        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cliente);
        }

        return ResponseEntity.status(HttpStatus.OK).body(this.clienteUseCase.obterPorCpf(cpf));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listaClientes() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteUseCase.obterLista());
    }
}
