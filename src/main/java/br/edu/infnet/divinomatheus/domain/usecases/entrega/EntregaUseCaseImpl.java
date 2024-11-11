package br.edu.infnet.divinomatheus.domain.usecases.entrega;

import br.edu.infnet.divinomatheus.domain.entities.Entrega;
import br.edu.infnet.divinomatheus.domain.entities.Motorista;
import br.edu.infnet.divinomatheus.domain.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntregaUseCaseImpl implements EntregaUseCase {
    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PacoteRepository pacoteRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private CepClient cepClient;

    public void cadastra(Entrega entrega) {
        var enderecoDestino = entrega.getEnderecoDestino();
        var enderecoOrigem = entrega.getEnderecoOrigem();
        var pacote = entrega.getPacote();
        var motoristaCpf = entrega.getMotoristaCpf();
        var destinatarioCpf = entrega.getDestinatarioCpf();
        var remetenteCpf = entrega.getRemetenteCpf();

        if (entrega.getEnderecoDestino().getId() == null) {
            var cep = entrega.getEnderecoDestino().getCep();
            var enderecoPorCep = cepClient.buscaPorCep(cep);

            enderecoDestino.setBairro(enderecoPorCep.getBairro());
            enderecoDestino.setComplemento(enderecoPorCep.getComplemento());
            enderecoDestino.setEstado(enderecoPorCep.getUf());
            enderecoDestino.setRua(enderecoPorCep.getLogradouro());

            enderecoRepository.save(enderecoDestino);
        }

        if (entrega.getEnderecoOrigem().getId() == null) {
            var cep = entrega.getEnderecoOrigem().getCep();
            var enderecoPorCep = cepClient.buscaPorCep(cep);

            enderecoOrigem.setBairro(enderecoPorCep.getBairro());
            enderecoOrigem.setComplemento(enderecoPorCep.getComplemento());
            enderecoOrigem.setEstado(enderecoPorCep.getUf());
            enderecoOrigem.setRua(enderecoPorCep.getLogradouro());

            enderecoRepository.save(enderecoOrigem);
        }

        if (pacote.getId() == null) {
            pacoteRepository.save(pacote);
        }

        if (destinatarioCpf != null) {
            var clientePorCpf = clienteRepository.findByCpf(destinatarioCpf);
            entrega.setDestinatario(clientePorCpf);
        }

        if (remetenteCpf != null) {
            var clientePorCpf = clienteRepository.findByCpf(remetenteCpf);
            entrega.setRemetente(clientePorCpf);
        }

        if (motoristaCpf != null) {
            var motoristaPorCpf = motoristaRepository.findByCpf(motoristaCpf);
            entrega.setMotorista(motoristaPorCpf);
        }

        entregaRepository.save(entrega);
    }

    @Override
    public List<Entrega> obterLista() {
        return entregaRepository.findAll();
    }

    public List<Entrega> obterListaPorPrecoTotal(Long min, Long max) {
        return entregaRepository.findByPrecoTotalBetween(min, max);
    }
}
