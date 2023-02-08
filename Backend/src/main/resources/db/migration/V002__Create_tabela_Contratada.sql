CREATE TABLE IF NOT EXISTS contratada (
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
    numero_Lojas int);