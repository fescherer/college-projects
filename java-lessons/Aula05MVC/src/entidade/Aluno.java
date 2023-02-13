package entidade;

public class Aluno {
	
	private String id;
	private String nome;
	
	public Aluno(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public String getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
	

}
