package br.edu.infnet.divinomatheus.presentation;

import br.edu.infnet.divinomatheus.domain.entities.Moto;
import br.edu.infnet.divinomatheus.domain.usecases.moto.MotoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("motos")
public class MotoController {
    @Autowired
    private MotoUseCase motoUseCase;

    @GetMapping("/listar")
    List<Moto> listaMotos() {
        return this.motoUseCase.obterLista();
    }
}
