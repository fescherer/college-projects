#Exemplo
create database bibliotecaNova;
use bibliotecaNova;
create table aluno(
	RA int(5) primary key not null,
	nome varchar(50) not null,
	telefone int(9) not null
	);
insert aluno values
	(12345,"Joey Ramone",991213344),
	(54321,"Lars Ulrich",977889966),
	(11223,"Serj Tankian",987658899),
	(98765,"Vicky Psarakis",922556688),
	(56789,"Corey Taylor",901238525);

create table funcionario(
	matricula int(5) primary key auto_increment,
	nome varchar(50) not null,
	cargo varchar(30) not null
	);
insert funcionario values
	(0,"Melvil Dewey","Bibliotecario1"),
	(0,"Manuel Bastos Tigre","Bibliotecario2");

create table livro(
	isbn int(5) primary key not null,
	nome varchar(50) not null,
	secao varchar(20) not null
	);
insert livro values
	(11111,"Vida Punk","musica"),
	(22222,"Mestres da Bateria","musica"),
	(33333,"Sexta-feira13","terror"),
	(44444,"Mulheres do Rock","musica"),
	(55555,"O exorcista","terror"),
	(66666,"O chamado","terror"),
	(77777,"Mascaras","musica"),
	(88888,"ToxiCity","musica"),
	(99999,"Diario de um Mago","esoterismo");

create table Emprestimo(
	numero int(3) primary key auto_increment,
	retirada date not null,
	devolucao date not null,
	aluno_RA int(5) not null,
	funcionario_matricula int(5) not null,
	livro_isbn int(5) not null,
	foreign key(aluno_RA) references Aluno(RA),
	foreign key(funcionario_matricula) references Funcionario(matricula),
	foreign key(livro_isbn) references Livro(isbn)
	);
insert emprestimo values
	(0,"2018/01/02","2018/01/17",12345,1,11111),
	(0,"2018/01/15","2018/02/01",11223,2,88888),
	(0,"2018/04/05","2018/04/20",56789,2,77777),
	(0,"2018/03/15","2018/03/30",98765,1,44444),
	(0,"2018/06/06","2018/06/21",56789,1,55555),
	(0,"2018/08/01","2018/08/16",12345,2,22222),
	(0,"2018/10/10","2018/10/25",11223,1,66666);

create table Restricao(
	Id int(2) primary key auto_increment,
	aluno_RA int(5) not null,
	livro_isbn int(5) not null,
	foreign key(aluno_RA) references Aluno(RA),
	foreign key(livro_isbn) references Livro(isbn)
	);
insert restricao values (0,12345,22222);

#A) Jeito Ruim de fazer
SELECT Aluno.nome FROM aluno 
WHERE aluno.RA IN (SELECT aluno_RA FROM Restricao);

#A) Jeito Bom de fazer
SELECT aluno.Nome as "Aluno", livro.nome as "Livro"
FROM Restricao INNER JOIN Aluno
ON Restricao.aluno_RA = aluno.RA
	INNER JOIN Livro
	ON Restricao.livro_isbn = Livro.isbn
WHERE Aluno.RA IN (SELECT aluno_RA FROM Restricao) AND
	Livro.isbn IN (SELECT livro_isbn FROM Restricao);

#B) 
SELECT aluno.Nome as "Aluno"
FROM Aluno
WHERE aluno.RA NOT IN (SELECT aluno_RA FROM Emprestimo);

#C)
SELECT Livro.Nome as "Livro"
FROM Livro
WHERE secao NOT IN (SELECT secao FROM Emprestimo WHERE secao = "Musica");

#D) 
SELECT Aluno.Nome AS "Aluno"
FROM Aluno
WHERE Aluno.RA NOT IN 
(SELECT aluno_RA FROM Emprestimo WHERE funcionario_matricula IN 
(SELECT matricula FROM Funcionario WHERE matricula = 2));

---------------------------------------------------------------------
#Exercício 1 
drop database Lanchonete;
create database Lanchonete;
use Lanchonete;
create table Marca (
	Id int(3) primary key auto_increment,
	Nome char(20) not null
	);
INSERT Marca VALUES 
(0, "Nestle"),
(0, "Ambev"),
(0, "Caseiro");

create table Produto (
	Codigo int(8) primary key auto_increment,
	Nome varchar(30) not null,
	Validade Date not null,
	MarcaId int(3) not null,
	foreign key(MarcaId) references Marca (Id)
	);

INSERT Produto VALUES 
(0, "Chocolate Prestigio", "2018/12/15", 1),
(0, "PacoteBolacha", "2018/12/30", 1),
(0, "NescauProntinho", "2019/01/01", 1),
(0, "GuaranaAntartica", "2022/05/05", 2),
(0, "Pepsi", "2022/05/05", 2),
(0, "Coxinha", current_date+ 10, 3),
(0, "LancheNatural", current_date, 3),
(0, "Trufa", current_date+ 7, 3);

create table Financeiro(
	Numero int(8) primary key auto_increment,
	Vl_Compra decimal (5,2) not null,
	Qtd int(8) not null,
	ProdCod int(3) not null,
	foreign key (ProdCod) references Produto(Codigo)
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


# A) Selecione as marcas com exceção da Nestlé
SELECT Marca.Nome as "Marca"
FROM Marca
WHERE Nome NOT IN (SELECT Nome FROM Marca WHERE Nome = "Nestle");

# B) Selecione o nome e a validade dos produtos, somente daqueles com vencimento de validade em 15 dias no máximo
SELECT Produto.Nome, Produto.Validade FROM Produto WHERE Validade IN (SELECT Validade FROM Produto WHERE Validade <= current_date + 15);

# B2) No intervalo de validade entre hoje e 15 dias
SELECT Produto.Nome, Produto.Validade FROM Produto
WHERE Validade IN 
(SELECT Validade FROM Produto 
	WHERE Validade >= current_date AND Validade <= current_date + 15);

# C) Selecione os valores das compras(Vl_Compra*Qtd), somente daquelas que a compra for maior que R$50,00
SELECT (Vl_Compra*Qtd) as "Valor de Compra" FROM Financeiro WHERE (Vl_Compra*Qtd) IN (SELECT (Vl_Compra*Qtd) FROM Financeiro WHERE Vl_Compra*Qtd > 50);

# D) Selecione o nome da marca e o seu respectivo nome do produto, com dos produtos caseiro
SELECT Marca.Nome as "Marca", Produto.Nome as "Produto" FROM Produto INNER JOIN Marca ON Produto.MarcaId = Marca.Id WHERE Marca.Nome IN (SELECT Nome FROM Marca WHERE Nome = "Caseiro");

# D)Jeito não tão legal de fazer
SELECT Marca.Nome as "Empresa", Produto.Nome as "Produto"
FROM Marca, Produto
WHERE Marca.Nome in (SELECT Nome from Marca WHERE Nome = "Caseiro") AND Produto.MarcaId IN (SELECT MarcaId FROM Produto WHERE MarcaId = 3);

# E) Selecione o nome do produto, o valor total da compra por produto (Vl_Compra*Qtd), menos daqueles com vencimento em 2018.
SELECT Produto.Nome as "Produto", (Financeiro.Vl_Compra * Financeiro.Qtd) as "Total" from Produto, Financeiro
FROM Financeiro INNER JOIN Produto
ON Financeiro.ProdCod = Produto.Codigo
WHERE Produto.Validade NOT IN (
	SELECT Validade
	FROM Produto
	WHERE Validade < "2018/12/31");

# F) Selecione o nome da marca, o nome do produto, e a quantidade dos produtos da Ambev e Nestlé. Ordene a busca pelo nome do produto
SELECT Marca.Nome as "Marca", Produto.Nome AS "Produto", Financeiro.Qtd AS "Quantidade" FROM Produto INNER JOIN Marca
ON Produto.MarcaId = Marca.Id
	INNER JOIN Financeiro
	ON Produto.Codigo = Financeiro.ProdCod
WHERE Marca.Nome IN (
	SELECT Nome
	FROM Marca
	WHERE Nome = "Ambev" OR Nome = "Nestle"
	)
ORDER BY Produto.Nome ASC;

# G) Selecione o nome da marca e o seu respectivo nome do produto, com exceção da marca Ambev.
SELECT Marca.Nome as "Nome Marca", Produto.Nome as "Nome Produto" FROM
Marca INNER JOIN Produto
ON Marca.Id = Produto.MarcaId
WHERE Marca.Id NOT IN (
	SELECT Marca.Id FROM Marca WHERE Marca.Id = 2
);

# H) Selecione o nome do produto e a data de vencimento, somente dos produtos com vencimento em 180 dias a partir da data atual, ou a quantidade comprada do menor ou igual a 20.
SELECT Produto.Nome, Produto.Validade 
FROM Produto INNER JOIN Financeiro
ON Produto.Codigo = Financeiro.ProdCod
WHERE Financeiro.Qtd IN (SELECT Qtd FROM Financeiro WHERE Qtd <= 20) OR 
Produto.Validade IN (SELECT Validade FROM Produto WHERE Validade <= current_date + 180);

# I) Com base no print a seguir desenvolva uma tabela chamada Cliente, e faça os respectivos INSERTs.
CREATE TABLE Cliente(
	Id int(3) PRIMARY KEY auto_increment,
	Nome varchar(30) NOT NULL,
	Telefone int(9) NOT NULL
);

INSERT Cliente VALUES 
(0, "Donatello", 987654321),
(0, "Raphael", 963852741),
(0, "Michelangello", 951357852),
(0, "Leonardo", 998877665),
(0, "Splinter", 878965412);

# J) Com base no print a seguir desenvolva uma tabela chamada Venda, e faça os respectivos INSERTs.
CREATE TABLE Venda(
	Num int(6) PRIMARY KEY AUTO_INCREMENT,
	ClienteId int(3) NOT NULL, 
	ProdCod int(8) NOT NULL,
	Data date NOT NULL,
	ValorVenda int(3) NOT NULL,
	FOREIGN KEY(ClienteId) REFERENCES Cliente(Id),
	FOREIGN KEY(ProdCod) REFERENCES Produto(Codigo)
);

INSERT Venda VALUES
(0, 1, 8, "2018-09-11", 4),
(0, 2, 2, "2018-09-11", 3),
(0, 3, 4, "2018-09-11", 4),
(0, 4, 4, "2018-09-11", 4);

# L) Selecione o nome, e o telefone dos clientes que efetuaram uma compra
SELECT Cliente.Nome, Cliente.Telefone FROM Venda INNER JOIN Cliente
ON Cliente.Id = Venda.ClienteId
WHERE Cliente.Id IN (SELECT ClienteId FROM Venda);

# M) Selecione o nome do cliente, o nome do produto comprado, e a sua respectiva marca. Somente dos produtos da marca Ambev.
SELECT Cliente.Nome as "Cliente", Produto.Nome as "Produto", Marca.Nome as "Marca"
FROM Cliente INNER JOIN Venda ON Cliente.Id = Venda.ClienteId
INNER JOIN Produto ON Venda.ProdCod = Produto.Codigo
INNER JOIN Marca ON Marca.Id = Produto.MarcaId
WHERE Marca.Id IN (SELECT Id FROM Marca WHERE Id = 2);

# N) Selecione o nome do cliente, o valor da compra, e o nome dos produtos somente da marca "Caseiro".
SELECT Cliente.Nome, Financeiro.Vl_Compra, Produto.Nome as "Produto" FROM Venda 
INNER JOIN Cliente ON Venda.ClienteId = Cliente.Id 
INNER JOIN Produto ON Produto.Codigo = Venda.ProdCod 
INNER JOIN Financeiro ON Produto.Codigo = Financeiro.ProdCod
WHERE Produto.MarcaId IN (SELECT Produto.MarcaId FROM Produto WHERE MarcaId = 3);

# N2)Jeito ruim de fazer
SELECT Cliente.Nome as "Cliente", Venda.ValorVenda as "Venda", produto.Nome as "Produto" from cliente, venda, produto, Marca
where Marca.Nome in (SELECT Nome from Marca Where Nome = "Caseiro") AND Venda.ClienteId = Cliente.Id AND VENDA.ProdCod = Produto.Codigo and Produto.MarcaId = Marca.Id;

# O) Selecione o nome, e o telefone do cliente que nunca efetuou uma compra.
SELECT Cliente.Nome, Cliente.Telefone FROM Cliente
WHERE Cliente.Id NOT IN (SELECT Cliente.Id FROM Cliente INNER JOIN Venda ON Cliente.Id = Venda.ClienteId);
