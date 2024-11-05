package br.edu.infnet.divinomatheus.domain.interfaces;

import br.edu.infnet.divinomatheus.domain.entities.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacoteRepository extends JpaRepository<Pacote, String> {
}
