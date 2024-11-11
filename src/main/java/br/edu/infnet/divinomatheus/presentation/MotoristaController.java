package br.edu.infnet.divinomatheus.presentation;

import br.edu.infnet.divinomatheus.domain.entities.Motorista;
import br.edu.infnet.divinomatheus.domain.usecases.motorista.MotoristaUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("usuarios/motoristas")
public class MotoristaController {
    @Autowired
    private MotoristaUseCase motoristaUseCase;


    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastraMotorista(@Valid @RequestBody Motorista motorista) {
        motoristaUseCase.cadastra(motorista);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso");
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Motorista> buscaMotoristaPorCpf(@PathVariable String cpf) {
        var motorista = this.motoristaUseCase.obterPorCpf(cpf);

        if (motorista == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(motorista);
        }

        return ResponseEntity.status(HttpStatus.OK).body(this.motoristaUseCase.obterPorCpf(cpf));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Motorista>> listaMotoristas() {
        return ResponseEntity.status(HttpStatus.OK).body(motoristaUseCase.obterLista());
    }
}
