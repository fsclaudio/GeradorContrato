CREATE TABLE IF NOT EXISTS contrato (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Contratante_id int ,
    Contratada_id int,
    valor float,
    data_Abertura date,
    data_Termino date,
    numero_Parcelas int,
    numero_Lojas int,
    Dia_Vencimento_Parcela int,
    valor_Parcela float,
    valor_Parcela_Loja float);

    alter table contrato add constraint fk_contrato_contratada foreign key (Contratada_id) references contratada (id);
    alter table contrato add constraint fk_contrato_contratante foreign key (Contratante_id) references contratante (id);