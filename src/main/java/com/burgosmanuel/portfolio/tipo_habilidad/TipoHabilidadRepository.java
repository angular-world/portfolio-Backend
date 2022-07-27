package com.burgosmanuel.portfolio.tipo_habilidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoHabilidadRepository extends JpaRepository<TipoHabilidad, Integer>{
    
}
