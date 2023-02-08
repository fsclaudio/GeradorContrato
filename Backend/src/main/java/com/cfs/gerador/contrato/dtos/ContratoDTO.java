package com.cfs.gerador.contrato.dtos;

import com.cfs.gerador.contrato.entities.Contratada;
import com.cfs.gerador.contrato.entities.Contrato;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ContratoDTO {
    private Long id;
    private int numeroLojas;
    private Date dataAbertura;
    private Date dataTermino;
    private float valor;
    private int numeroParcelas;
    private int diaVencimentoParcela;
    private float valorParcela ;
    private float valorParcelaLoja;

    private Contrato_ContratadaDTO contratada;
    private Contrato_ContratanteDTO contratante;
    public ContratoDTO(){
    }
    public ContratoDTO(Contrato entity){
        this.id = entity.getId();
        this.dataAbertura = entity.getDataAbertura();
        this.dataTermino = entity.getDataTermino();
        this.valor = entity.getValor();
        this.numeroLojas = entity.getNumeroLojas();
        this.valorParcela = entity.getValorParcela();
        this.numeroParcelas = entity.getNumeroParcelas();
        this.diaVencimentoParcela = entity.getDiaVencimentoParcela();
        this.valorParcelaLoja = entity.getValorParcelaLoja();
        this.contratada = new Contrato_ContratadaDTO(entity.getContratada());
        this.contratante = new Contrato_ContratanteDTO(entity.getContratante());
    }
}
