
#Exemplo 
create database Aula_08;
use Aula_08;
create table AAA(
	A int,
	B decimal(6,2),
	C float(4,2)
	);
insert AAA values
	(10,25.50,13.39),
	(20,139.99,2.90),
	(30,87.70,1.39);

CREATE FUNCTION fn_teste(a int,b decimal(6.2))
RETURNS decimal 
RETURN ( (a*b) + 10);

SELECT fn_teste (A,B) as "Teste com Function" FROM AAA;

SHOW FUNCTION STATUS; #Mostra bastante coisa porque tem várias funções nos databases padrões do MySQL

----------------------------------------------------------------------------

# 1) Utilize o script a seguir.

create database BD_Total_Info;
use BD_Total_Info;

create table Categoria(
	Id int(3) primary key auto_increment,
	Nome varchar(30) not null
	);

insert Categoria values
	(0,"Celular"),
	(0,"Tablet"),
	(0,"Notebook"),
	(0,"Console");

create table Produtos(
	Cod_Prod int(3) primary key auto_increment,
	Id_Categoria int(3) not null,
	Marca varchar(30) not null,
	Modelo varchar(30) not null,
	Qtd_Prod int(4) not null,
	Preco_Prod decimal(10,2) not null,
	foreign key(Id_Categoria) references Categoria(Id)
	);

insert Produtos values
	(0,1,"Motorolla","G50",5,1500.00),
	(0,1,"Motorolla","G49",4,1400.00),
	(0,1,"Motorolla","G48",3,1300.00),
	(0,1,"Motorolla","G47",5,1200.00),
	(0,1,"Motorolla","G46",2,1100.00),
	(0,1,"Motorolla","G45",0,1000.00),
	(0,1,"Motorolla","T111",5,1000.00),
	(0,1,"Motorolla","T222",6,1050.00),
	(0,1,"Sansung","G",10,1000.00),
	(0,1,"Sansung","H",15,1100.00),
	(0,1,"Sansung","I",1,1200.00),
	(0,1,"Sansung","J",7,1300.00),
	(0,2,"Positivo","P2000",5,500.00),
	(0,2,"Positivo","P3000",3,600.00),
	(0,2,"Positivo","P4000",4,700.00),
	(0,2,"Negativo","ZZZ",5,200.00),
	(0,2,"Negativo","xxx",8,300.00),
	(0,2,"Negativo","www",10,400.00),
	(0,2,"Negativo","yyy",11,500.00),
	(0,3,"Acer","I90",5,1700.00),
	(0,3,"Acer","I91",23,1800.00),
	(0,3,"Acer","I92",12,1900.00),
	(0,3,"Acer","I93",1,2000.00),
	(0,3,"HP","F300",22,2200.00),
	(0,3,"HP","F30",20,2100.00),
	(0,3,"HP","F3",11,2000.00),
	(0,3,"HP","F",14,1900.00),
	(0,4,"Sony","PS88",9,5800.00),
	(0,4,"Sony","PS4",12,1900.00),
	(0,4,"Sony","PS3",7,1400.00),
	(0,4,"Sony","PS2",15,1000.00),
	(0,4,"Sony","PS1",10,900.00),
	(0,4,"Microsoft","XBOXELEVEN",3,4400.00),
	(0,4,"Microsoft","XBOXONE",3,1800.00),
	(0,4,"Microsoft","XBOX360",3,1200.00),
	(0,4,"Nintendo","WiU",3,1500.00),
	(0,4,"Nintendo","3DS",3,900.00);

# A) Desenvolva uma função(fn_desc) que forneça o valor de qualquer produto, dado um valor de desconto ( utilizado em vendas a vista)
CREATE FUNCTION fn_desc(x decimal(10,2), y float)
RETURNS decimal(10,2)
RETURN (x * y);

# B) Faça uma consulta utilizando a função criada anteriormente, para o preço do notebook Acer, modelo "I93“, a vista com 10% de desconto.
SELECT fn_desc (Preco_Prod, 0.9) as "Desconto 10%" FROM Produtos
WHERE Modelo = "I93";

# C) Desenvolva uma função chamada “fn_valor”, que retorne o valor(dinheiro) em estoque, de cada um dos produtos da loja 
CREATE FUNCTION fn_valor(preco decimal(10,2), qnt int(4))
RETURNS decimal(10,2)
RETURN (preco * qnt);

# D) Utilize a função fn_valor.
SELECT Marca, Modelo, fn_valor (Preco_Prod, Qtd_Prod) as "Valor em Estoque" 
FROM Produtos;

# E) Use a função fn_valor, para retornar o valor total do estoque da loja.
SELECT SUM(fn_valor (Preco_Prod, Qtd_Prod)) as "Valor em Estoque" 
FROM Produtos;

# F) Utilize a funcao fn_valor, somente para os notebooks e celulares. Retorne a Marca, o Modelo e o valor total como “Subtotal”. Coloque a consulta em ordem crescente.
SELECT fn_valor (Preco_Prod, Qtd_Prod) as "Subtotal", Produtos.Marca, Produtos.Modelo 
FROM Produtos INNER JOIN Categoria 
ON Produtos.Id_Categoria = Categoria.Id
WHERE Categoria.Id = 1 or Categoria.Id = 3
ORDER BY fn_valor (Preco_Prod, Qtd_Prod) ASC;

# G) Exiba as funções desenvolvidas
SHOW FUNCTION STATUS;
SHOW CREATE FUNCTION fn_valor;

SHOW FUNCTION STATUS 
WHERE db = 'BD_Total_Info';

# H) Delete a função fn_valor.
DROP FUNCTION fn_valor;

# I) Exiba a estrutura da função “fn_desc”.
SHOW CREATE FUNCTION fn_desc;

drop database BD_Total_Info;


# Exercício 2 - Desenvolva um BD com base na tabela a seguir:

----------------------
--RA--NOME--NP1--NP2--
----------------------
CREATE DATABASE FaculdadeAula8;
USE FaculdadeAula8;

CREATE TABLE Aluno(
	RA varchar(7) PRIMARY KEY,
	Nome varchar(30) NOT NULL,
	NP1 decimal(4,2) NOT NULL,
	NP2 decimal(4,2) NOT NULL
);

# A) Cadastre 12 alunos.
INSERT Aluno values
("E01HJE1", "Jing Xialian", 10.00, 10.00),
("E01HJQ0", "Appare Sorano", 8.00, 7.50),
("EH912E3", "Nina Flip", 6.00, 7.50),
("F41ERF7", "Shirou Ogami", 5.50, 9.50),
("F41GBH9", "Michiru Kagemori", 10.00, 10.00),
("LOPGBH6", "Shōyō Hinata", 8.00, 4.00),
("LOBNUI3", "Kiyoko Shimizu", 7.00, 10.00),
("LOIOVN4", "Nao Tomori", 8.00, 8.00),
("NBFUJH4", "Yu Nishinoya", 5.00, 8.00),
("OPQMFV2", "Monkey D. Luffy", 8.00, 8.00),
("SDVMGW1", "Natsu Dragoneel", 6.00, 9.00),
("DASDAC4", "Yuu Otosaka", 8.00, 7.00);

# B) Desenvolva uma função que calcule a média de cada aluno. Em que, Média = (NP1 * 0,4) + (NP2 * 0,6)
CREATE FUNCTION calculaMedia(nota1 decimal(4,2), nota2 decimal(4,2))
RETURNS decimal(4,2)
RETURN ((nota1 * 0.4) + (nota2 * 0.6));

# C) Selecione o nome e a média de todos os alunos.
SELECT Aluno.Nome, calculaMedia(NP1, NP2) as "Média" FROM Aluno;

# D) Selecione o nome e a média dos alunos com média menor que 7,0.
SELECT Aluno.Nome, calculaMedia(NP1, NP2) as "Média" FROM Aluno WHERE calculaMedia(NP1,NP2) < 7;

# E) Utilize a função desenvolvida na questão “d” para calcular a média geral da classe ( utilize a função, SUM e COUNT).
SELECT (SUM(calculaMedia(NP1, NP2)) / COUNT(calculaMedia(NP1,NP2))) as "Média Geral" FROM Aluno;

DROP DATABASE FaculdadeAula8;

#Exercício 3
#Para calcular o valor a mascara de rede, deve ser feito a conversão do endereço de binário para decimal. Observe o exemplo a seguir:
#Os endereços podem variar de 0 a 255 , e os valores da tabela devem ser somados se estiverem ligados (1).
#Com a técnica de funções, faça um conversor de endereço de binário para decimal. Para testar faça os INSERTS a seguir:

#00000000 --> 0
#01010101 --> 85
#10101010 --> 170
#11100010 --> 226
#00111011 --> 59
#00100100 --> 36
#11111111 --> 255

DROP DATABASE MascaraDeRede;

CREATE DATABASE MascaraDeRede;
USE MascaraDeRede;

CREATE TABLE mascara(
	C1 int(1),
	C2 int(1),
	C3 int(1),
	C4 int(1),
	C5 int(1),
	C6 int(1),
	C7 int(1),
	C8 int(1)
	);

INSERT mascara VALUES
(0,0,0,0,0,0,0,0),
(0,1,0,1,0,1,0,1),
(1,0,1,0,1,0,1,0),
(1,1,1,0,0,0,1,0),
(0,0,1,1,1,0,1,1),
(0,0,1,0,0,1,0,0),
(1,1,1,1,1,1,1,1);



CREATE FUNCTION conversorBinario(C1 int, C2 int, C3 int, C4 int, C5 int, C6 int, C7 int, C8 int)
RETURNS int
RETURN (C1 * 128) + (C2 * 64) + (C3 * 32) + (C4 * 16) + (C5 * 8) + (C6 * 4) + (C7 * 2) + (C8 * 1);

SELECT conversorBinario(C1,C2,C3,C4,C5,C6,C7,C8) AS "Valor Convertido" FROM mascara;