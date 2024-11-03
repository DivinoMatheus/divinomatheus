package br.edu.infnet.divinomatheus.externals.loaders;

import br.edu.infnet.divinomatheus.domain.entities.Cliente;
import br.edu.infnet.divinomatheus.domain.entities.Moto;
import br.edu.infnet.divinomatheus.domain.entities.Motorista;
import br.edu.infnet.divinomatheus.domain.usecases.cliente.ClienteUseCase;
import br.edu.infnet.divinomatheus.domain.usecases.moto.MotoUseCase;
import br.edu.infnet.divinomatheus.domain.usecases.motorista.MotoristaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;

@Component
public class UsuariosLoader {
    @Autowired private MotoristaUseCase motoristaUseCase;
    @Autowired private ClienteUseCase clienteUseCase;
    @Autowired private MotoUseCase motoUseCase;

    public void run() throws Exception {
        FileReader fileReader = new FileReader("files/usuarios.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linha = bufferedReader.readLine();

        System.out.println("[UsuariosLoader] Cadastro de usuários:");

        while(linha != null) {
            System.out.println(linha);

            String[] campos = linha.split(";");
            String tipo = campos[0].toUpperCase();
            var sourceFormat = new SimpleDateFormat("dd/MM/yyyy");

            switch(tipo) {
                case "C":
                    var cliente = new Cliente();
                    cliente.setCpf(campos[1]);
                    cliente.setEmail(campos[2]);
                    cliente.setNome(campos[3]);
                    cliente.setSobrenome(campos[4]);
                    cliente.setTelefone(campos[5]);
                    cliente.setDataDeNascimento(sourceFormat.parse(campos[6]));

                    clienteUseCase.cadastra(cliente);

                    break;

                case "M":
                    var motorista = new Motorista();
                    motorista.setCpf(campos[1]);
                    motorista.setEmail(campos[2]);
                    motorista.setNome(campos[3]);
                    motorista.setSobrenome(campos[4]);
                    motorista.setTelefone(campos[5]);
                    motorista.setDataDeNascimento(sourceFormat.parse(campos[6]));
                    motorista.setTemBauDeEntrega(Boolean.parseBoolean(campos[7]));

                    Moto moto = motoUseCase.obterPorPlaca(campos[8]);

                    motorista.setMoto(moto);
                    motoristaUseCase.cadastra(motorista);

                    break;
            }

            linha = bufferedReader.readLine();
        }
    }
}
