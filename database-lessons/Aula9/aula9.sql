#Exemplo
create database TestProc;
use TestProc;
create table Test(
	Id int primary key auto_increment,
	Nome varchar(30),
	Valor int
	);

insert Test values
	(0, "AAA", 200),
	(0, "BBB", 300),
	(0, "CCC", 400),
	(0, "DDD", 500),
	(0, "EEE", 600),
	(0, "FFF", 700),
	(0, "GGG", 800),
	(0, "HHH", 900),
	(0, "III", 200),
	(0, "JJJ", 300),
	(0, "KKK", 400),
	(0, "LLL", 500),
	(0, "MMM", 600),
	(0, "NNN", 700),
	(0, "OOO", 800),
	(0, "PPP", 900),
	(0, "QQQ", 200),
	(0, "RRR", 300),
	(0, "SSS", 400),
	(0, "TTT", 500),
	(0, "UUU", 600),
	(0, "VVV", 700),
	(0, "XXX", 800),
	(0, "YYY", 900),
	(0, "WWW", 200),
	(0, "ZZZ", 100);

CREATE PROCEDURE proc_verNome(var_valor int)
SELECT Nome FROM Test WHERE Valor = var_valor; 

CALL proc_verNome(400);

SHOW PROCEDURE STATUS WHERE db = "TestProc";

DROP DATABASE TestProc;

----------------------------------------------------------------------------

#Exercício 1:
 #1)Uma prefeitura deseja um banco de dados estruturado a seguir que contenha os seguintes campos : Id: chaveprimaria.CPF: chave alternativa. Nome:Nome do munícipe. Endereço: Endereço do munícipe. Status:recebe 0 para munícipes com dívida e 1 para munícipes sem dívidas. Valor_IPTU: monetário não nulo
 CREATE DATABASE Prefeitura;
 USE Prefeitura;
 CREATE TABLE IPTU(
 	Id int(3) primary key auto_increment,
 	CPF bigint(11)not null,
 	Nome varchar(255)not null,
 	Endereco varchar(255)not null,
 	Status int not null,
 	Valor decimal(10,2) not null
 	);
 INSERT IPTU values
 	(0,"16250722839","Francis Singleton","7017 Mauris St.",1,1954.00),
 	(0,"16110209255","Otto Dawson","Ap #726-952 Tortor St.",0,0.00),
 	(0,"16101107287","Gareth Bryan","158-788 Congue Avenue",1,957.00),
 	(0,"16381024592","Murphy Carr","Ap #948-1503 Imperdiet St.",0,0.00),
 	(0,"16270720751","Oren Barry","4770 Velit Rd.",0,0.00),
 	(0,"16071021141","Edward Olson","P.O.Box810,4855 Massa St.",1,1800.00),
 	(0,"16771115491","Kelly Graham","1137 Nec Av.",0,0.00),
 	(0,"16140115400","Hayden Jordan","6071 Nulla Avenue",0,0.00),
 	(0,"16240411490","Stephen Farley","P.O.Box 745,5084 Ipsum. Av.",1,939.00),
 	(0,"16400101613","Herman Hood","Ap #628-1698 Gravida Avenue",1,645.00),
 	(0,"16740526299","Grady Howell","P.O.Box 533,1658 Feugiat.St.",1,1545.00),
 	(0,"16441114046","Gil Banks","P.O.Box 403,3729 Nisi.St.",0,0.00),
 	(0,"16390403472","Ishmael Hampton","7538 Ante Ave",1,1289.00),
 	(0,"16520906151","ColeBanks","1283Scelerisque,Ave",1,1087.00),
 	(0,"16790717410","Malcolm Pierce","Ap #985-3862 Amet Avenue",1,633.00),
 	(0,"16170405755","Luke Carrillo","9411 In Ave",1,1905.00),
 	(0,"16920418994","Declan Gill","Ap #709-4497 Dui,Street",1,828.00),
 	(0,"16780528023","Jakeem Stafford","P.O. Box 729, 9795Ut Street",1,613.00),
 	(0,"16841202688","Zachary Lambert","692-9158 Lorem Rd.",1,1445.00),
 	(0,"16230319167","KenyonW ilder","414 Eu Av.",1,1946.00),
 	(0,"16801102405","Lee Vazquez","687-3600 Libero Avenue",0,0.00),
 	(0,"16141125097","BenedictW eber","5913Massa.Rd.",0,0.00),
 	(0,"16471128893","Herrod Smith","756-8813 Sagittis Ave",1,1221.00),
 	(0,"16290526539","Jasper Mathis","Ap #658-8744 Non St.",1,1074.00),
 	(0,"16640904496","Lars Anderson","P.O.Box 804,6210 Ornare,Street",1,1245.00),
 	(0,"16720528862","Maxwell Velasquez","P.O. Box 904,678 Vel,Avenue",1,1110.00),
 	(0,"16371005068","Craig Mcmahon","523 Nibh St.",1,1710.00),
 	(0,"16681115272","Tucker Edwards","4618 Augue.Rd.",1,1732.00),
 	(0,"16030627361","Nash Fernandez","2622 Id Ave",1,1388.00),
 	(0,"16710227165","Chadwick Hunt","P.O.Box 969,5740 Nunc.St.",0,0.00),
 	(0,"16780706802","Samuel Underwood","209-9268 Lobortis Rd.",1,1431.00),
 	(0,"16151213536","Yasir Livingston","Ap #423-8313 Purus,St.",1,1139.00),
 	(0,"16970406136","Giacomo Ball","2657 Turpis Road",1,1453.00),
 	(0,"16470723556","Isaac Velazquez","570-3390 Proin Rd.",1,1424.00),
 	(0,"16640122792","Omar Montgomery","Ap #274-9274Lacus.St.",1,1280.00),
 	(0,"16540125849","Colt Roth","P.O. Box 924,1989 Est.Rd.",1,737.00),
 	(0,"16310927401","Moses Tanner","Ap #639-2798 Ante Rd.",0,0.00),
 	(0,"16370604524","Jonas Wilder","P.O.Box 826,2018 Vel, St.",0,0.00),
 	(0,"16470320223","Leo Logan","7844 Magna Rd.",0,0.00),
 	(0,"16100610105","Baxter Best","Ap #798-9814 Et, Av.",1,1403.00),
 	(0,"16001211827","Gary Watts","5810 Nisi St.",1,1267.00),
 	(0,"16150911994","Gavin Jones","Ap #121-418 Aliquam Ave",1,1209.00),
 	(0,"16730222762","Drew Myers","P.O.Box 744,9975 Odio Avenue",1,1032.00),
 	(0,"16350901028","Ethan George","P.O. Box 354,8155 Natoque St.",0,0.00),
 	(0,"16490312306","Carson Mills","Ap #672-6752 Semper Av.",1,714.00),
 	(0,"16611222454","Malachi Rivas","599-2971 Sapien.Road",1,1395.00),
 	(0,"16740524324","Prescott Perry","P.O. Box 537,1478 Vel Rd.",0,0.00),
 	(0,"16451206107","Nathaniel Patel","7860 Neque. Ave",1,1134.00),
 	(0,"16660930020","Solomon Cooke","354-4773 Montes, Avenue",1,838.00),
 	(0,"16000629547","Castor Swanson","Ap #542-7065 Aenean Av.",0,0.00),
 	(0,"16090919416","Noble Cox","P.O.Box 358,919 Enim Ave",1,1392.00),
 	(0,"16380811814","Phillip Hester","717-3208 Ipsum.Av.",1,819.00),
 	(0,"16650528271","Judah Talley","Ap #784-6873 Metus. Street",1,1853.00),
 	(0,"16300204507","Harlan Hinton","P.O. Box 144,6909 Nibh.Rd.",0,0.00),
 	(0,"16931115226","Raymond Myers","5147 In Road",0,0.00),
 	(0,"16620124592","Troy Webster","789-5976 Elit St.",1,1307.00),
 	(0,"16390809006","Yuli Hurst","P.O.Box 993, 3709 Posuere, St.",1,802.00),
 	(0,"16320521540","Jack Leon","1636 Nam St.",1,1765.00),
 	(0,"16720503501","Callum Nolan","P.O. Box 403,3708 Parturient St.",0,0.00),
 	(0,"16500804262","Boris Merritt","6580 Egestas Rd.",1,1148.00),
 	(0,"16111126533","Harrison Howe","7694 Ridiculus Ave",1,1019.00),
 	(0,"16071108063","Noah Mcfarland","5492 Erat Street",0,0.00),
 	(0,"16100522909","Calvin Ruiz","3438 Cursus St.",0,0.00),
 	(0,"16550501327","Deacon Walter","P.O. Box 806,2871 Imperdiet Road",1,1920),
 	(0,"16720401253","Hashim Jefferson","Ap #743-6305 Velit.Rd.",1,641.00),
 	(0,"16770824388","Hunter York","P.O. Box156, 3799 Blandit Road",1,1615.00),
 	(0,"16280530677","Lane Mccarty","P.O. Box756, 8692 EgetRd.",1,919.00),
 	(0,"16531014732","Bradley Cochran","P.O.Box 395,7094 Augue,Street",1,730.00),
 	(0,"16691215420","Zachery Winters","P.O.Box 940,9427 QuamRoad",1,1744.00),
 	(0,"16070613108","Dalton Rosario","Ap #777-458 Enim,Rd.",0,0.00),
 	(0,"16361022942","Zachery Callahan","Ap #911-1524 Vitae Street",0,0.00),
 	(0,"16381024592","Murphy Carr","Rua Palmeiras,1951",1,1000.00),
 	(0,"16270720751","Oren Barry","Av.1,n.1500",1,50.00),
 	(0,"16071021141","Edward Olson","Av. Pedro Alvares Cabral,1000",0,0.00),
 	(0,"16381024592","Murphy Carr","Av.Ipiranga,600",1,300.00);

# A) Desenvolva um procedimento para consultar o valor da dívida do IPTU e endereço dado o CPF no munícipe
CREATE PROCEDURE proc_consultaDivida(var_cpf bigint)
SELECT Valor, Endereco FROM IPTU WHERE CPF = var_cpf;

CALL proc_consultaDivida(16250722839);

# B) Realize consulta para os clientes de CPF: 16381024592; 16550501327; 16071021141.
CALL proc_consultaDivida(16381024592);
CALL proc_consultaDivida(16550501327);
CALL proc_consultaDivida(16071021141);

# C) Desenvolva um procedimento para consultar o nome, valor e endereço, dado o nome do munícipe
CREATE PROCEDURE proc_consultaNomeValorEndereco(var_nome varchar(255))
SELECT Nome, Valor, Endereco FROM IPTU WHERE Nome = var_nome;

CALL proc_consultaNomeValorEndereco("Francis Singleton");

# D) Realize consulta para os clientes:

CALL proc_consultaNomeValorEndereco("Oren Barry");
CALL proc_consultaNomeValorEndereco("Otto Dawson");
CALL proc_consultaNomeValorEndereco("Samuel Underwood");

# E) Exiba todos os procedimentos armazenados
SHOW PROCEDURE STATUS
WHERE db="Prefeitura";

# F) Desenvolva um procedimento que efetue a somatória do total de dívida, dado o status( Nomeie a saída como : “ Divida IPTU”).
CREATE PROCEDURE proc_somaDasDividas(var_status int)
SELECT SUM(Valor) as "Divida IPTU" FROM IPTU WHERE Status = var_status;

# G) Exiba o valor total da dívida.

CALL proc_somaDasDividas(1);

# H) Exclua o procedures desenvolvido na questão “a”.

DROP PROCEDURE proc_consultaDivida;