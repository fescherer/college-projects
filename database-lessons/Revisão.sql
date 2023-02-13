/*
┌───── •✧✧• ──────────┐
 -Super Revisão de Sql-   (▀̿Ĺ̯▀̿ ̿)
└───── •✧✧• ──────────┘
Neste arquivo você verá os principais conceitos de SQL usados nas aulas
*/

/*OBSERVAÇÕES ╚(ಠ_ಠ)=┐
1ª Em SQL não usamos a palavra "Código", mas sim "Instrução". Ou seja, eu não faço códigos em SQL, mas sim instruções
2ª SQL é uma linguagem que não se importa com as intruções em maiúsculo ou minúsculo, ou seja, ela NÃO É case sensitive, mas usamos letras diferentes para facilitar a compreensão
*/
---------------------------------------------------------------------------------
--Primeiramente devemos configurar o mysql para sempre criar tabelas com a engine InnoDB. A Engine padrão na maioria das instalações é a MyISAM. Podemos ver quais engines existem digitando o comando:
 SHOW ENGINES;

--O correto é mudar nos arquivos, vá na pasta onde o mysql está instalado e abra o arquivo my.ini e em seguida troque a linha  default-storage-engine = x para  default-storage-engine = InnoDB
--https://dba.stackexchange.com/questions/96/how-can-i-change-the-default-storage-engine-in-phpmyadmin

--Criar um banco de dados: CREATE DATABASE Nome
CREATE DATABASE Faculdade;

--Usar um banco de dados: USE Nome;
USE Faculdade;

--Criar tabelas: CREATE TABLE Nome(NomeDaColuna TipoDoDado(Parâmetro));
--Obs. Geralmente o "Parâmetro" é o tamanho que esse campo irá possuir
CREATE TABLE Cursos(
	Nome varchar(40),
	Ano int(4),
	Duracao float(2)
	);

--Para ver quais campos da tabela: DESCRIBE Nome; ou DESC Nome;
DESCRIBE Cursos;

DESC Cursos;

--Listar Banco de dados: SHOW DATABASES;
SHOW DATABASES;

--Listar Tabelas de um banco de dados(Fazer a instrução do USE antes): SHOW TABLES;
SHOW TABLES;

--Excluir uma tabela de um Banco de Dados: DROP TABLE Nome;
DROP TABLE Cursos;

--Excluir todos os dados dentro de uma tabela: TRUNCATE Nome;
TRUNCATE Cursos;

--Excluir um Banco de Dados: DROP DATABASE Nome;
DROP DATABASE Faculdade;

--Adicionar uma coluna a tabela: ALTER TABLE Nome ADD NomeCampo tipoCampo(parametro)
ALTER TABLE Cursos ADD Sigla char(5);

--Excluir uma coluna: ALTER TABLE Nome DROP COLUMN NomeCampo
ALTER TABLE Cursos DROP COLUMN Sigla;

--Modificar o tipo de um campo: ALTER TABLE table_name MODIFY column_name datatype;
ALTER TABLE Cursos MODIFY Nome varchar(45);

--Renomear uma tabela: ALTER TABLE table_name RENAME new_table_name;
ALTER TABLE Cursos RENAME Aulas;

--Renomear uma coluna de uma tabela: ALTER TABLE table_name CHANGE column_name new_column_name datatype (parameter);
ALTER TABLE Cursos CHANGE Duracao Tempo int(4);


--Inserir valores: INSERT table_name VALUES(value1, value2, value3...);
INSERT Cursos VALUES("HISTÓRIA", 2020, 50);

--Inserir valores específicos: INSERT table_name (column1, column2...) VALUES(value1, value2...);
INSERT Cursos (Nome, Duracao) VALUES("MATEMATICA", 80);

--Mostrar os valores de uma tabela: SELECT * FROM table_name
--O "*" significa que irá mostrar TODOS os campos da tabela
SELECT * FROM Cursos;

--Mostrar somente alguns valores de uma tabela: SELECT column_1, column2, column3 from table_name;
SELECT Nome, Ano from Cursos;

--Mostrar valores de uma tabela que precisem satisfazer uma condição: SELECT * from table_name WHERE Column_name = something
SELECT * FROM Cursos WHERE Nome = "HISTORIA";
--Podemos usar operadores lógicos também
SELECT * FROM Cursos WHERE Nome = "HISTORIA" AND Duracao = 20;

--Podemos fazer uma busca mais genérica, que apenas tenha um certo padrão em sua estutura: SELECT * FROM table_name WHERE Column_name LIKE pattern
--Lembrando que o SQL não é case sensitive, pode escrever com letra maiúscula ou minúscula
SELECT * FROM Cursos WHERE Nome LIKE "H%"; --Irá procurar todos os valores que COMECEM com H
SELECT * FROM Cursos WHERE Nome LIKE "%A"; --Irá procurar todos os valores que TERMINEM com A
SELECT * FROM Cursos WHERE Nome LIKE "%ORI%"; --Irá procurar todos os valores que tenham "ORI", não impotando a posição
SELECT * FROM Cursos WHERE Nome LIKE "___T%"; --Irá procurar todos os valores que tenham T na 3ª posição (Lembrando que a contagem começa em 0)
SELECT * FROM Cursos WHERE Nome LIKE "H___%"; --Irá procurar todos os valores que comecem com H e tenham no mínimo 3 caracteres em largura além do H
SELECT * FROM Cursos WHERE Nome LIKE "H%A"; --Irá procurar todos os valores que comecem com H e terminem com A

--Quando a coluna tiver um nome não muito legal de se vizualizar, como por exemplo "NomeCliente", podemos dar um apelido, um alias para esse campo: SELECT column_name AS column_alias_name FROM table_name;
SELECT Nome AS NomeCurso, Ano AS "Ano Curso" FROM Cursos; --Podemos colocar entre aspas para colocar espaços ou entre ``
--Podemos fazer algo muito legal com o alias, que é juntar campos em somente um. Concatenamos a string com o CONCAT
SELECT CONCAT(Nome, ",", Ano, ",", Duracao) AS `Nome Ano Duracao` from Cursos; --Isso pode ser usado para endereços, onde tem o campo "Cidade", "Rua", "Numero" por exemplo
--Outro jeito de concatenar strings é com o CONCAT_WS(caractere, string). Ele concatena a string com a separação de caracteres (No caso, o caractere é o primeiro a ser digitado)
SELECT CONCAT_WS(', ', Nome, Ano, Duracao) AS `Nome Ano Duracao` from Cursos; --Esse eu achei melhor

--Podemos fazer um alias de uma tabela. Fazendo-o poderemos acessar os campos dessa tabela por nome_alias.nome_campo
--Para fazer um alias de uma tabela usamos: table_name AS table_alias_name OBS:Podemos omitir o AS e escrever somente: table_name table_alias_name 
SELECT CursosDiurnos.Nome from Cursos AS CursosDiurnos; --Isso será muito útil quando fizermos o select com mais de uma tabela que tenham um campo com o mesmo nome

--Muitas vezes, teremos valores repetidos nas tabelas e por isso queremos selecionar somente as que tenham valores distintos, assim usando o DISTINCT
--Para usar DISTINCT: SELECT DISTINCT column_name FROM table_name;
SELECT DISTINCT Nome FROM Cursos;

--Podemos organizar valores usando o order by: SELECT * FROM table_name ORDER BY (DESC|ASC)(ASC É PADRÃO)
SELECT * FROM Cursos ORDER BY Ano; --Ordenação crescente
SELECT * FROM Cursos ORDER BY Ano DESC; --Ordenação decrescente
--Podemos passar mais de um parâmetro para a organização
SELECT * FROM Cursos ORDER BY Ano, Nome; --Ele irá organizar primeiro por ano, caso tenha anos iguais, ele organiza por nome







