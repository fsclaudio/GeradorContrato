package com.cfs.gerador.contrato.dtos;

import com.cfs.gerador.contrato.entities.Contratada;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContratadaDTO {
    private Long id;
    private String razao_Social_Contratada;
    private String nome_Fantasia_Contratada;
    private String Cnpj_Contratada;
    private String logradouro_Contratada;
    private String bairro_Contratada;
    private String cidade_Contratada;
    private String estado_Contratada;
    private String cep_Contratada;
    private float faturamento_Contratada;
    private int numero_Lojas;

    public ContratadaDTO(Contratada entity){
        this.id = entity.getId();
        this.razao_Social_Contratada = entity.getRazao_Social_Contratada();
        this.nome_Fantasia_Contratada = entity.getNome_Fantasia_Contratada();
        this.Cnpj_Contratada = entity.getCnpj_Contratada();
        this.logradouro_Contratada = entity.getLogradouro_Contratada();
        this.bairro_Contratada = entity.getBairro_Contratada();
        this.cidade_Contratada = entity.getCidade_Contratada();
        this.estado_Contratada = entity.getEstado_Contratada();
        this.cep_Contratada = entity.getCep_Contratada();
        this.faturamento_Contratada = getFaturamento_Contratada();
        this.numero_Lojas = entity.getNumero_Lojas();
    }
}
