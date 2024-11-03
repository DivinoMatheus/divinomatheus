package br.edu.infnet.divinomatheus.domain.interfaces;

import br.edu.infnet.divinomatheus.domain.entities.MotoEletrica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoEletricaRepository extends JpaRepository<MotoEletrica, String> {
}
