package com.cfs.gerador.contrato.dtos;

import com.cfs.gerador.contrato.entities.Contratada;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contrato_ContratadaDTO {
    private Long id;
    private String razao_Social_Contratada;

    public Contrato_ContratadaDTO(Contratada entity){
        this.id = entity.getId();
        this.razao_Social_Contratada = entity.getRazao_Social_Contratada();
    }
}
