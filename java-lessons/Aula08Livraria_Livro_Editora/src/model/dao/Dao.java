package model.dao;

import java.util.Collection;
import java.util.Map;

import entidades.Editora;
import entidades.Livro;

public interface Dao {
	
	public Collection<Livro> getLivros(String key);

	Map<Editora, Collection<Livro>> getEditoras(String key);

}
