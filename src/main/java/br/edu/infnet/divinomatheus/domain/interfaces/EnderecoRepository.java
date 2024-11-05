package br.edu.infnet.divinomatheus.domain.interfaces;

import br.edu.infnet.divinomatheus.domain.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
