package br.edu.infnet.divinomatheus.externals.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Loader implements ApplicationRunner {
    @Autowired
    private UsuariosLoader usuariosLoader;
    @Autowired
    private MotosLoader motosLoader;
    @Autowired
    private EnderecosLoader enderecosLoader;
    @Autowired
    private PacotesLoader pacotesLoader;
    @Autowired
    private EntregasLoader entregasLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        motosLoader.run();
        usuariosLoader.run();
        enderecosLoader.run();
        pacotesLoader.run();
        entregasLoader.run();
    }
}
