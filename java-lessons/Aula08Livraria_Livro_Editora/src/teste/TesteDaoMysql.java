package teste;

import java.util.Collection;
import java.util.Map;

import entidades.Editora;
import entidades.Livro;
import model.dao.Dao;
import model.dao.mysql.DaoMySql;

public class TesteDaoMysql {
	
	public static void main(String[] args) {
		Dao dao = new DaoMySql();
//		Collection<Livro> livros = dao.getLivros("Art");
//		
//		for(Livro l: livros) {
//			System.out.println(l);
//		}
		Map<Editora, Collection<Livro>> editoras = dao.getEditoras("so");
		for(Editora e: editoras.keySet()) {
			System.out.println(e);
			Collection<Livro> livros = editoras.get(e);
			for(Livro l: livros) {
				System.out.println("\t" + l);
			}
		}
		
	}

}
