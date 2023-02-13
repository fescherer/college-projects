create database Livraria;

use Livraria;

create table Autor (
	Codigo int(3) primary key auto_increment,
	Nome varchar (50) not null
);

INSERT autor VALUES 
	(0, "Paulo Coelho"),
	(0, "J. K. Rowling"),
	(0, "Jo Soares"),
	(0, "Para Leigos"),
	(0, "Use a cabeca");

create table livro (
	Numero int(3) primary key auto_increment,
	Titulo varchar (30) not null,
	Preco decimal (6,2) not null,
	AutorCodigo int(3) not null,
	foreign key(AutorCodigo) references Autor(Codigo)
);

INSERT livro VALUES 
	(0, "Diario de um mago", 29.00, 1),
	(0, "Veronika decide morrer", 19.00, 1),
	(0, "Adestramento", 45.00, 4),
	(0, "Assassinatos na ABL", 69.00, 3),
	(0, "Psicologia", 35.00, 4),
	(0, "Harry Potter 1", 49.00, 2),
	(0, "O alquimista", 29.00, 1),
	(0, "Onze minutos", 19.00, 1),
	(0, "Brida", 29.00, 1),
	(0, "Harry Potter 3", 49.00, 3),
	(0, "C#", 120.00, 5),
	(0, "O homem que matou G V", 69.00, 3),
	(0, "Harry Potter 4", 49.00, 2),
	(0, "A bruxa de Portobello", 29.00, 1),
	(0, "C++", 100.00, 5),
	(0, "O monte cinco", 9.00, 1),
	(0, "Motivacao", 25.00, 4),
	(0, "Harry Potter 2", 49.00, 2),
	(0, "Harry Potter 1", 49.00, 2),
	(0, "MySql", 99.00, 5),
	(0, "Sherlock Holmes", 69.00, 3),
	(0, "O xango de bazer street", 70.00, 3),
	(0, "Estatistica", 75.00, 4),
	(0, "Grego", 35.00, 4),
	(0, "R", 88.00, 5),
	(0, "Violao", 35.00, 4),
	(0, "PMP", 120.00, 5),
	(0, "Java", 150.00, 5),
	(0, "Oficce 2007", 120.00, 4);


# B) Desenvolva uma VIEW (vw_consulta2) que ordene o nome dos livros de A a Z.
CREATE VIEW vw_consulta2 AS
 SELECT * FROM livro
 ORDER BY livro.Titulo;

SELECT * FROM vw_consulta2;

# C) Desenvolva uma VIEW (vw_preco1) para que retorne além do nome do livro e autor, o preço de cada livro.
CREATE VIEW vw_preco1 AS
 SELECT livro.Titulo, autor.Nome AS "Nome do Autor", livro.Preco 
 FROM Livro INNER JOIN Autor
 ON livro.AutorCodigo = autor.Codigo;

SELECT * from vw_preco1;

# D) Desenvolva uma VIEW (vw_preco2) para que exiba o nome do livro e preço, somente dos livros correspondentes do autor para leigos.
CREATE VIEW vw_preco2 AS
 SELECT Livro.Titulo, livro.Preco, autor.Nome AS "Nome do autor"
 FROM Livro INNER JOIN Autor 
 ON Livro.AutorCodigo = autor.Codigo
 AND AutorCodigo = 4;

SELECT * FROM vw_preco2;

# E) Delete a VIEW (vw_consulta2)
DROP VIEW vw_consulta2;

# F) Tente usar a view (vw_consulta2). Qual a mensagem que retorna?
SELECT * FROM vw_consulta2;
#Tabela não existe

/*----------------------------------------------------*/
DROP DATABASE Livraria;

/****************************************************************************************************************************************************************/
#Exercício 1

create database LimeCar;
use LimeCar;

create table Fabricante(
	Codigo int(3) primary key auto_increment, 
	Marca char(20)not null
	);

INSERT Fabricante VALUES
(0,"Volkswagen"),
(0,"Fiat"),
(0,"Chevrolet"),
(0,"Ford"),
(0,"Audi"),
(0,"Hyundai");

create table Veiculo(
	RENAVAN int(8) primary key,
	Nome varchar(30)not null,
	Cor varchar(20)not null,
	Preco decimal(10,2)not null,
	FabricanteCod int(3)not null,
	foreign key(FabricanteCod)references Fabricante(Codigo)
	);

INSERT Veiculo VALUES
(95195195,"Gol","preto",18000.00,1),
(01234567,"Corsa","azul",15000.00,3),
(02589967,"Idea","prata",44000.00,2),
(12345678,"A3","prata",44000.00,5),
(87654321,"Golf","azul",32000.00,1),
(04445566,"A5","azul",80000.00,5),
(78889994,"Jetta","prata",55000.00,1),
(11122255,"S10","preto",33000.00,3),
(36544477,"Linea","prata",35000.00,2),
(77889966,"Montana","preto",32000.00,3),
(55220044,"Fiesta","branco",25000.00,4),
(01444558,"Ka","verde",49000.00,4),
(10102020,"Saveiro","preto",22000.00,1),
(30303030,"Strada","preto",27000.00,2),
(11111111,"SpaceFox","amarelo",39000.00,1),
(22222222,"Siena","preto",18000.00,2),
(33333333,"Spin","preto",40000.00,3),
(44444444,"Spin","prata",38000.00,3),
(55555555,"Uno","vermelho",12000.00,2),
(66666666,"Ka","preto",19000.00,4),
(77777777,"A1","preto",49000.00,5),
(88888888,"Captiva","preto",62000.00,3),
(99999999,"EcoSport","preto",49000.00,4),
(32132132,"A8","branco",90000.00,5),
(12312312,"Corsa","rosa",18000.00,3),
(45645645,"Idea","branco",42000.00,2),
(65465465,"A3","verde",54000.00,5),
(78978998,"Golf","dourado",82000.00,1),
(98798798,"A5","blindado",40000.00,5),
(14714714,"Jetta","prata",45000.00,1),
(74174174,"S10","azul",23000.00,3),
(85285285,"Linea","amarelo",55000.00,2),
(02582582,"Montana","lilas",62000.00,3),
(96396396,"Fiesta","marrom",25000.00,4);

#Realize as tarefas:

# A) Desenvolva uma View chamada “vw_MarcaNome”, que retorne o nome das marcas e o nome de cada veiculo.
CREATE VIEW vw_MarcaNome AS
 SELECT Fabricante.Marca, Veiculo.Nome
 FROM Fabricante INNER JOIN Veiculo
 ON Fabricante.Codigo = Veiculo.FabricanteCod;

# B) Teste a view “vw_MarcaNome”.
SELECT * FROM vw_MarcaNome;

# C) Altere a view “vw_MarcaNome”, somente retornando os carros da marca Audi. Efetue um teste
ALTER VIEW vw_MarcaNome AS
 SELECT Fabricante.Marca, Veiculo.Nome
 FROM Fabricante INNER JOIN Veiculo
 ON Fabricante.Codigo = Veiculo.FabricanteCod
 AND Fabricante.Codigo = 5; 

SELECT * FROM vw_MarcaNome;

# D) Desenvolva uma nova view que retorne o nome do veiculo e preço dos veículos. (escolha o nome da view)
CREATE VIEW vw_NomePreco AS
 SELECT Nome, Preco
 FROM Veiculo;

SELECT * FROM vw_NomePreco;

# E) Teste a view desenvolvida na questão ‘”d”, com veículos acima de R$ 70.000,00. Sem alterar a view.
SELECT * FROM vw_NomePreco WHERE vw_NomePreco.Preco > 70000; 

# F) Desenvolva uma View chamada “vw_SemVeiculo”, que retorne as marcas, que não possuem veículos cadastrados. *(Somente na aula de subselect)
CREATE VIEW vw_SemVeiculo AS
 SELECT Fabricante.Marca FROM Fabricante
 WHERE Fabricante.Codigo NOT IN (
 	SELECT FabricanteCod FROM Veiculo
 	);

SELECT * FROM vw_SemVeiculo;

# G) Desenvolva uma View chamada “vw_MarcaCor”, que retorne o nome do veiculo, a cor do veiculo e a marca. Ordene a pesquisa em ordem crescente, tomando como base os nomes dos veículos.
CREATE VIEW vw_MarcaCor AS
 SELECT Veiculo.Nome, Veiculo.Cor, Fabricante.Marca
 FROM Veiculo INNER JOIN Fabricante 
 ON Veiculo.FabricanteCod = Fabricante.Codigo
 ORDER BY Veiculo.Nome ASC;

SELECT * FROM vw_MarcaCor;

/*----------------------------------------------------*/
DROP DATABASE LimeCar;

/****************************************************************************************************************************************************************/
#Exercício 2

/*A lanchonete da UNIP de Limeira, necessita de um banco de dados para cadastrar o estoque dos produtos comercializados. Conforme pode ser observado nas Figuras a seguir: */
/*--------------------------------As tabelas fui eu que fiz, então elas devem ser consideradas respostas tbm------------------------------------*/
CREATE DATABASE Lanchonete;
USE Lanchonete;

CREATE TABLE Marca(
	ID int(3) PRIMARY KEY AUTO_INCREMENT ,
	Nome varchar(30) NOT NULL
); 

INSERT Marca VALUES
	(0, "Nestle"),
	(0, "Ambev"),
	(0, "Caseiro");

CREATE TABLE Produto(
	Codigo int(3) PRIMARY KEY AUTO_INCREMENT,
	Nome varchar(30) NOT NULL,
	Validade date NOT NULL,
	MarcaID int(3),
	FOREIGN KEY (MarcaID) REFERENCES Marca(ID)
	);

INSERT Produto VALUES
	(0, "Chocolate Prestígio", "2018-12-15", 1),
	(0, "Pacote Bolacha", "2018-12-30", 1),
	(0, "Nescau Prontinho", "2019-01-01", 1),
	(0, "Guaraná Antartica", "2022-05-05", 2),
	(0, "Pepsi", "2022-05-05", 2),
	(0, "Coxinha", "2018-08-29", 3),
	(0, "Lanche Natural", "2018-08-19", 3),
	(0, "Trufa", "2018-08-26", 3);

CREATE TABLE Financeiro(
	Numero int(3) PRIMARY KEY AUTO_INCREMENT,
	VL_Compra decimal(3,2) NOT NULL,
	Qnt int(3) NOT NULL,
	ProdutoCod int(3),
	FOREIGN KEY (ProdutoCod) REFERENCES Produto(Codigo)
);

INSERT Financeiro VALUES
	(0, 1.60, 30, 1),
	(0, 1.99, 10, 2),
	(0, 1.50, 50, 3),
	(0, 2.00, 30, 4),
	(0, 2.00, 30, 5),
	(0, 2.00, 15, 6),
	(0, 3.50, 15, 7),
	(0, 3.00, 15, 8);

# Realize as seguintes tarefas:

# A) Desenvolva uma view que selecione o nome dos produtos, a data de vencimento, a marca.
CREATE VIEW vw_NomeDataMarca AS
 SELECT Produto.Nome AS "Nome do Produto", Produto.Validade, Marca.Nome AS "Nome da Marca"
 FROM Produto INNER JOIN Marca ON Produto.MarcaID = Marca.ID;

SELECT * FROM vw_NomeDataMarca;

# B) Utilize a view desenvolvida na questão “a”. Porém somente com os produtos com prazo de vencimento no ano de 2018 devem ser exibidos.
ALTER VIEW vw_NomeDataMarca AS
 SELECT Produto.Nome AS "Nome do Produto", Produto.Validade, Marca.Nome AS "Nome da Marca"
 FROM Produto INNER JOIN Marca ON Produto.MarcaID = Marca.ID WHERE Produto.Validade LIKE "2018%";

SELECT * FROM vw_NomeDataMarca; 

# C) Desenvolva uma view que retorne a marca, o nome do produto, e o total gasto com cada produto (qtd * Vl_compra).
CREATE VIEW vw_MarcaNomeVT AS
 SELECT Marca.Nome AS "Nome Marca", Produto.Nome AS "Nome Produto", (Financeiro.Qnt * Financeiro.Vl_compra) AS "TOTAL"
 FROM Financeiro INNER JOIN Produto ON Financeiro.ProdutoCod = Produto.Codigo
 INNER JOIN Marca ON Produto.MarcaID = Marca.ID;

# D) Utilize a view desenvolvida na questão “c”.
SELECT * FROM vw_MarcaNomeVT;

# E) Desenvolva uma view que demonstre o nome do produto, a quantidade, o valor de venda de cada produto (60% de lucro), e o lucro unitário.
CREATE VIEW vw_NomeQntValorLucro AS
 SELECT Produto.Nome, Financeiro.Qnt, (Financeiro.Vl_compra * 1.60) AS "Valor de Venda", ((Financeiro.VL_Compra * 1.60) - Financeiro.VL_Compra) AS "Lucro Unitário"
 FROM Financeiro INNER JOIN Produto ON Financeiro.ProdutoCod = Produto.Codigo;

# F) Utilize a view desenvolvida na questão “e”.
SELECT * FROM vw_NomeQntValorLucro;

# G) Delete a view desenvolvida na questão “a”.
DROP VIEW vw_NomeDataMarca;

# H) Exiba todas as views desenvolvidas.
SHOW TABLES;

# I) Com as views desenvolvidas, se todos os produtos forem vendidos, qual será o lucro total da lanchonete?
SELECT SUM(Financeiro.Qnt * ((Financeiro.VL_Compra * 1.60) - Financeiro.VL_Compra)) AS "Lucro Total" FROM Financeiro;

/*----------------------------------------------------*/
DROP DATABASE Lanchonete;