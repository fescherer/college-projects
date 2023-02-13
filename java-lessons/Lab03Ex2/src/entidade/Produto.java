package entidade;

public class Produto {
	
	private int id;
	private String nome;
	private double valor;
	
	public Produto(int id, String nome, double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public double getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
	}
	
	
	
	

}
