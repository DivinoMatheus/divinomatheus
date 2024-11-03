package br.edu.infnet.divinomatheus.domain.interfaces;

import br.edu.infnet.divinomatheus.domain.entities.MotoCombustao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoCombustaoRepository extends JpaRepository<MotoCombustao, String> {
}
