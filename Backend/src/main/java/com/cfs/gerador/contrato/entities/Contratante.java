package com.cfs.gerador.contrato.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "contratante")
public class Contratante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String razao_Social_Contratante;
    private String nome_Fantasia_Contratante;
    private String Cnpj_Contratante;
    private String logradouro_Contratante;
    private String bairro_Contratante;
    private String cidade_Contratante;
    private String estado_Contratante;
    private String cep_Contratante;

    @OneToMany
    @JoinColumn(name = "contratante_id")
    private List<Contrato> contratos;
}
