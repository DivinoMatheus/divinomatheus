package br.edu.infnet.divinomatheus.presentation;

import br.edu.infnet.divinomatheus.domain.entities.Entrega;
import br.edu.infnet.divinomatheus.domain.usecases.entrega.EntregaUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("entregas")
public class EntregaController {
    @Autowired
    private EntregaUseCase entregaUseCase;

    @PostMapping(value = "/cadastrar", consumes = {"application/json"})
    public ResponseEntity<String> cadastraEntrega(@Valid @RequestBody Entrega entrega) {
        entregaUseCase.cadastra(entrega);

        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso");
    }

    @GetMapping("/filtrarPorPrecoTotal")
    public ResponseEntity<List<Entrega>> listarEntregasPorPrecoTotal(
            @RequestParam("min") Long min,
            @RequestParam("max") Long max
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(entregaUseCase.obterListaPorPrecoTotal(min, max));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Entrega>> listarEntregas() {
        return ResponseEntity.status(HttpStatus.OK).body(entregaUseCase.obterLista());
    }
}
