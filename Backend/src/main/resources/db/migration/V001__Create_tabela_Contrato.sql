CREATE TABLE IF NOT EXISTS contrato (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    razao_Social_Contratada varchar(250),
    nome_Fantasia_Contratada varchar(250),
    Cnpj_Contratada varchar(9),
    logradouro_Contratada varchar(200),
    bairro_Contratada varchar(100),
    cidade_Contratada varchar(120),
    estado_Contratada varchar(2),
    cep_Contratada varchar(8),
    faturamento_Contratada float,
    numero_Lojas int,
    razao_Social_Contratante varchar(250),
    nome_Fantasia_Contratante varchar(250),
    Cnpj_Contratante varchar(9),
    logradouro_Contratante varchar(200),
    bairro_Contratante varchar(100),
    cidade_Contratante varchar(120),
    estado_Contratante varchar(2),
    cep_Contratante varchar(8),
    data_Abertura DATE,
    data_Termino DATE,
    valor float,
    numero_Parcelas int,
    Dia_Vencimento_Parcela int,
    valor_Parcela float,
    valor_Parcela_Loja float);