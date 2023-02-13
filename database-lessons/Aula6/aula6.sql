# 1) Uma gibiteca comunitária necessita organizar o seu pequeno acervo. Para isso copie e cole as instruções a seguir.


create database Gibiteca;
use Gibiteca;
CREATE table Categoria(
Cod int(3) primary key not null,
Nome varchar(25) not null
);
insert categoria values 
 (1, "Infantil Meninos"),
 (2, "Infantil Meninas"),
 (3, "Manga"),
 (4, "Comic/Marvel");

CREATE table HQ (
Num int(3) primary key auto_increment,
Nome varchar(40) not null,
Localizacao varchar(3) not null,
Ano int(4) not null,
CategoriaCod int(3) not null,
foreign key (CategoriaCod) references Categoria(Cod)
);

insert HQ values 
(0, "Cascao - O inicio", "A-1", 2010,1),
(0, "Arco do Shogun - N.3", "B-1", 2011, 3),
(0, "DC: A Nova Fronteira", "C-1", 2005, 4),
(0, "Cascao - Apenas amigos", "A-1", 2015, 1),
(0, "Arco do Shogun - N.9", "B-1", 2002, 3),
(0, "Arco do Shogun - N.10", "B-1", 2012, 3),
(0, "SJA: A Era de Ouro", "C-1", 2011, 4),
(0, "Luluzinha - Muda de cara", "A-1", 2014, 2),
(0, "Magali - Fome de falar", "A-1", 2014, 2),
(0, "Chico Bento - Na madrugada", "A-1", 2005, 1),
(0, "Cebolinha - Noite de terror", "A-1", 2009, 1),
(0, "Cebolinha - Sempre amigos", "A-1", 2013, 1),
(0, "Monica - Que susto!", "A-1", 2012, 2),
(0, "Monica - Amiga da onça", "A-1", 2010, 2),
(0, "Power Girls - Um desafio", "A-1", 2008, 2),
(0, "Ansatsu Kyoushitsu - N.2", "B-1", 2007, 3),
(0, "Tio Patinhas - Um dia de Trabalho", "A-1", 2016, 1),
(0, "Arco do Shogun - N.5", "B-1", 2015, 3),
(0, "Demolidor Vol. 1", "C-1", 2014, 4),
(0, "Gintama - Desafio Mortal", "B-1", 2011, 3),
(0, "Tales of Demons and Gods - Longas noites", "B-1", 2010, 3),
(0, "Demolidor Vol. 2", "C-1", 2001, 4),
(0, "Demolidor Vol. 3", "C-1", 2012, 4),
(0, "Arco do Shogun - N.6", "B-1", 2010, 3),
(0, "Arco do Shogun - N.7", "B-1", 2009, 3),
(0, "Tio Patinhas - Saida de Mestre", "A-1", 2008, 1),
(0, "Chico Bento - seu Juca?", "A-1", 2005, 1),
(0, "Ansatsu Kyoushitsu - N.1", "B-1", 2011, 3),
(0, "Os Novos Titãs: O Contrato de Judas", "C-1", 2009, 4),
(0, "Batman: A Piada Mortal", "C-1", 2004, 4),
(0, "Luluzinha - Linda flor", "A-1" , 1999, 2),
(0, "Magali - Familia de verdade", "A-1", 2010, 2),
(0, "Asilo Arkham", "C-1", 2014, 4),
(0, "Arco do Shogun - N.4", "B-1", 2013, 3),
(0, "Arco do Shogun - N.8", "B-1", 2011, 3),
(0, "Batman: o Longo Dia das Bruxas", "C-1", 2012, 4),
(0, "Grandes Astros Superman", "C-1", 2013, 4),
(0, "Chico Bento - Sempre atrasado", "A-1", 2014, 1),
(0, "Ansatsu Kyoushitsu - Super", "B-1", 2015, 3),
(0, "Os Novos Titãs: Lutas e mais nada", "C-1", 2015, 4),
(0, "Batman: A escolha", "C-1", 2010, 4),
(0, "Luluzinha - Manha gelada", "A-1", 2010, 2),
(0, "Magali - A plantacao", "A-1", 2008, 2),
(0, "Chico Bento - Meu pesoar", "C-1", 2009, 1),
(0, "Arco do Shogun - Master", "B-1", 2010, 3),
(0, "Batman: amanhecer de verao", "C-1", 2011, 4),
(0, "Power Girls - Ameaçadas", "A-1", 2012, 2),
(0, "Ansatsu Kyoushitsu - N.3", "B-1", 2013, 3),
(0, "Ansatsu Kyoushitsu - N.4", "B-1", 2014, 3),
(0, "Gintama - Uniao", "B-1", 2002, 3),
(0, "Arco do Shogun - N.1", "B-1", 2003, 3),
(0, "Arco do Shogun - N.2", "B-1", 2005, 3),
(0, "Batman: Ano Um", "C-1", 2010, 4),
(0, "O Reino do Amanhã", "C-1", 2016, 4),
(0, "Saga dos Clones", "C-1", 2016, 4),
(0, "Homem de Ferro: A Cruzada", "C-1", 2016, 4),
(0, "Os X-Men de Chuck Austen", "C-1", 2015, 4),
(0, "Os Supremos – Millenium", "C-1", 2013, 4),
(0, "Demolidor Vol. 4", "C-1", 2013, 4),
(0, "Demolidor Vol. 5", "C-1", 2011, 4)
;

# A) Insira um índice na tabela HQ, na coluna (Cod_Categoria).
CREATE INDEX idx_categoria
ON HQ(CategoriaCod);

SELECT * FROM HQ USE INDEX (idx_categoria);

# B) Verifique se o índice foi desenvolvido.
SHOW INDEX FROM HQ;

# C) Utilize o índice desenvolvido, para efetuar uma consultar nos nomes dos HQs e a sua respectiva localização, somente dos Mangás. (exiba em ordem crescente pelo nome dos HQs).
SELECT HQ.Nome, HQ.Localizacao FROM HQ USE INDEX (idx_categoria) WHERE CategoriaCod = 3 ORDER BY HQ.Nome;

# D) Utilize o índice desenvolvido, para efetuar uma consultar nos nomes dos HQs com o ano inferior a 2008.
SELECT HQ.Nome FROM HQ USE INDEX (idx_categoria) WHERE ano < 2008;

# E) Faz diferença utilizar o índice na questão “d”? Porque?
/*Não faz diferença. Pois o índice está apontado para o atributo(chave estrangeira) categoriaCod e não para ao atributo ano */

# F) Exclua o índice desenvolvido na questão “a”.
DROP INDEX idx_categoria ON HQ;

# G) Porque o índice não pode ser excluído?
/*O erro era para ser ERROR 1553 (HY000): Cannot drop index 'idx_CatHQ': needed in a foreign key constraint
Somente em tabelas InnoDB não deixa excluir, ´por padrão o mysql vem instalado em MyISAM. 
Resposta: Existe uma restição de CONSTRAINT na chave estrangeira da categoriaCod*/

# H) Exclua o índice desenvolvido na questão “a”.
SET FOREIGN_KEY_CHECKS=0; #Deve ser feito antes de criar a tabela
SET FOREIGN_KEY_CHECKS=1;
ALTER TABLE HQ DROP FOREIGN KEY CategoriaCod;
DROP INDEX idx_categoria ON HQ;

ALTER TABLE HQ
  DROP FOREIGN KEY CategoriaCod,
  DROP KEY CategoriaCod;

 /*----------------------------------*/
 DROP DATABASE Gibiteca;

/****************************************************************************************************************************************************************/

#Exercício 2

drop database LivroSagrado;
create database LivroSagrado;
use LivroSagrado;
create table Biblia(
Livro varchar(20) not null,
Versiculo int(5) not null,
Capitulo int(5) not null,
Texto varchar(200) not null
)ENGINE = InnoDB;
insert Biblia values 
("Lucas", 12, 34, "Pois onde estiver o amor, ali estará também o nosso coração."),
("Isaias", 40, 31, "Aqueles que esperam no Senhor renovam as suas forças. Voam alto como águias. Correm e não
ficam exaustos, andam e não se cansam."),
("Salmos", 16, 5, "Tu, ó Senhor Deus, és tudo o que tenho. O meu futuro está em Tuas mãos. Tu diriges a minha vida.
"),
("Isaias", 41, 13, "Porque Eu, o Senhor teu Deus, te tomo pela tua mão direita. E te digo: não temas, eu te ajudo. "),
("Salmos", 27, 1, "O Senhor é a minha luz e a minha salvação. A quem temerei? O Senhor é a força da minha vida. De
quem me recearei?"),
("Apocalipse", 21, 4, "E Deus limpará dos seus olhos toda a lágrima."),
("Josue", 1, 9, "Seja forte e corajoso, não fique desanimado, nem tenha medo, porque Eu o Senhor seu Deus, estarei
com você em qualquer lugar por onde você passar. "),
("Lucas", 11, 28, "Felizes são os que ouvem a palavra de Deus e a guardam!"),
("Joao", 3, 16, "Porque Deus amou o mundo de tal maneira, que deu o seu filho unigênito para que todo aquele que
Nele crê não pereça, mas tenha a vida eterna."),
("Salmos", 11, 7, "Porque o Senhor é justo, e ama a justiça. O seu rosto olha para os retos.")
;

# A) Desenvolva um FULLTEXT na coluna “Texto”.
ALTER TABLE Biblia
ADD FULLTEXT (Texto);

# B) Confira se o índice foi adicionado.
SHOW INDEX FROM Biblia;

# C) Selecione o versículo e capítulo que a palavra “Senhor” aparece nos textos.
SELECT Versiculo, Capitulo FROM Biblia WHERE match(Texto) against("Senhor");

# D) Faça a seleção para contar quantas ocorrências a palavra “Senhor”, aparece no BD.
SELECT COUNT(*) FROM Biblia WHERE match(Texto) AGAINST("Senhor");

# E) Teste outras palavras: Deus e Força. Anote o versículo e os capítulos que as palavras aparecem, assim como, ao número de ocorrências de cada uma das palavras.
SELECT Versiculo,Capitulo FROM Biblia WHERE MATCH(Texto) AGAINST("Deus");
SELECT COUNT(*) FROM Biblia WHERE match(Texto) AGAINST("Deus");

SELECT Versiculo,Capitulo FROM Biblia WHERE MATCH(Texto) AGAINST("Força");
SELECT COUNT(*) FROM Biblia WHERE match(Texto) AGAINST("Força");

 /*----------------------------------*/
 DROP DATABASE LivroSagrado;

/****************************************************************************************************************************************************************/
#Exercício 1

# A) Desenvolva o BD do DER.
CREATE DATABASE Imobiliaria;
USE Imobiliaria;

CREATE TABLE Locador(
	CPF varchar(14),
	Telefone int(10) NOT NULL,
	Nome varchar(30) NOT NULL,
	PRIMARY KEY (CPF)
);

CREATE TABLE Imovel(
	CEP varchar(9),
	Endereco varchar(50) NOT NULL,
	Descricao varchar(50) NOT NULL,
	PRIMARY KEY (CEP)
);

CREATE TABLE Locatario(
	Numero int(6) AUTO_INCREMENT,
	Nome varchar(30) NOT NULL,
	Telefone int(10) NOT NULL,
	PRIMARY KEY (Numero)
);

CREATE TABLE Locacao(
	Id int(5) AUTO_INCREMENT PRIMARY KEY,
	Valor int(7) NOT NULL,
	CPFLocador_FK varchar(14) NOT NULL,
	CEPImovel_FK varchar(10) NOT NULL,
	NumeroLocatario_FK int(6), #Pelo DER, ele pode ser null
	FOREIGN KEY(CPFLocador_FK) REFERENCES Locador(CPF),
	FOREIGN KEY(CEPImovel_FK) REFERENCES Imovel(CEP),
	FOREIGN KEY(NumeroLocatario_FK) REFERENCES Locatario(Numero)
); 

# B) Insira diversos registros em todas as tabelas. (No campo “descrição” da tabela “Imóvel”, insira uma breve observação do imóvel).
INSERT Locador VALUES
("531-123-124-44",1192849134, "Armando Guerra"),
("513-543-677-11",1932134145, "José do Bom Fim"),
("501-213-513-90",1912345691, "Mila Ascaro");


INSERT Imovel VALUES
("41331-123", "Rua Algum Lugar do Mundo Nº349", "Suite,Banheiro,Cozinha,3 Quartos"),
("23513-213", "Rua Lacrador do Twitter Nº12", "2 Banheiro,Cozinha,1 Quarto, Piscina"),
("13415-512", "Rua Aranha Furtado Nº90", "Suite,Banheiro,Cozinha,2 Quartos, Jardim, Garagem"),
("12452-140", "Rua Ugo do Magi", "Imóvel estilo arábe, Suite,2 Banheiros, Cozinha,2 Quartos"),
("31231-512", "Avenida da Saudade Nº32", "Suite,Banheiro,Cozinha,3 Quartos, Jardim");

INSERT Locatario VALUES
(0, "Fujiro Nakombi", 1942490192),
(0, "Silas Cando", 1131565910),
(0, "Zeca Gado", 1141235910);

INSERT Locacao VALUES
(0, 500000, "531-123-124-44", "12452-140", 2),
(0, 100000, "501-213-513-90", "31231-512", 1),
(0, 150000, "513-543-677-11", "13415-512", 3);

INSERT Locacao(Id, Valor, CPFLocador_FK, CEPImovel_FK) VALUES
(0, 125000, "501-213-513-90", "23513-213"),
(0, 113000, "513-543-677-11", "41331-123");

# C) Desenvolva um índice na chave “Numero_Locatario” da tabela “Locação”
CREATE INDEX Numero_Locatario
 ON Locacao (NumeroLocatario_FK);

# D) Utilize o índice para procurar o nome e telefone dos locatários.
SELECT Locatario.Nome, Locatario.Telefone FROM Locatario
 INNER JOIN Locacao USE INDEX (Numero_Locatario)
 WHERE Locacao.NumeroLocatario_FK = Locatario.Numero;

# E) Utilize o índice para procurar o nome e telefone de um locatário em especifico (pode ser pelo nome).
SELECT Locatario.Nome, Locatario.Telefone FROM Locatario 
 INNER JOIN Locacao USE INDEX (Numero_Locatario) 
 WHERE Locacao.NumeroLocatario_FK = Locatario.Numero AND
 Locatario.Nome = "Fujiro Nakombi";

# F) Desenvolva um índice FULL TEXT no campo “descrição” da tabela “Imóvel”.
ALTER TABLE Imovel
ADD FULLTEXT (Descricao);

# G) Verifique se o índice foi criado (pesquise a instrução SQL).
SHOW INDEX FROM Imovel;

# H) Utilize o FULL TEXT para encontrar imóveis com a descrição: •Suíte; •Piscina; •Varanda; •Etc.
SELECT * FROM Imovel WHERE match(Descricao) against("Suite");

SELECT * FROM Imovel WHERE match(Descricao) against("Piscina");

SELECT * FROM Imovel WHERE match(Descricao) against("Varanda");

SELECT * FROM Imovel WHERE match(Descricao) against("Suite") AND match(Descricao) against("Jardim");

# I) Exclua o índice FULL TEXT(Pesquise o comando).
ALTER TABLE Imovel DROP INDEX Descricao;

/*----------------------------------*/
DROP DATABASE Imobiliaria;