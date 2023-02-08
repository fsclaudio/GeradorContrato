package com.cfs.gerador.contrato.repositories;

import com.cfs.gerador.contrato.entities.Contratante;
import com.cfs.gerador.contrato.entities.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratanteRepository extends JpaRepository<Contratante,Long> {
}
