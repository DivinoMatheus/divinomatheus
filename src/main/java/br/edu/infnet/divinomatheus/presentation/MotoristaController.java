package br.edu.infnet.divinomatheus.presentation;

import br.edu.infnet.divinomatheus.domain.entities.Motorista;
import br.edu.infnet.divinomatheus.domain.usecases.motorista.MotoristaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("usuarios/motoristas")
public class MotoristaController {
    @Autowired
    private MotoristaUseCase motoristaUseCase;

    @PostMapping("")
    public void cadastraMotorista(@RequestBody Motorista motorista) {
        motoristaUseCase.cadastra(motorista);
    }
}
