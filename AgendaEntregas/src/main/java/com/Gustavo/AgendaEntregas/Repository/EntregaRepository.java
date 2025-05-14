package com.Gustavo.AgendaEntregas.Repository;

import com.Gustavo.AgendaEntregas.Model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Entrega p SET p.finalizada = true WHERE p.id =:id")
    void finalizarEntrega(@Param("id") Long id);
}
