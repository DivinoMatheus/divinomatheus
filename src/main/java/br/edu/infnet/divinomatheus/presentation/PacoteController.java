package br.edu.infnet.divinomatheus.presentation;

import br.edu.infnet.divinomatheus.domain.entities.Pacote;
import br.edu.infnet.divinomatheus.domain.usecases.pacote.PacoteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pacotes")
public class PacoteController {

    @Autowired
    PacoteUseCase pacoteUseCase;

    @GetMapping("/listar")
    ResponseEntity<List<Pacote>> listarPacotes() {
        return ResponseEntity.status(HttpStatus.OK).body(pacoteUseCase.obterLista());
    }
}
