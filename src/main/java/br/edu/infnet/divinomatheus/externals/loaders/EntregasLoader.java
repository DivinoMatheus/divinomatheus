package br.edu.infnet.divinomatheus.externals.loaders;

import br.edu.infnet.divinomatheus.domain.entities.Entrega;
import br.edu.infnet.divinomatheus.domain.interfaces.ClienteRepository;
import br.edu.infnet.divinomatheus.domain.usecases.endereco.EnderecoUseCase;
import br.edu.infnet.divinomatheus.domain.usecases.entrega.EntregaUseCase;
import br.edu.infnet.divinomatheus.domain.usecases.pacote.PacoteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Component
public class EntregasLoader {
    @Autowired
    private EntregaUseCase entregaUseCase;
    @Autowired
    private EnderecoUseCase enderecoUseCase;
    @Autowired
    private PacoteUseCase pacoteUseCase;
    @Autowired
    private ClienteRepository clienteRepository;

    public void run() throws Exception {
        FileReader fileReader = new FileReader("files/entregas.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linha = bufferedReader.readLine();

        System.out.println("[EntregasLoader] Cadastro de entregas");

        while (linha != null) {
            System.out.println(linha);

            String[] campos = linha.split(";");

            var pacote = pacoteUseCase.obterPorId(campos[0]);
            var enderecoDestino = enderecoUseCase.obterPorId(campos[1]);
            var enderecoOrigem = enderecoUseCase.obterPorId(campos[2]);
            var destinatario = clienteRepository.findByCpf(campos[8]);
            var remetente = clienteRepository.findByCpf(campos[9]);

            var entrega = new Entrega();

            var dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            dateFormatter.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
            
            entrega.setPacote(pacote);
            entrega.setEnderecoOrigem(enderecoOrigem);
            entrega.setEnderecoDestino(enderecoDestino);
            entrega.setPrecoTotal(Integer.parseInt(campos[3]));
            entrega.setPrecoLiquido(Integer.parseInt(campos[4]));
            entrega.setTaxaDeServico(Integer.parseInt(campos[5]));
            entrega.setEnviadoAs(dateFormatter.parse(campos[6]));
            entrega.setRecebidoAs(dateFormatter.parse(campos[7]));
            entrega.setDestinatario(destinatario);
            entrega.setRemetente(remetente);

            entregaUseCase.cadastra(entrega);

            linha = bufferedReader.readLine();
        }
    }
}
