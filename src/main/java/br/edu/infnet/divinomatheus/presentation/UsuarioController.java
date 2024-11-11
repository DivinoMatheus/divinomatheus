package br.edu.infnet.divinomatheus.presentation;

import br.edu.infnet.divinomatheus.domain.entities.Usuario;
import br.edu.infnet.divinomatheus.domain.usecases.usuario.UsuarioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listaUsuarios() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioUseCase.obterLista());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Usuario> buscaUsuariosPorCpf(@PathVariable String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioUseCase.obterPorCpf(cpf));
    }
}
