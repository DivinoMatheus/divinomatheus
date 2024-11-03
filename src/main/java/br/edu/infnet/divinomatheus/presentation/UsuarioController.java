package br.edu.infnet.divinomatheus.presentation;

import br.edu.infnet.divinomatheus.domain.entities.Usuario;
import br.edu.infnet.divinomatheus.domain.usecases.usuario.UsuarioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping()
    public List<Usuario> listaUsuarios() {
        return usuarioUseCase.obterLista();
    }

    @GetMapping("/{cpf}")
    public Usuario buscaUsuariosPorCpf(@PathVariable String cpf) {
        return usuarioUseCase.obterPorCpf(cpf);
    }
}
