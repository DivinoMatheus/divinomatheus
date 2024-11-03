package br.edu.infnet.divinomatheus.externals.loaders;

import br.edu.infnet.divinomatheus.domain.entities.*;
import br.edu.infnet.divinomatheus.domain.usecases.motocombustao.MotoCombustaoUseCase;
import br.edu.infnet.divinomatheus.domain.usecases.motoeletrica.MotoEletricaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class MotosLoader {
    @Autowired private MotoEletricaUseCase motoEletricaUseCase;
    @Autowired private MotoCombustaoUseCase motoCombustaoUseCase;

    public void run() throws Exception {
        FileReader fileReader = new FileReader("files/motos.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linha = bufferedReader.readLine();

        System.out.println("[MotosLoader] Cadastro de motos:");

        while (linha != null) {
            System.out.println(linha);

            String[] campos = linha.split(";");
            String tipo = campos[0].toUpperCase();

            switch (tipo) {
                case "MTE":
                    var motoEletrica = new MotoEletrica();
                    motoEletrica.setModelo(campos[1]);
                    motoEletrica.setAno(Integer.parseInt(campos[2]));
                    motoEletrica.setPlaca(campos[3]);
                    motoEletrica.setBateriaMaximaAh(Integer.parseInt(campos[4]));

                    motoEletricaUseCase.cadastra(motoEletrica);

                    break;

                case "MTC":
                    var motoCombustao = new MotoCombustao();
                    motoCombustao.setModelo(campos[1]);
                    motoCombustao.setAno(Integer.parseInt(campos[2]));
                    motoCombustao.setPlaca(campos[3]);
                    motoCombustao.setTamanhoDoTanqueLitros(Integer.parseInt(campos[4]));

                    motoCombustaoUseCase.cadastra(motoCombustao);

                    break;
            }

            linha = bufferedReader.readLine();
        }
    }
}
