-- 1)Utilize o script a seguir para realizar os exercícios:

drop database SuperTV;

create database SuperTV;

use SuperTV;

Create table Planos(
	Id int(3) primary key auto_increment,
	Combo varchar(30) not null,
	Preco decimal (6,2) not null,
	Canais varchar(100) not null 
);

insert Planos values 
	(0, "Basico", 59.99, "Tv aberta + 2 desenhos + 2 esportes + 1 noticias"),
	(0, "Normal", 89.99, "Tv aberta + 3 desenhos + 3 esportes + 1 noticias + 1 filmes"),
	(0, "Hiper", 100.00, "Tv aberta + 3 desenhos + 4 esportes + 2 noticias + 2 documentarios"),
	(0, "Silver", 120.00, "Tv aberta + todos desenhos + todos esportes + 1 noticias + 2 documentarios + 2 filmes"),
	(0, "Gold", 150.00, "Todos os canais + PPV + Adulto");

Create table Clientes(
	Codigo int(10) not null primary key,
	Nome varchar(30) not null,
	Telefone varchar(20) not null,
	Cidade varchar(50) not null,
	PlanosId int(3) not null,
	foreign key (PlanosId) references Planos(Id) 
);
insert  Clientes  values (1, "Clarence Daniels", "63-(880)325-6931", "Hinunangan", 4);
insert  Clientes  values (2, "Craig Jordan", "1-(597)573-2623", "Laguna Salada", 2);
insert  Clientes  values (3, "Melissa Bennett", "33-(922)390-7610", "Montluel", 2);
insert  Clientes  values (4, "Jessica Johnston", "692-(357)829-9023", "Airuk", 1);
insert  Clientes  values (5, "Joan Garrett", "7-(672)549-2896", "Vostryakovo", 3);
insert  Clientes  values (6, "Brandon Rivera", "48-(780)530-1523", "Łazy", 2);
insert  Clientes  values (7, "Deborah Hawkins", "66-(385)149-5139", "Nong Ruea", 3);
insert  Clientes  values (8, "Roger Stanley", "62-(972)752-7986", "Petung", 1);
insert  Clientes  values (9, "Kathy Diaz", "358-(119)408-9566", "Janakkala", 2);
insert  Clientes  values (10, "Rebecca Henderson", "62-(713)771-4611", "Lajaluhur", 4);
insert  Clientes  values (11, "Ashley Fernandez", "62-(260)790-9901", "Kanugrahan", 2);
insert  Clientes  values (12, "Brian Perkins", "86-(611)219-9813", "Datong", 5);
insert  Clientes  values (13, "Rachel Gardner", "86-(335)816-5503", "Sanshan", 4);
insert  Clientes  values (14, "Ann Simpson", "86-(225)170-3406", "Jianxincun", 5);
insert  Clientes  values (15, "Stephanie Smith", "353-(420)303-4869", "Whitegate", 5);
insert  Clientes  values (16, "Nicholas Rivera", "81-(460)772-4246", "Maebashi-shi", 4);
insert  Clientes  values (17, "Mary Torres", "218-(910)958-7110", "Zawiya", 2);
insert  Clientes  values (18, "Russell Meyer", "84-(389)959-9628", "Kinh Môn", 2);
insert  Clientes  values (19, "Lori Morgan", "86-(319)172-9857", "Zaoxi", 1);
insert  Clientes  values (20, "Edward Reyes", "48-(899)502-7642", "Lisewo Malborskie", 5);
insert  Clientes  values (21, "Earl Graham", "420-(546)238-0287", "Humpolec", 4);
insert  Clientes  values (22, "Nancy Thompson", "850-(918)868-0556", "Kangdong-ŭp", 2);
insert  Clientes  values (23, "Maria Murphy", "86-(567)282-0923", "Jiefangyan", 3);
insert  Clientes  values (24, "Kathleen Ryan", "86-(326)639-9524", "Daxi", 4);
insert  Clientes  values (25, "Billy Stone", "48-(114)858-8612", "Wielichowo", 2);
insert  Clientes  values (26, "Dorothy Cooper", "55-(296)160-1932", "Senador Pompeu", 2);
insert  Clientes  values (27, "Louise Ferguson", "56-(441)853-2882", "Vilcún", 1);
insert  Clientes  values (28, "James Lopez", "966-(125)464-3685", "Julayjilah", 1);
insert  Clientes  values (29, "Susan Edwards", "227-(682)748-4859", "Zinder", 2);
insert  Clientes  values (30, "DanielElliott", "52-(349)666-1090", "Independencia", 1);

create table Financeiro
	(Oper int primary key auto_increment,
	ClientesCodigo int(10) not null,
	Mes varchar(15) not null,
	Status varchar(15) not null,
	foreign key(ClientesCodigo) references clientes(codigo)
);

insert Financeiro values 
	(0, 1, "Jan", "Pago"),
	(0, 1, "Fev", "Pago"),
	(0, 2, "Jan", "Pago"),
	(0, 2, "Fev", "Aberto"),
	(0, 3, "Jan", "Aberto"),
	(0, 3, "Fev", "Aberto"),
	(0, 4, "Jan", "Pago"),
	(0, 4, "Fev", "Pago"),
	(0, 5, "Jan", "Aberto"),
	(0, 5, "Fev", "Pago"),
	(0, 6, "Jan", "Pago"),
	(0, 6, "Fev", "Pago"),
	(0, 7, "Jan", "Pago"),
	(0, 7, "Fev", "Pago"),
	(0, 8, "Jan", "Pago"),
	(0, 8, "Fev", "Pago"),
	(0, 9, "Jan", "Pago"),
	(0, 9, "Fev", "Pago"),
	(0, 10, "Jan", "Pago"),
	(0, 10, "Fev", "Pago"),
	(0, 11, "Jan", "Pago"),
	(0, 12, "Fev", "Pago"),
	(0, 13, "Jan", "Pago"),
	(0, 13, "Fev", "Pago"),
	(0, 14, "Jan", "Pago"),
	(0, 14, "Fev", "Pago"),
	(0, 15, "Fev", "Pago"),
	(0, 16, "Fev", "Pago"),
	(0, 17, "Fev", "Pago"),
	(0, 18, "Fev", "Pago"),
	(0, 19, "Fev", "Aberto"),
	(0, 20, "Fev", "Aberto"),
	(0, 21, "Jan", "Pago"),
	(0, 21, "Fev", "Pago"),
	(0, 22, "Jan", "Pago"),
	(0, 22, "Fev", "Pago"),
	(0, 23, "Jan", "Pago"),
	(0, 23, "Fev", "Aberto"),
	(0, 24, "Jan", "Pago"),
	(0, 24, "Fev", "Pago"),
	(0, 25, "Fev", "Pago"),
	(0, 26, "Jan", "Pago"),
	(0, 26, "Fev", "Pago"),
	(0, 27, "Jan", "Pago"),
	(0, 27, "Fev", "Pago"),
	(0, 28, "Jan", "Pago"),
	(0, 28, "Fev", "Pago"),
	(0, 29, "Jan", "Pago"),
	(0, 29, "Fev", "Pago"),
	(0, 30, "Jan", "Pago"),
	(0, 30, "Fev", "Pago");

create table Ex_clientes(
	Num int primary key auto_increment,
	ClientesCodigo int(10) not null,
	foreign key(ClientesCodigo) references clientes(codigo)
);

insert Ex_clientes values 
	(0, 2),
	(0, 15),
	(0, 19),
	(0, 20),
	(0, 25);

# EXERCÍCIOS(Join, View, Update e Delete)

# 1) Selecione o nome do cliente, o telefone do cliente, o nome do plano, e o valor do plano
	SELECT clientes.Nome, clientes.Telefone, Planos.combo, Planos.Preco FROM Clientes INNER JOIN Planos ON Clientes.PlanosId = Planos.Id;

# 2) Selecione  o  nome  do  cliente,  e  o  status  de  pagamentos. Somente  do  mês  de  fevereiro, exibir o nome em ordem crescente.
	SELECT Clientes.Nome, Financeiro.Status FROM CLientes INNER JOIN Financeiro ON Clientes.codigo = Financeiro.ClientesCodigo WHERE Financeiro.Mes = "Fev" ORDER BY Clientes.Nome ASC;

# 3) Selecione o nome do cliente, o telefone do cliente, e o mês que o status esteja em aberto.
	SELECT Clientes.Nome, Clientes.Telefone, Financeiro.Mes FROM Clientes INNER JOIN Financeiro ON Clientes.Codigo = Financeiro.ClientesCodigo WHERE Financeiro.Status = "aberto";

# 4) Desenvolva  uma  VIEW(escolha o  nome)que  selecione  o  nome do  cliente,  o  combo,  e  o status as faturas.
	CREATE VIEW vw_NomeComboStatus AS
	 SELECT Clientes.Nome, Planos.Combo, Financeiro.Status FROM Planos INNER JOIN Clientes ON Planos.Id = Clientes.PlanosId 
	 INNER JOIN Financeiro ON Clientes.Codigo = Financeiro.ClientesCodigo;

# 5) Utilize  a  VIEW  desenvolvidana  questão  4,para  verificar  a  situação  do  cliente  chamado Joan Garrett.
	SELECT * FROM vw_NomeComboStatus WHERE Nome = "Joan Garrett";

# 6) Desenvolva uma view (escolha o nome), do nome do cliente, valor pago de mensalidade e canais disponíveis, exiba o nome dos clientes em ordem crescente.
	CREATE VIEW vw_NomeValorCanais AS
	SELECT Clientes.Nome, Planos.Preco, Planos.Canais FROM Clientes INNER JOIN Planos ON Clientes.PlanosId = Planos.Id ORDER BY Clientes.Nome ASC;

# 7) Utilize  a  VIEW  desenvolvida  na  questão  6,  de  forma  que  exiba  somente  os  clientes  que pagam a mensalidade maior ou igual a R$100,00.
	SELECT * FROM vw_NomeValorCanais WHERE Preco >= 100;

# 8) Acrescente um aumento de 10% para todos os combos com exceção do plano básico. 
	UPDATE Planos SET Preco = Preco * 1.10 WHERE combo <> "Basico";

	SELECT * FROM Planos;

# 9) Modifique  o  nome  do  combo  de  “Hiper”  para  “Max”,  Adicione  mais  um  canal  de documentários e aumente o preço para R$ 115,00.
	UPDATE Planos SET Combo = "Max", Canais = "Tv aberta + 3 desenhos + 4 esportes + 2 noticias + 3 documentarios", Preco = 115.00 WHERE Combo = "Hiper";

	SELECT * FROM Planos;

# 10) Verifique se existe algum Ex_Cliente com parcela em aberto.
	SELECT Clientes.Codigo ,Clientes.Nome, Financeiro.Mes, Financeiro.Status FROM Ex_clientes INNER JOIN CLientes ON Ex_clientes.ClientesCodigo = Clientes.Codigo INNER JOIN Financeiro ON Clientes.Codigo = Financeiro.ClientesCodigo WHERE Financeiro.Status = "aberto";

# 11) Verifique  o  mês  em  aberto  da  cliente  Lori  Morgan,  e  modifique  o  Status  do  pagamento para Pago. 
	SELECT Financeiro.Mes FROM Financeiro INNER JOIN Clientes ON Financeiro.ClientesCodigo = Clientes.Codigo WHERE Clientes.Nome = "Lori Morgan" AND Financeiro.Status = "aberto";

	UPDATE Financeiro INNER JOIN Clientes ON Financeiro.ClientesCodigo = Clientes.Codigo SET Financeiro.Status = "pago" WHERE Clientes.Nome = "Lori Morgan" AND Financeiro.Status = "aberto";


# 12) Exclua o nome da Lori Morgan da tabela Ex_Clientes.
	DELETE FROM Ex_clientes WHERE ClientesCodigo = 19;

# 13) Modifique o combo do cliente “Roger Stanley”, de “Básico” para “Max”.	
	UPDATE Clientes SET Clientes.PlanosId = 3 WHERE Clientes.Nome = "Roger Stanley";

	SELECT * FROM CLientes WHERE Nome = "Roger Stanley";


# ---------------------------------------------------------------------------------------------------------------------------------------------------------#

# 2)Utilize o script a seguir para realizar os exercícios:
create database BookStore;
use BookStore;

create table Ende(
	CEP varchar(9) primary key not null,
	Rua varchar(50) not null,
	Bairro varchar(30) not null
);

insert Ende values 
	("12345-123", "Padre Amaro", "Lapa"),
	("12345-999", "Leopoldina", "Centro"),
	("54321-123", "Tiradentes", "Centro"),
	("12345-888", "São Francisco", "Brás"),
	("99999-123", "Marechal Deodoro", "Santo Amaro"),
	("99999-111", "da Paz", "Santo Amaro"),
	("22222-999", "Tabuias", "Moema"),
	("33333-123", "Mirante", "Pirituba"),
	("33333-999", "13 de Maio", "Paulista"),
	("44444-123", "Whashington Luiz", "Jardins"),
	("44444-111", "Francisco Xavier", "Ibirapuera"),
	("55555-999", "MMDC", "Centro"),
	("55555-123", "do Comerciario", "Ibirapuera"),
	("66666-999", "Princesa Isabel", "Brás"),
	("77777-123", "do Mirante", "Morumbi"),
	("88888-111", "Jose Paulino", "Santo Amaro");

create table Editora(
	Cod int primary key auto_increment,
	Nome varchar(30) not null,
	EndCEP varchar(9)not null,
	Numero int not null,
	foreign key(EndCEP) references Ende(CEP)
);

insert Editora values 
	(0, "LiveBooks", "12345-123", 100),
	(0, "SuperTech", "54321-123", 1125),
	(0, "Saber", "99999-123", 300),
	(0, "BooksNets", "99999-111", 325);

create table Cliente(
	Id int primary key auto_increment,
	Nome varchar(30) not null,
	EndCEP varchar(9) not null,
	Numero int not null,
	foreign key(EndCEP) references Ende(CEP)
);
insert Cliente values 
	(0, "João do Caminhão", "44444-111", 250),
	(0, "Batman", "88888-111", 1100),
	(0, "Kiko", "77777-123", 739),
	(0, "Sr. Madruga", "66666-999", 401),
	(0, "Mario do Armario", "99999-111", 1500),
	(0, "Dunha da Unha", "44444-123", 2345),
	(0, "Jerry", "12345-999", 10),
	(0, "Jack", "33333-999", 19),
	(0, "Harry", "99999-123", 555),
	(0, "Hermione", "66666-999", 909),
	(0, "Jair Bolsonaro", "33333-999", 1599),
	(0, "Haddad", "66666-999", 13);

create table Livro(
	ISBN bigint primary key,
	Nome varchar(30) not null,
	EditoraCod int not null,
	Preco decimal(7,2) not null,
	foreign key(EditoraCod) references Editora(Cod)
);

insert Livro values 
	(123456, "A arte da Guerra", 1, 19.99),
	(111111, "Ponto de Impacto", 1, 29.99),
	(222222, "O código Da Vinci", 1, 29.99),
	(333333, "O Símbolo Perdido", 1, 29.99),
	(444444, "Inferno", 1, 29.99),
	(555555, "Fortaleza Digital", 1, 29.99),
	(666666, "O alquimista", 2, 15.00),
	(777777, "Onze minutos", 2, 15.00),
	(888888, "Brida", 2, 15.00),
	(999999, "Veronika decide morrer", 2, 15.00),
	(112211, "Diario de um mago", 2, 15.00),
	(223344, "Qual a sua obra?", 2, 29.99),
	(554433, "Etica vegonha na casa", 2, 29.99),
	(665544, "A sorte segue a coragem", 2, 19.99),
	(992288, "por que fazemos o que fazemos?", 2, 19.99),
	(662299, "A escola do conhecimento", 2, 19.99),
	(119966, "Pensar bem nos faz bem", 2, 19.99),
	(555566, "Alice -Coleção", 3, 150.00),
	(909090, "O magico de Oz", 3, 89.99),
	(373737, "Java", 4, 59.99),
	(616161, "MySql", 4, 49.99),
	(838383, "Linguagem C", 4, 49.99),
	(104344, "Algoritmos", 4, 39.99);

create table Estoque(
	Num int primary key auto_increment,
	LivroISBN bigint not null,
	Qtd int not null,
	foreign key(LivroISBN) references Livro(ISBN)
);

insert Estoque values 
	(0, 123456, 20),
	(0, 111111, 20),
	(0, 222222, 15),
	(0, 333333, 10),
	(0, 444444, 15),
	(0, 555555, 20),
	(0, 666666, 10),
	(0, 777777, 15),
	(0, 888888, 20),
	(0, 999999, 10),
	(0, 112211, 15),
	(0, 223344, 20),
	(0, 554433, 15),
	(0, 665544, 10),
	(0, 992288, 15),
	(0, 662299, 20),
	(0, 119966, 10),
	(0, 555566, 15),
	(0, 909090, 20),
	(0, 373737, 10),
	(0, 616161, 10),
	(0, 838383, 15),
	(0, 104344,20);

create table Carrinho(
	Codigo int primary key auto_increment,
	ClienteId int not null,
	LivroISBN bigint not null,
	Qtd int not null,
	foreign key(ClienteId) references Cliente(Id),
	foreign key(LivroISBN) references Livro(ISBN));

insert Carrinho values 
	(0, 1, 123456, 1),
	(0, 2, 111111, 1),
	(0, 3, 909090, 1),
	(0, 4, 777777, 2),
	(0, 5, 554433, 1),
	(0, 6, 665544, 1),
	(0, 7, 555566, 2),
	(0, 8, 444444, 1),
	(0, 9, 119966, 1),
	(0, 10, 373737, 2);

# EXERCÍCIOS(Sub-select e Function)

# 1) Utilize  sub  select  para  selecionar  o  nome  dos  clientes,  e  o  título  do  livro,  apenas  dos clientes que compraram algum livro da editora BooksNets.
	SELECT Cliente.Nome, Livro.nome FROM Cliente INNER JOIN Carrinho ON Cliente.Id = Carrinho.ClienteId INNER JOIN Livro ON Carrinho.LivroISBN = Livro.ISBN INNER JOIN Editora ON Livro.EditoraCod = Editora.Cod WHERE Editora.Nome IN (SELECT Nome FROM Editora WHERE Nome = "BooksNets");

# 2) Utilize sub select para o nome dos livros que não houve nenhuma venda.
	SELECT Livro.Nome FROM Livro WHERE Livro.Nome NOT IN (SELECT Livro.Nome FROM Livro INNER JOIN Carrinho ON livro.ISBN = Carrinho.LivroISBN);

# 3) Utilize sub select para uma consulta com o nome da editora, nome do livro, o valor do livro, e a quantidade de livros no estoque. Ordene a seleção pelo nome dos livros.
	SELECT Editora.Nome, Livro.Nome, Livro.preco, Estoque.Qtd 
	FROM Editora INNER JOIN Livro ON Editora.Cod = Livro.EditoraCod
	INNER JOIN Estoque ON Livro.ISBN = Estoque.LivroISBN
	ORDER BY Livro.Nome ASC;

	SELECT Editora.Nome, Livro.Nome, Livro.preco, Estoque.Qtd 
	FROM Editora, Livro, Estoque 
	WHERE EditoraCod IN (SELECT EditoraCod FROM Livro) AND Livro.EditoraCod = Editora.Cod AND Livro.ISBN = Estoque.LivroISBN 
	ORDER BY Livro.Nome ASC;

# 4) Utilize  sub  select  que  retorne  o  nome  dos  clientes  que  possuem  cadastro,  porém  nunca efetuaram uma compra.
	SELECT Cliente.Nome FROM Cliente WHERE CLiente.nome NOT IN (SELECT CLiente.Nome FROM CLiente INNER JOIN Carrinho ON Cliente.Id = Carrinho.ClienteId);

# 5) Desenvolva um script que retorne, o código da compra, o nome do cliente, o endereço, o número da casa, o nome do livro, e o valor do livro.
	SELECT Carrinho.Codigo, Cliente.Nome, Ende.*, Cliente.Numero, Livro.Nome, Livro.Preco 
	FROM Carrinho INNER JOIN Cliente ON Carrinho.ClienteId = Cliente.Id
	INNER JOIN Ende ON Cliente.EndCEP = Ende.CEP 
	INNER JOIN Livro ON Carrinho.LivroISBN = Livro.ISBN;

# 6) Desenvolva uma function que retorne o valor total de cada compra feita na livraria.
	CREATE Function fn_ValorTotal(qnt int, preco decimal(7,2))
	RETURNS decimal(7,2)
	RETURN qnt * preco;

# 7) Utilize  a  função  desenvolvida  na  questão  6,  que  retorne  o  nome  do  cliente  e  o  valor  a pagar.
	SELECT Cliente.Nome, fn_ValorTotal(Carrinho.Qtd, Livro.Preco) AS "Valor a pagar" 
	FROM Carrinho INNER JOIN Cliente ON Carrinho.ClienteId = Cliente.Id
	INNER JOIN Livro ON Carrinho.LivroISBN = Livro.ISBN;

# 8) Desenvolva uma function que retorne o valor total de cada livro no estoque, onde deve ser multiplicado o valor unitário do livro pela quantidade de livros no estoque.
	CREATE Function fn_ValorTotalEstoque(qnt int, preco decimal(7,2))
	RETURNS int
	RETURN qnt * preco;

# 9) Utilize a função desenvolvida na questão 8, que retorne o nome do livro, e o valor total em estoque. 
	SELECT Livro.Nome, fn_ValorTotalEstoque(Estoque.Qtd, Livro.preco) AS "Valor no estoque"
	FROM Livro INNER JOIN Estoque ON livro.ISBN = Estoque.LivroISBN;

# 10) Exiba o valor total geral em estoque, ou seja, a somatória do valor em estoque de todos os livros.
	SELECT SUM(fn_ValorTotalEstoque(Estoque.Qtd, livro.Preco)) AS "TOTAL"
	FROM Livro INNER JOIN Estoque ON livro.ISBN = Estoque.LivroISBN;