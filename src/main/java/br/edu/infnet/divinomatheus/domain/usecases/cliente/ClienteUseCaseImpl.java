package br.edu.infnet.divinomatheus.domain.usecases.cliente;

import br.edu.infnet.divinomatheus.domain.entities.Cliente;
import br.edu.infnet.divinomatheus.domain.interfaces.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClienteUseCaseImpl implements ClienteUseCase{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void cadastra(Cliente cliente) {
        usuarioRepository.save(cliente);
    }
}
