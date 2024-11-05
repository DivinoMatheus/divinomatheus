package br.edu.infnet.divinomatheus.externals.loaders;

import br.edu.infnet.divinomatheus.domain.entities.Endereco;
import br.edu.infnet.divinomatheus.domain.entities.Pacote;
import br.edu.infnet.divinomatheus.domain.usecases.pacote.PacoteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class PacotesLoader {
    @Autowired
    private PacoteUseCase pacoteUseCase;

    public void run() throws Exception {
        FileReader fileReader = new FileReader("files/pacotes.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linha = bufferedReader.readLine();

        System.out.println("[PacotesLoader] Cadastro de pacotes");

        while (linha != null) {
            System.out.println(linha);

            String[] campos = linha.split(";");

            var pacote = new Pacote();

            pacote.setConteudo(campos[0]);
            pacote.setPesoEmKg(Double.parseDouble(campos[1]));
            pacote.setLargura(Integer.parseInt(campos[2]));
            pacote.setComprimento(Integer.parseInt(campos[3]));
            pacote.setAltura(Integer.parseInt(campos[4]));
            pacote.setId(campos[5]);

            pacoteUseCase.cadastra(pacote);

            linha = bufferedReader.readLine();
        }
    }
}
