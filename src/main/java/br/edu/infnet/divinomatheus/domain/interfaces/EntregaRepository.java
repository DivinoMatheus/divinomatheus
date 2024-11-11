package br.edu.infnet.divinomatheus.domain.interfaces;

import br.edu.infnet.divinomatheus.domain.entities.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntregaRepository extends JpaRepository<Entrega, String> {
    List<Entrega> findByPrecoTotalBetween(Long precoInitial, Long precoFinal);
}
