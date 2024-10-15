package br.edu.infnet.divinomatheus.presentation;

import br.edu.infnet.divinomatheus.domain.entities.Motorista;
import br.edu.infnet.divinomatheus.domain.usecases.motorista.MotoristaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController()
@RequestMapping("motoristas")
public class MotoristaController {
    @Autowired
    private MotoristaUseCase motoristaUseCase;

    @PostMapping("")
    public void cadastraMotorista(@RequestBody Motorista motorista) {
        motoristaUseCase.cadastra(motorista);
    }

    @GetMapping("/{cpf}")
    public Motorista buscaMotoristaPorCpf(@PathVariable String cpf) {
        var motorista = motoristaUseCase.buscaPorCpf(cpf);

        if (motorista == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Motorista não encontrado");
        }

        return motorista;
    }

    @GetMapping()
    public List<Motorista> listaMotoristas() {
        var motoristas = motoristaUseCase.listaMotoristas();

        return motoristas;
    }
}
