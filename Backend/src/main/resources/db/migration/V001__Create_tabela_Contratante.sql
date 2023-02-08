CREATE TABLE IF NOT EXISTS contratante (

    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    razao_Social_Contratante varchar(250),
    nome_Fantasia_Contratante varchar(250),
    Cnpj_Contratante varchar(9),
    logradouro_Contratante varchar(200),
    bairro_Contratante varchar(100),
    cidade_Contratante varchar(120),
    estado_Contratante varchar(2),
    cep_Contratante varchar(8));
