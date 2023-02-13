
CREATE DATABASE TechStore;
use TechStore;

Create table Categoria(
	Id int(3) primary key auto_increment,
	Nome varchar(30) not null
	);


insert Categoria values
	(0,"Celular"),
	(0,"Tablet"),
	(0,"Notebook"),
	(0,"Console");


Create table Produtos(
	Codigo int(10) primary key auto_increment,
	Id_Categoria int(3) not null,
	Marca varchar(30) not null,
	Modelo varchar(30) not null,
	Preco decimal(6,2) not null,
	foreign key(Id_Categoria) references Categoria(Id)
	);

insert Produtos values
	(0,1,"Motorolla","G50",1500.00),
	(0,1,"Motorolla","G49",1400.00),
	(0,1,"Motorolla","G48",1300.00),
	(0,1,"Motorolla","G47",1200.00),
	(0,1,"Motorolla","G46",1100.00),
	(0,1,"Motorolla","G45",1000.00),
	(0,1,"Motorolla","T111",1000.00),
	(0,1,"Motorolla","T222",1050.00),
	(0,1,"Sansung","G",1000.00),
	(0,1,"Sansung","H",1100.00),
	(0,1,"Sansung","I",1200.00),
	(0,1,"Sansung","J",1300.00),
	(0,2,"Positivo","P2000",500.00),
	(0,2,"Positivo","P3000",600.00),
	(0,2,"Positivo","P4000",700.00),
	(0,2,"Negativo","ZZZ",200.00),
	(0,2,"Negativo","xxx",300.00),
	(0,2,"Negativo","www",400.00),
	(0,2,"Negativo","yyy",500.00),
	(0,3,"Acer","I90",1700.00),
	(0,3,"Acer","I91",1800.00),
	(0,3,"Acer","I92",1900.00),
	(0,3,"Acer","I93",2000.00),
	(0,3,"HP","F300",2200.00),
	(0,3,"HP","F30",2100.00),
	(0,3,"HP","F3",2000.00),
	(0,3,"HP","F",1900.00),
	(0,4,"Sony","PS88",5800.00),
	(0,4,"Sony","PS4",1900.00),
	(0,4,"Sony","PS3",1400.00),
	(0,4,"Sony","PS2",1000.00),
	(0,4,"Sony","PS1",900.00),
	(0,4,"Microsoft","XBOX ELEVEN",4400.00),
	(0,4,"Microsoft","XBOX ONE",1800.00),
	(0,4,"Microsoft","XBOX 360",1200.00),
	(0,4,"Nintendo","Wi U",1500.00),
	(0,4,"Nintendo","3DS",900.00)
	;



/* 1) Selecione todos os celulares a venda na TechStore (anote a quantidade).*/
SELECT COUNT(*) FROM Produtos WHERE Id_Categoria = 1;
/*RESPOSTA: 12*/

/* 2) Delete o celular “G50” da Motorolla.*/
DELETE FROM Produtos
WHERE Produtos.Codigo = 1;

/* 3) Confira a quantidade de celular.*/
SELECT * FROM Produtos;
SELECT COUNT(*) FROM Produtos WHERE Id_Categoria = 1;

/* 4) Selecione os tablets a venda na TechStore (anote a quantidade)*/
SELECT COUNT(*) AS "QNT Tablet" FROM Produtos WHERE Id_Categoria = 2;
SELECT * FROM Produtos WHERE Id_Categoria = 2;
/*Resposta: 7*/

/* 5) Delete os tablets da marca “Negativo” e valor abaixo de R$500,00.*/
DELETE FROM Produtos
WHERE Id_Categoria = 2 AND Marca = "Negativo" AND Preco < 500.00;

/* 6) Confira a quantidade de tablets*/
SELECT COUNT(*) FROM Produtos WHERE Id_Categoria = 2;
/*Resposta: 4*/

/* 7) Delete os produtos da HP ou notebooks acima de R$2000,00 */
DELETE FROM Produtos
WHERE Marca = "HP" OR (Id_Categoria = 3 AND Preco > 2000.00);

/* 8) Delete a categoria “Tablets” */
DELETE FROM Categoria
WHERE Id = 2;

/* 9) Porque não deletou a categoria tablets? */
/*Não é para deletar porque essa categoria ainda tem dados que estão relacionados em outras tabelas*/

/* 10) Selecione todos os consoles (anote a quantidade) */
SELECT * FROM Produtos WHERE Id_Categoria = 4;
SELECT COUNT(*) FROM Produtos WHERE Id_Categoria = 4;
/*Resposta: 10*/

/* 11) Delete os consoles abaixo de R$1000,00 ou acima de R$4000,00 */
DELETE FROM Produtos 
WHERE Id_Categoria = 4 AND (Preco < 1000 OR Preco > 4000);

/* 12) Delete os produtos que o modelo inicie coma letra “T” */
DELETE FROM Produtos
WHERE Modelo LIKE "T%";

/* 13) Qual a diferença entre as instruções: DROP, DELETE, TRUNCATE.*/
#DROP: É usado para excluir tudo de um banco ou de uma tabela, basicamente, todos os dados do(da) tal deixará de existir
#DELETE: É usado para excluir algo também, mas diferente do DROP, o DELETE é usado para excluir algo em específico, ou seja, um dado em específico
#TRUNCATE: É usado para "limpar" algo. Quando usamos o TRUNCATE, os dados serão apagados, mas a estrutura da tabela estará intacta

/*EXPLICAÇÃO PROF*/
#DROP: Para excluir DATABASE e TABLE
#DELETE: Para excluir registros em TABLE
#TRUNCATE: Para excluir TODOS os registros de uma TABLE

/* 14) Escreva a sintaxe de cada uma das instruções da questão13. (Isso é muito importante!)*/
DROP TABLE Produtos;

DROP DATABASE TechStore;

DELETE FROM Produtos
WHERE Id = 1;

TRUNCATE TABLE Produtos;

/*--------------------------------------------------------------------------------------------------*/

DROP DATABASE TechStore;