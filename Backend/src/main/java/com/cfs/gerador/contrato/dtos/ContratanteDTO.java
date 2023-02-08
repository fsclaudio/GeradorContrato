package com.cfs.gerador.contrato.dtos;

import com.cfs.gerador.contrato.entities.Contratante;
import com.cfs.gerador.contrato.entities.Contratante;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContratanteDTO {
    private Long id;
    private String razao_Social_Contratante;
    private String nome_Fantasia_Contratante;
    private String Cnpj_Contratante;
    private String logradouro_Contratante;
    private String bairro_Contratante;
    private String cidade_Contratante;
    private String estado_Contratante;
    private String cep_Contratante;

    public ContratanteDTO(Contratante entity){
        this.id = entity.getId();
        this.razao_Social_Contratante = entity.getRazao_Social_Contratante();
        this.nome_Fantasia_Contratante = entity.getNome_Fantasia_Contratante();
        this.Cnpj_Contratante = entity.getCnpj_Contratante();
        this.logradouro_Contratante = entity.getLogradouro_Contratante();
        this.bairro_Contratante = entity.getBairro_Contratante();
        this.cidade_Contratante = entity.getCidade_Contratante();
        this.estado_Contratante = entity.getEstado_Contratante();
        this.cep_Contratante = entity.getCep_Contratante();
    }
}
