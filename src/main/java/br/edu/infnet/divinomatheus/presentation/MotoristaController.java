package br.edu.infnet.divinomatheus.presentation;

import br.edu.infnet.divinomatheus.domain.entities.Motorista;
import br.edu.infnet.divinomatheus.domain.usecases.motorista.MotoristaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("usuarios/motoristas")
public class MotoristaController {
    @Autowired
    private MotoristaUseCase motoristaUseCase;

    @PostMapping()
    public void cadastraMotorista(@RequestBody Motorista motorista) {
        motoristaUseCase.cadastra(motorista);
    }

    @GetMapping("/{cpf}")
    public Motorista buscaMotoristaPorCpf(@PathVariable String cpf) {
        return this.motoristaUseCase.obterPorCpf(cpf);
    }

    @GetMapping("/listar")
    public List<Motorista> listaMotoristas() {
        return motoristaUseCase.obterLista();
    }
}
