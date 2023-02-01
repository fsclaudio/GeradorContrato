package com.cfs.gerador.contrato.dtos;

import com.cfs.gerador.contrato.entities.Contrato;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ContratoDTO {
    private Long id;
    private String razaoSocialContratada;
    private String nomeFantasiaContratada;
    private String CnpjContratada;
    private String logradouroContratada;
    private String bairroContratada;
    private String cidadeContratada;
    private String estadoContratada;
    private String cepContratada;
    private float faturamentoContratada;
    private int numeroLojas;
    private String razaoSocialContratante;
    private String nomeFantasiaContratante;
    private String CnpjContratante;
    private String logradouroContratante;
    private String bairroContratante;
    private String cidadeContratante;
    private String estadoContratante;
    private String cepContratante;
    private Date dataAbertura;
    private Date dataTermino;
    private float valor;
    private int numeroParcelas;
    private int diaVencimentoParcela;
    private float valorParcela ;
    private float valorParcelaLoja;

    public ContratoDTO(){
    }
    public ContratoDTO(Contrato entity){
        this.id = entity.getId();
        this.dataAbertura = entity.getDataAbertura();
        this.dataTermino = entity.getDataTermino();
        this.valor = entity.getValor();
        this.valorParcela = entity.getValorParcela();
        this.numeroParcelas = entity.getNumeroParcelas();
        this.razaoSocialContratada = entity.getRazaoSocialContratada();
        this.nomeFantasiaContratada = entity.getNomeFantasiaContratada();
        this.cepContratada = entity.getCepContratada();
        this.CnpjContratada = entity.getCnpjContratada();
        this.logradouroContratada = entity.getLogradouroContratada();
        this.cidadeContratada = entity.getCidadeContratada();
        this.estadoContratada = entity.getEstadoContratada();
        this.numeroLojas = entity.getNumeroLojas();
        this.faturamentoContratada = entity.getFaturamentoContratada();
        this.bairroContratada = entity.getBairroContratada();
        this.razaoSocialContratante = entity.getRazaoSocialContratante();
        this.nomeFantasiaContratante = entity.getNomeFantasiaContratante();
        this.CnpjContratante = entity.getCnpjContratante();
        this.logradouroContratante = entity.getLogradouroContratante();
        this.bairroContratante = entity.getBairroContratante();
        this.cidadeContratante = entity.getCidadeContratante();
        this.estadoContratante = entity.getEstadoContratante();
        this.cepContratante = entity.getCepContratante();
        this.diaVencimentoParcela = entity.getDiaVencimentoParcela();
        this.valorParcelaLoja = entity.getValorParcelaLoja();
    }
}
