package com.cfs.gerador.contrato.repositories;

import com.cfs.gerador.contrato.entities.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato,Long> {
}
