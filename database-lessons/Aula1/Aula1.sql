/*Aula do dia 25/08/2020*/

/*
1) Uma empresa de segurança necessita de um banco de dados para cadastrar os seguranças, os locais em que presta serviço (clientes), e o material de trabalho (cassetete, rádio comunicador, lanterna e demais materiais). O esquema relacional a seguir foi projetado para esse propósito:
	Seguranca (Matricula, Nome, Cargo,  salario)
	Material (Numero, Tipo, Marca)
	Cliente (CNPJ, Nome, Endereco)
	Escala (Id, Data, SegMatricula, MatNumero, CliCNPJ)

a) Desenvolva os códigos em Sql para:
• Criar um BD chamado Segur;
• Listar os BD;
• Usar o BD;
• Criar as tabelas com suas respectivas chaves (conforme
esquema relacional);
• Escolha os tipos e tamanhos dos atributos;
• Liste as tabelas desenvolvidas no BD;
• Descrever a estrutura das tabelas;
•Adicione uma coluna chamada “email”, na tabela “Cliente”;
• Renomeie o campo “Cargo” para “Função”, na tabela “Seguranca” e adicione o valor default para “Recém contratado”;
• Exclua a coluna chamada “email”, na tabela “Cliente”;
• Renomeie a tabela “Material” para “Materiais”;
• Insira os registros na tabela SEGURANÇA:
• Jonny Ramone, função segurança, Salário 2500,00;
• Serji Tankian, função segurança, Salário 2000,00;
• Corey Taylor, valor default, Salário 973,00;
• Inserir os registros na tabela MATERIAIS:
• Lanterna, Shing Ling;
• Cassetete; Arrebenta;
• Inserir os registros na tabela CLIENTES:
• 00.123.445.685/0001-22, 89fm, Av. Paulista;
• 11.987.654.321/0001-33, Supermercado Extra, Av. Interlagos;
• 11.999.888.777/0001-66, Supermercado Extra, Av. Cupêce;
• Inserir os registros na tabela ESCALA:
• O segurança Jonny Ramone, dia 08/08/2018, na 89fm, com o
material cassetete;
• O funcionário Serji Tankian, dia 09/08/2018, no Supermercado
Extra, com uma lanterna;
*/

/*Criar um BD chamado Segur;*/
CREATE DATABASE Segur;

/*Listar os BD*/
SHOW DATABASES;

/*Usar o BD*/
USE Segur;

/*Criar as tabelas com suas respectivas chaves (conforme esquema relacional)*/
CREATE TABLE Seguranca(

	Matricula int(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	Nome varchar(30) NOT NULL,
	Cargo varchar(15) NOT NULL,
	Salario float(5) NOT NULL
	)ENGINE=InnoDB;

CREATE TABLE Material(
	Numero int(3) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	Tipo varchar(10) NOT NULL,
	Marca varchar(20) NOT NULL
	)ENGINE=InnoDB;

CREATE TABLE Cliente(

	CNPJ varchar(22) NOT NULL PRIMARY KEY,
	Nome varchar(30) NOT NULL,
	Endereco varchar(50) NOT NULL
	)ENGINE=InnoDB;

CREATE TABLE Escala (
	Id int(5) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	Data date NOT NULL,
	Seg_Matricula int(5) NOT NULL,
	Mat_Numero int(3) NOT NULL,
	Cli_CNPJ varchar(22) NOT NULL,
	FOREIGN KEY (Seg_Matricula) REFERENCES Seguranca(Matricula),
	FOREIGN KEY (Mat_Numero) REFERENCES Material(Numero),
	FOREIGN KEY (Cli_CNPJ) REFERENCES Cliente(CNPJ)
	)ENGINE=InnoDB;

/*Liste as tabelas desenvolvidas no BD*/
SHOW TABLES;

/*Descrever a estrutura das tabelas*/
DESC Cliente;

/*Adicione uma coluna chamada “email”, na tabela “Cliente”*/
ALTER TABLE Cliente ADD Email varchar(30) NOT NULL;

/*Renomeie o campo “Cargo” para “Função”, na tabela “Seguranca” e adicione o valor default para “Recém contratado”*/
ALTER TABLE Seguranca CHANGE Cargo Funcao varchar(20) NOT NULL;
ALTER TABLE Seguranca ALTER Funcao SET DEFAULT "Recém Contratado";
DESC Seguranca;

/*Exclua a coluna chamada “email”, na tabela “Cliente”*/
ALTER TABLE Cliente DROP COLUMN Email;
DESC Cliente; 

/*Renomeie a tabela “Material” para “Materiais”*/
ALTER TABLE Material RENAME Materiais;
DESC Materiais;

/*Insira os registros na tabela SEGURANÇA*/
INSERT Seguranca(Nome, Funcao, Salario) VALUES("Jonny Ramone", "segurança", 2500.00);
INSERT Seguranca(Nome, Funcao, Salario) VALUES("Serji Tankian", "segurança", 2000.00);
INSERT Seguranca(Nome, Funcao, Salario) VALUES("Corey Taylor", DEFAULT, 973.00);

/* Inserir os registros na tabela MATERIAIS*/
INSERT Materiais(Tipo, Marca) VALUES("Lanterna", "Shing Ling");
INSERT Materiais(Tipo, Marca) VALUES("Cassetete", "Arrebenta");

/*Inserir os registros na tabela CLIENTES*/
INSERT Cliente(CNPJ, Nome, Endereco) VALUES("00.123.445.685/0001-22", "89fm", "Av. Paulista");
INSERT Cliente(CNPJ, Nome, Endereco) VALUES("11.987.654.321/0001-33", "Supermercado Extra", "Av. Interlagos");
INSERT Cliente(CNPJ, Nome, Endereco) VALUES("11.999.888.777/0001-66", "Supermercado Extra", "Av. Cupêce");

/*Inserir os registros na tabela ESCALA*/
INSERT Escala(Seg_Matricula, Data, Cli_CNPJ, Mat_Numero) VALUES(1, "08-08-2018", "00.123.445.685/0001-22", 2);
INSERT Escala(Seg_Matricula, Data, Cli_CNPJ, Mat_Numero) VALUES(2, "09-08-2018", "11.999.888.777/0001-66", 1);


/*
b)
Realize as seguintes consultas:
• Selecione a média salarial dos seguranças, renomeie como “Media Salarios”.
• Selecione o nome, e o salário, do segurança com maior salário.
• Selecione o nome dos clientes atendidos de forma que não se repitam.
• Selecione todos os campos da tabela segurança, porém os recém contratados não devem ser exibidos.
• Selecione o registro do material da marca Shing Ling.
• Selecione a matricula do segurança que trabalhou na 89fm.
• Selecione o nome e o salário do segurança com salário abaixo de R$ 1500,00.
*/

/*Selecione a média salarial dos seguranças, renomeie como “Media Salarios”*/
SELECT ROUND(AVG(Salario),2) AS "Média Salários" FROM Seguranca;

/*Selecione o nome, e o salário, do segurança com maior salário*/
SELECT Nome, MAX(Salario) AS Salario FROM Seguranca;

/*Selecione o nome dos clientes atendidos de forma que não se repitam*/
SELECT DISTINCT Nome FROM Cliente;

/*Selecione todos os campos da tabela segurança, porém os recém contratados não devem ser exibidos.*/
SELECT * FROM Seguranca WHERE Funcao != "Recém Contratado";

/*Selecione o registro do material da marca Shing Ling*/
SELECT * FROM Materiais WHERE Marca = "Shing Ling";

/*Selecione a matricula do segurança que trabalhou na 89fm*/
SELECT Seguranca.Matricula, Seguranca.Nome FROM Seguranca INNER JOIN Escala ON Escala.Seg_Matricula = Seguranca.Matricula AND Escala.Cli_CNPJ = "00.123.445.685/0001-22";

/*Selecione o nome e o salário do segurança com salário abaixo de R$ 1500,00.*/
SELECT Nome, Salario FROM Seguranca WHERE Salario < 1500;

/*--------------------------------------------------------------------------------------------------*/
DROP DATABASE Segur;