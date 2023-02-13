/*Aula do dia 01/09/2020*/

/*Exercício 1-Exemplos da aula*/
CREATE DATABASE sorveteria;

USE sorveteria;

create table Sorvete(
	Id int(3) zerofill primary key auto_increment,
	Nome varchar(25) not null,
	Cobertura varchar(20) not null,
	Preco decimal(6,2) not null,
	Fabricante varchar(20) not null
	);

 insert sorvete values(0,"chocolate","cobertura simples",2.50,"Geladao"),
 	(0,"creme","cobertura simples",2.50,"Congela"),
 	(0,"Limao","sem cobertura",2.00,"Frutz"),
 	(0,"Pitanga","sem cobertura",2.00,"Frutz"),
 	(0,"crocante","cobertura simples",2.50,"Geladao"),
 	(0,"creme holandes","cobertura simples",2.50,"Congela"),
 	(0,"Laranja","sem cobertura",2.00,"Frutz"),
 	(0,"Uva","sem cobertura",2.00,"Frutz"),
 	(0,"Skimo","cobertura simples",3.50,"Geladao"),
 	(0,"Cascao","cobertura simples",3.50,"Congela"),
 	(0,"Abacaxi","sem cobertura",2.00,"Frutz"),
 	(0,"Kiwi","sem cobertura",2.00,"Frutz"),
 	(0,"Moranguete","cobertura simples",3.00,"Geladao"),
 	(0,"Queijo","cobertura simples",2.50,"Congela"),
 	(0,"Uvaia","sem cobertura",2.00,"Frutz"),
 	(0,"Umbu","sem cobertura",2.00,"Frutz"),
 	(0,"Cornetao","cobertura simples",3.50,"Congela"),
 	(0,"Groselha","sem cobertura",2.00,"Frutz"),
 	(0,"Papaya","sem cobertura",2.00,"Frutz"),
 	(0,"Leite Condensado","cobertura simples",2.50,"Geladao");

/*Exercicio 1.0- De um update para que o sorvete com o nome de Limao troque para Limão Suiço*/
 	UPDATE Sorvete 
 	SET Nome = "Limão suiço"
 	WHERE Nome = "Limao";

/*OU*/

 	UPDATE Sorvete 
 	SET Nome = "Limão suiço"
 	WHERE Id = "3";

/*Exercício 1.1- De um update para que os sorvetes com nome de Cornetao e os que têm fabricante Frutz troquem de preço para 1.99*/
 	UPDATE Sorvete
 	SET Preco = 1.99
 	WHERE Nome = "Cornetao" OR
 	Fabricante = "Frutz";

/*Exercício 1.2- De um update para que os sorvetes da fabricante Congela tenham seu preço diminuido em 18%*/
 	UPDATE Sorvete
 	SET Preco = preco * 0.82
 	WHERE Fabricante = "Congela";

 /*----------------------------------*/
 DROP DATABASE sorveteria;

/****************************************************************************************************************************************************************/
 /*Exercício 2*/
Create database Loja;

Use Loja;

create table produtos(
	Cod int(3) zerofill primary key auto_increment,
	Nome varchar(20) not null, 
	Preco decimal(6,2) not null, 
	Localizacao varchar(20) not null default "Gondola"
	);


insert produtos values
	(0, "lanterna", 5.99, "ferramentas"),
	(0, "bolacha", 1.99, "alimentos"),
	(0, "lixeira", 9.99, "casa"),
	(0, "carrinho", 2.99, "brinquedos"),
	(0, "cera", 2.99, "automoveis"),
	(0, "talheres", 5.99, "casa"),
	(0, "Danone", 1.99, "alimentos"),
	(0, "Massinha", 1.99, "brinquedos"),
	(0, "bolo", 5.99, "alimentos"),
	(0, "Jogo de Copo", 39.99, "casa"),
	(0, "Boneca Baby", 10.99, "brinquedos"),
	(0, "Vela", 15.99, "automoveis"),
	(0, "Toalha de mesa", 9.99, "casa"),
	(0, "Chiclete", 1.49, "alimentos"),
	(0, "Avião Controle", 99.99, "brinquedos");

/*Exercício 2.0 - Altere o preço da lixeira para R$5,99.*/
	UPDATE produtos
	SET Preco = 5.99
	WHERE Cod = 3;

	SELECT * FROM produtos;

/*Exercício 2.1 - Aumente os preços de todos os produtos em R$1,00,comum a única instrução UPDATE.*/
	UPDATE produtos
	SET Preco = preco + 1;

	SELECT * FROM produtos;

/*Exercício 2.2 - Altere o valor dos talheres com 10% de desconto.*/
	UPDATE produtos
	SET Preco = preco * 0.90
	WHERE Cod = 6;

	SELECT * FROM produtos;

/*Exercício 2.3 - Altere o nome da localização de brinquedos para infantil.*/
	UPDATE produtos
	SET Localizacao = "Infantil"
	WHERE Localizacao = "brinquedos"; 

	SELECT * FROM produtos;

/*Exercício 2.4 - Aumente em R$0,01 o valor dos alimentos, com exceção do Danone.*/
	UPDATE produtos
	SET Preco = preco + 0.01
	WHERE Localizacao = "alimentos" AND
	Nome <> "Danone"; /*Também é possível usar != */

	SELECT * FROM produtos;


/*----------------------------------------------------*/
DROP DATABASE Loja;

/****************************************************************************************************************************************************************/
#Exercício Extra

/*(Adaptado Siberschatz, 2010–Pág.77, exercício 3.10) Considere o BD relacional a seguir: 

	Agencia(Id,Nome,Cidade)
	Funcionario(Matricula,Nome,Cargo,Salario,Agencia_Id)

	Forneça uma expressão em SQL para cada uma das seguintes consultas:
	a) Cadastre 2 agências bancária. 
	b) Cadastre 5 funcionários como cargo e salário a sua escolha.
	c) Cadastre 1 gerente por agência, como salário de R$5.000,00.
	d) Dê um aumento de 10% a todos os funcionários do banco ( menos para os gerentes).
	e) Dê um aumento de 5% para os gerentes do banco.
	f) Modifique o cargo de um dos gerentes para diretor.
	g) Atualize o salário do diretor para R$6.250,00.
	h) Selecione o nome, e o salário dos funcionários com vencimento abaixo de R$2.000,00.
	i) Selecione a matricula dos funcionários, nome dos funcionários e Cidade da agência, dos colaboradores que recebam salário acima de R$3.000,00. (Não obrigatório)*/

CREATE DATABASE ex2;

USE ex2;

CREATE TABLE Agencia (
	ID int(3) ZEROFILL PRIMARY KEY AUTO_INCREMENT,
	Nome varchar(25) NOT NULL,
	Cidade varchar(25) NOT NULL
);

CREATE TABLE Funcionario (
	Matricula int(3) ZEROFILL PRIMARY KEY AUTO_INCREMENT,
	Nome varchar(25) NOT NULL,
	Cargo varchar(25) NOT NULL,
	Salario decimal(6,2) NOT NULL,
	Agencia_ID_FK int(3) NOT NULL,
	FOREIGN KEY (Agencia_ID_FK) REFERENCES Agencia(ID)
);

/*a) Cadastre 2 agências bancária. */
INSERT Agencia(Nome, Cidade) VALUES
	("Primeiro de Maio", "Campinas"),
	("Segundo de Agosto", "Itatiba");

/*b)Cadastre 5 funcionários como cargo e salário a sua escolha.*/
INSERT Funcionario(Nome, Cargo, Salario, Agencia_ID_FK) VALUES
	("Jeca Valente", "Programador", 3000.00, 1),
	("Armando Guerra", "Recursos Humanos", 2500.00, 1),
	("Maria Alencar", "Programador", 1800.00, 1),
	("Heloisa Jones", "Programador", 4000.00, 2),
	("Gabriel Davis", "Recursos Humanos", 3700.00, 2)
	;

/*c) Cadastre 1 gerente por agência, como salário de R$5.000,00.*/
INSERT Funcionario(Nome, Cargo, Salario, Agencia_ID_FK) VALUES
	("Gustavo Lima", "Gerente", 5000.00, 1),
	("Ednaldo Pereira", "Gerente", 5000.00, 2)
	;

/*d) Dê um aumento de 10% a todos os funcionários do banco (menos para os gerentes).*/
UPDATE Funcionario
SET Salario = Salario * 1.10
WHERE Cargo <> "Gerente";

/*e) Dê um aumento de 5% para os gerentes do banco.*/
UPDATE Funcionario
SET Salario = Salario * 1.05
WHERE Cargo = "Gerente";

/*f) Modifique o cargo de um dos gerentes para diretor.*/
UPDATE Funcionario
SET Cargo = "Diretor" 
WHERE Cargo = "Gerente" AND Matricula = 6;

/*g) Atualize o salário do diretor para R$6.250,00.*/
UPDATE Funcionario
SET Salario = 6250.00
WHERE Cargo = "Diretor" AND Matricula = 6;

/*h) Selecione o nome, e o salário dos funcionários com vencimento abaixo de R$2.000,00.*/
SELECT Nome, Salario FROM Funcionario WHERE Salario < 2000.00;

/*i) Selecione a matricula dos funcionários, nome dos funcionários e Cidade da agência, dos colaboradores que recebam salário acima de R$3.000,00. (Não obrigatório)*/
SELECT Funcionario.Matricula, Funcionario.Nome, Agencia.Cidade FROM Funcionario INNER JOIN Agencia ON Agencia.ID = Funcionario.Agencia_ID_FK AND Funcionario.Salario > 3000;

/*--------------------------------------------------------------------------------------------------*/

DROP DATABASE ex2;