package br.edu.infnet.divinomatheus.presentation;

import br.edu.infnet.divinomatheus.domain.entities.Moto;
import br.edu.infnet.divinomatheus.domain.entities.MotoCombustao;
import br.edu.infnet.divinomatheus.domain.entities.MotoEletrica;
import br.edu.infnet.divinomatheus.domain.usecases.moto.MotoUseCase;
import br.edu.infnet.divinomatheus.domain.usecases.motocombustao.MotoCombustaoUseCase;
import br.edu.infnet.divinomatheus.domain.usecases.motoeletrica.MotoEletricaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("motos")
public class MotoController {
    @Autowired
    private MotoUseCase motoUseCase;

    @Autowired
    private MotoEletricaUseCase motoEletricaUseCase;

    @Autowired
    private MotoCombustaoUseCase motoCombustaoUseCase;

    @GetMapping("/listar")
    ResponseEntity<List<Moto>> listaMotos() {
        return ResponseEntity.status(HttpStatus.OK).body(this.motoUseCase.obterLista());
    }

    @PostMapping("/eletricas/cadastrar")
    ResponseEntity<String> cadastraMotoEletrica(@RequestBody MotoEletrica motoEletrica) {
        motoEletricaUseCase.cadastra(motoEletrica);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado com sucesso");
    }

    @GetMapping("/eletricas/listar")
    ResponseEntity<List<MotoEletrica>> listaMotosEletricas() {
        return ResponseEntity.status(HttpStatus.OK).body(motoEletricaUseCase.obterLista());
    }

    @GetMapping("/combustao/listar")
    ResponseEntity<List<MotoCombustao>> listaMotosCombustao() {
        return ResponseEntity.status(HttpStatus.OK).body(motoCombustaoUseCase.obterLista());
    }
}
