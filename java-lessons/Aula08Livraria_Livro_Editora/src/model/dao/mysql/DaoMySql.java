package model.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import entidades.Editora;
import entidades.Livro;
import model.dao.Dao;

public class DaoMySql implements Dao {

	private static final String DATABASE = "faculdade";
	private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE + "?autoReconnect=true&useSSL=false";
	private static final String USER = "vinicius";
	private static final String PASS = "123456";
	
	@Override
	public Collection<Livro> getLivros(String key) {
		
		Collection<Livro> livros = new ArrayList<>();
		
		String query = 
				  "SELECT * FROM Books, Publishers "
				+ "WHERE LOWER(title) LIKE LOWER(?) AND "
				+ "Books.publisher_id=Publishers.publisher_id;";
		
		try(	Connection con = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement pstm = con.prepareStatement(query);
				){
			pstm.setString(1, "%" + key + "%");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				String titulo = rs.getString("title");
				String isbn = rs.getString("isbn");
				double preco = rs.getDouble("price");
				
				int id_editora = rs.getInt("publisher_id");
				String nomeEditora = rs.getString("name");
				String urlEditora = rs.getString("url");
				
				Editora editora = new Editora(id_editora, nomeEditora, urlEditora);
				
				Livro livro = new Livro(titulo, isbn, preco, editora);
				livros.add(livro);
				
			}
			
			
			System.out.println("conexao feita");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return livros;
	}

	@Override
	public Map<Editora, Collection<Livro>> getEditoras(String key) {
		
		Map<Editora, Collection<Livro>> editoras = new HashMap<>();
		
		String query = "SELECT * FROM Books, Publishers "
				+ "WHERE LOWER(name) LIKE LOWER(?) AND "
				+ "Books.publisher_id=Publishers.publisher_id "
				+ "ORDER BY name ASC";
		
		try(	Connection con = DriverManager.getConnection(URL, USER, PASS); 
				PreparedStatement pstm = con.prepareStatement(query);){
			pstm.setString(1, "%"+key+"%");
			ResultSet rs = pstm.executeQuery();
			Editora editoraAntiga = null;
			while(rs.next()) {
				int idEditora = rs.getInt("publisher_id");
				String nome = rs.getString("name");
				String url = rs.getString("url");
				
				Editora editora = new Editora(idEditora, nome, url);
				if( (editoraAntiga==null) || !editoraAntiga.equals(editora)) {
					editoraAntiga = editora;
					editoras.put(editora, new ArrayList<>());
				}
				
				String titulo = rs.getString("title");
				String isbn = rs.getString("isbn");
				double preco = rs.getDouble("price");
				
				Livro livro = new Livro(titulo, isbn, preco, editora);
				
				editoras.get(editora).add(livro);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return editoras;
		
	}
		
}
