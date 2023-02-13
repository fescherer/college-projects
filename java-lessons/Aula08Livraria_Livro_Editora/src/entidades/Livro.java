package entidades;

public class Livro {
	
	String titulo;
	String isbn;
	double preco;
	Editora editora;
	
	public Livro(String titulo, String isbn, double preco, Editora editora) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.preco = preco;
		this.editora = editora;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public double getPreco() {
		return preco;
	}

	public Editora getEditora() {
		return editora;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", isbn=" + isbn + ", preco=" + preco + ", editora=" + editora + "]";
	}
	
	

}
