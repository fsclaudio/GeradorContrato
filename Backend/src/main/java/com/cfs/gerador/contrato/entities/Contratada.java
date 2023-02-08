package com.cfs.gerador.contrato.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "contratada")
public class Contratada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany
    @JoinColumn(name = "contratada_id")
    private List<Contrato> contratos;
}
