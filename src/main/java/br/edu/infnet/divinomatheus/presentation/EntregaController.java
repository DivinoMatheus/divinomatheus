package br.edu.infnet.divinomatheus.presentation;

import br.edu.infnet.divinomatheus.domain.entities.Entrega;
import br.edu.infnet.divinomatheus.domain.usecases.entrega.EntregaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("entregas")
public class EntregaController {
    @Autowired
    private EntregaUseCase entregaUseCase;

    @PostMapping(value = "/cadastrar", consumes = {"application/json"})
    public void cadastraEntrega(@RequestBody Entrega entrega) {
        entregaUseCase.cadastra(entrega);
    }

    @GetMapping("/listar")
    public List<Entrega> listarEntregas() {
        return entregaUseCase.obterLista();
    }
}
