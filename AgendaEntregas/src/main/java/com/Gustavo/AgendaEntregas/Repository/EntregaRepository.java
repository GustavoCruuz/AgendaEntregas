package com.Gustavo.AgendaEntregas.Repository;

import com.Gustavo.AgendaEntregas.Model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
