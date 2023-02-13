CREATE DATABASE Store;

USE Store;

CREATE TABLE Categoria(
	Numero int(3) PRIMARY KEY AUTO_INCREMENT,
	Tipos varchar(20) NOT NULL
	);

CREATE TABLE Produtos(
	ID int(3) PRIMARY KEY AUTO_INCREMENT,
	Nome varchar(25) NOT NULL,
	Preco decimal(6,2) NOT NULL,
	CatNum_FK int(3) NOT NULL,
	FOREIGN KEY(CatNum_FK) REFERENCES Categoria(Numero) 
	);

INSERT Categoria (Tipos) VALUES
	("Livros"),
	("DVD");

INSERT Produtos (Nome, Preco, CatNum_FK) VALUES
	("Novo Mundo", 50.00, 1),
	("Harry Potter", 40.00, 1),
	("Mario", 20.00, 2),
	("Jurassic Park", 40.00, 2);

SELECT Categoria.Tipos, Produtos.Nome, Produtos.Preco 
FROM Categoria INNER JOIN Produtos
ON Produtos.CatNum_FK = Categoria.Numero;

SELECT Categoria.Tipos, Produtos.Nome, Produtos.Preco
FROM Categoria INNER JOIN Produtos
ON Produtos.CatNum_FK = Categoria.Numero
WHERE Categoria.Numero = 1;

/*Exercícios*/

/* 1) Insira duas novas categorias, chamadas “escritório” e “Doces” 
a) Se utilizarmos o JOIN doexemplo, porque não exibi as novas categorias na consulta?*/ 
INSERT Categoria (Tipos) VALUES
	("Escritório"),
	("Doces");
/*Resposta: Porque essas categorias não tem dados relacionados com a tabela Produtos*/


/* 2) Cadastre uma caneta na tabela Produtos. 
a) Porque agora exibiu?*/
INSERT Produtos(Nome, Preco, CatNum_FK) VALUES
	("Caneta", 2.00, 3);
/*Resposta: Porque agora a categoria 3 tem algo em comum com a tabela produtos*/


/* 3) Faça uma consulta que retorne as seguintes colunas, na ordem: Id do Produto, Nome do produto, Preço do produto e Tipo da Categoria*/
SELECT Produtos.ID, Produtos.Preco, Categoria.Tipos
FROM Categoria INNER JOIN Produtos
ON Produtos.CatNum_FK = Categoria.Numero;


/*Mais completo*/
SELECT Produtos.ID, Produtos.Preco, Categoria.Tipos
FROM Categoria INNER JOIN Produtos
ON Produtos.CatNum_FK = Categoria.Numero
WHERE Produtos.Preco < 50
ORDER BY Produtos.Nome ASC;

/* 4) Repare que no comando utilizado no exemplo a consulta LEFT JOIN, relacionou as tabelas Categoria X Produtos. */
SELECT Categoria.*, Produtos.*
FROM Categoria LEFT JOIN Produtos
ON Categoria.Numero = Produtos.CatNum_FK;

/* 4.1) Faça uma consulta utilizando LEFT JOIN, só que agora inverta a relação, ou seja, Produtos X Categoria. LEFT JOIN, relacionou as tabelas Categoria X Produtos. */
SELECT Categoria.*, Produtos.*
FROM Produtos LEFT JOIN Categoria
ON Categoria.Numero = Produtos.CatNum_FK;

/* 4.2) O RIGHT JOIN segue o mesmo raciocínio do LEFT JOIN. Ou seja, retorna a tabela2 inteira, e apenas os registros que coincidem com igualdade do JOIN na Tabela1. */
SELECT Categoria.*, Produtos.*
FROM Categoria RIGHT JOIN Produtos
ON Categoria.Numero = Produtos.CatNum_FK;

/*--------------------------------------------------------------------------------------------------*/

DROP DATABASE Store;
/****************************************************************************************************************************************************************/
/* 5) Com base no script desenvolvido, faça as seleções de dados a seguir*/
Create database LojaMotos;

Use LojaMotos;

Create table Marca(
Codigo int primary key auto_increment,
Nome varchar (30) not null
);

INSERT Marca VALUES 
(0, "Honda"),
(0, "Yamaha"),
(0, "Kawasaki"),
(0, "Suzuki");

Create table Moto(
Chassi int primary key,
Nome varchar(30) not null,
Cor varchar(20) not null,
MarcaCodigo int not null,
foreign key(MarcaCodigo) references Marca(Codigo)
);

INSERT Moto VALUES 
(12356789, "Titan", "Azul", 1),
(321654987, "Twister", "Preta", 1),
(147258369, "Factor", "Prata", 2),
(852258022, "Fazer", "Vermelha", 2),
(996655887, "Ninja 250", "Preta", 3),
(753951254, "Ninja 650", "Preta", 3),
(102030550, "CBR", "Prata", 1),
(805099604, "R1", "Amarela", 2);

create table Cliente(
Numero int(3) primary key auto_increment,
Nome varchar(30) not null,
Celular varchar(13) not null
);

INSERT Cliente VALUES
(0, "Corey Taylor", "(19)988552266"),
(0, "Joey Jordison", "(19)977441122"),
(0, "Paul Gray", "(19)992365417"),
(0, "Shawn Crahan", "(19)998004433"),
(0, "James Root", "(19)920360055"),
(0, "Mick Thomson", "(19)914523688"),
(0, "Sid Wilson", "(19)977553344");

create table Servicos(
Cod int(3) primary key auto_increment,
Nome varchar(30) not null,
Preco decimal (6,2) not null
);

INSERT Servicos VALUES 
(0, "Troca de óleo", 120.00),
(0, "Troca pastilha", 100.00),
(0, "Troca transmissao", 150.00),
(0, "Eletrica", 80.00),
(0, "Troca cabo freio", 50.00),
(0, "Troca cabo do acelerador", 70.00);

create table Produtos(
Numero int(3) primary key auto_increment,
Nome varchar(30) not null,
Preco decimal (6,2) not null
);

INSERT Produtos VALUES 
(0, "Oleo", 30.00),
(0, "Pastilha de freio", 50.00),
(0, "Transmissao", 120.00),
(0, "Fio", 20.00),
(0, "Cabo freio", 25.00),
(0, "Cabo do acelerador", 30.00);

create table Vendas(
Numero int(3) primary key auto_increment,
MotoChassi int not null,
ClieNumero int(3) not null,
ServCod int(3) not null,
ProdNumero int(3) not null,
foreign key (MotoChassi) references Moto(Chassi),
foreign key (ClieNumero) references Cliente(Numero),
foreign key (ServCod) references Servicos(Cod),
foreign key (ProdNumero) references Produtos(Numero)
);

INSERT Vendas VALUES 
(0, 12356789, 1, 2, 2),
(0, 321654987, 2, 4, 4),
(0, 147258369, 3, 6, 6),
(0, 852258022, 6, 1, 1),
(0, 996655887, 7, 3, 3),
(0, 753951254, 5, 5, 3),
(0, 102030550, 4, 2, 2),
(0, 805099604, 3, 3, 3);

/* A) Selecione o nome das motos e a sua respectiva marca, em ordem crescente pelo nome da moto */
SELECT Moto.Nome, Marca.Nome 
FROM Moto INNER JOIN Marca 
WHERE Moto.MarcaCodigo = Marca.Codigo 
ORDER BY Moto.Nome ASC;

/* B) Utilize um JOIN para demonstrar a marca que possui nenhuma moto relacionada. */
SELECT Marca.Nome 
FROM Marca LEFT JOIN Moto ON Moto.MarcaCodigo = Marca.Codigo 
WHERE Moto.MarcaCodigo IS NULL;

/* Outra forma */
SELECT Marca.Nome, Moto.Nome 
FROM Marca LEFT JOIN Moto ON Moto.MarcaCodigo = Marca.Codigo;

/* C) Selecione o nome dos clientes e a sua respectiva moto(nome da moto, e o numero do chassi), ordene a pesquisa em ordem crescente pelo nome do cliente. */
SELECT Cliente.Nome, Moto.Nome, Moto.Chassi 
FROM Vendas INNER JOIN Cliente ON Vendas.ClieNumero = Cliente.Numero 
INNER JOIN Moto On Vendas.MotoChassi = Moto.Chassi 
ORDER BY Cliente.Nome ASC;

/* D) Selecione o nome das motos, chassis, e o produto consumido, somente das motos da marca Honda. */
SELECT Moto.Nome, Moto.Chassi, Produtos.Nome 
FROM Vendas INNER JOIN Moto ON Vendas.MotoChassi = Moto.Chassi 
INNER JOIN Produtos ON Vendas.ProdNumero = Produtos.Numero 
WHERE Moto.MarcaCodigo = 1 
ORDER BY Moto.Chassi ASC;

/* E) Selecione o nome dos clientes, e o total a pagar (produtos + serviços consumidos). Ordene em ordem crescente, como primeiro critério o total a pagar, e o segundo o nome do cliente */ 
SELECT Cliente.Nome, Produtos.Preco + Servicos.Preco AS "Total a pagar" 
FROM Vendas INNER JOIN Cliente ON Vendas.ClieNumero = Cliente.Numero 
INNER JOIN Produtos ON Produtos.Numero = Vendas.ProdNumero 
INNER JOIN Servicos ON Vendas.ServCod = Servicos.Cod 
ORDER BY Produtos.Preco + Servicos.Preco, Cliente.Nome ASC;

/* F) Selecione o nome das motos, que sejam da cor preta OU prata, E da Marca Honda OU Kawasaki. */ 
SELECT Moto.Nome, Moto.Cor 
FROM Moto INNER JOIN Marca ON Moto.MarcaCodigo = Marca.Codigo 
WHERE (MarcaCodigo = 1 OR MarcaCodigo = 3) AND (Moto.Cor = "preta" OR Moto.Cor = "prata") 
ORDER BY Moto.Cor;

/* G) Demonstre o valor médio gasto (produtos + serviços consumidos). */ 
SELECT AVG(Servicos.Preco + Produtos.Preco) AS "Valor Médio Gasto" 
FROM Vendas INNER JOIN Produtos ON Vendas.ProdNumero = Produtos.Numero 
INNER JOIN Servicos ON Vendas.ServCod = Servicos.Cod;

/* H) Selecione o nome do cliente, o número do celular, o nome da moto, somente dos clientes com moto da marca Yamaha. */
SELECT Cliente.Nome AS "Nome do cliente", Cliente.Celular, Moto.Nome AS "Nome da moto" 
FROM Vendas INNER JOIN Cliente ON Vendas.ClieNumero = Cliente.Numero 
INNER JOIN Moto ON Vendas.MotoChassi = Moto.Chassi 
INNER JOIN Marca ON Moto.MarcaCodigo = Marca.Codigo 
WHERE Marca.Codigo = 2;

/* I) Selecione o nome das motos e chassi das motos que trocaram óleo. */
SELECT Moto.Nome, Moto.Chassi 
FROM Vendas INNER JOIN Moto ON Vendas.MotoChassi = Moto.Chassi 
INNER JOIN Servicos ON Vendas.ServCod = Servicos.Cod 
WHERE Cod = 1;

/* J) Selecione o nome da moto, o chassi da moto, o nome do cliente, o nome do serviço feito, o valor do serviço, o nome do produto utilizado, o valor do produto utilizado, o total a pagar (produtos + serviços). Ordene a busca em ordem decrescente pelo nome do cliente. */
SELECT Moto.Nome AS "Nome da Moto", Moto.Chassi, Cliente.Nome AS "Nome do cliente", 
Servicos.Nome AS "Serviços feitos", Produtos.Nome AS "Produto Utilizado", 
Produtos.Preco AS "Preço do produto", Produtos.Preco + Servicos.Preco AS "Total a pagar" 
FROM Vendas INNER JOIN Moto ON Vendas.MotoChassi = Moto.Chassi 
INNER JOIN Cliente ON Vendas.ClieNumero = Cliente.Numero 
INNER JOIN Servicos ON Vendas.ServCod = Servicos.Cod 
INNER JOIN Produtos ON Vendas.ProdNumero = Produtos.Numero 
ORDER BY Cliente.Nome DESC;

/*--------------------------------------------------------------------------------------------------*/

DROP DATABASE LojaMotos;

