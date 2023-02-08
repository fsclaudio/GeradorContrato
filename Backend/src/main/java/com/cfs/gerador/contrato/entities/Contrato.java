package com.cfs.gerador.contrato.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numeroLojas;
    private Date dataAbertura;
    private Date dataTermino;
    private float valor;
    private int numeroParcelas;
    private int diaVencimentoParcela;
    private float valorParcela ;
    private float valorParcelaLoja;

    @ManyToOne
    private Contratada contratada;

    @ManyToOne
    private Contratante contratante;
}
