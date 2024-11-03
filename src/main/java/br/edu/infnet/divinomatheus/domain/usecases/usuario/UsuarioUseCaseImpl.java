package br.edu.infnet.divinomatheus.domain.usecases.usuario;

import br.edu.infnet.divinomatheus.domain.entities.Usuario;
import br.edu.infnet.divinomatheus.domain.interfaces.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class UsuarioUseCaseImpl implements UsuarioUseCase {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> obterLista() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obterPorCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf);
    }
}
