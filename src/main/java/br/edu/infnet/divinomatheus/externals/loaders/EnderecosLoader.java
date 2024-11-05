package br.edu.infnet.divinomatheus.externals.loaders;

import br.edu.infnet.divinomatheus.domain.entities.Endereco;
import br.edu.infnet.divinomatheus.domain.usecases.endereco.EnderecoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class EnderecosLoader {
    @Autowired
    private EnderecoUseCase enderecoUseCase;

    public void run() throws Exception {
        FileReader fileReader = new FileReader("files/enderecos.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linha = bufferedReader.readLine();

        System.out.println("[EnderecosLoader] Cadastro de endereços");

        while (linha != null) {
            System.out.println(linha);

            String[] campos = linha.split(";");

            var endereco = new Endereco();

            endereco.setCep(campos[0]);
            endereco.setBairro(campos[1]);
            endereco.setRua(campos[2]);
            endereco.setEstado(campos[3]);
            endereco.setComplemento(campos[4]);
            endereco.setNumero(Integer.parseInt(campos[5]));
            endereco.setId(campos[6]);

            enderecoUseCase.cadastra(endereco);

            linha = bufferedReader.readLine();
        }
    }
}
