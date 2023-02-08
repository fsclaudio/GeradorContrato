package com.cfs.gerador.contrato.dtos;

import com.cfs.gerador.contrato.entities.Contratante;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contrato_ContratanteDTO {
    private Long id;
    private String razao_Social_Contratante;

    public  Contrato_ContratanteDTO(Contratante entity){
        this.id = entity.getId();
        this.razao_Social_Contratante = entity.getRazao_Social_Contratante();
    }
}
