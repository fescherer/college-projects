package main;

public class Aluno {
	//Esta classe guarda informações sobre um aluno
	private String id;
	private String nome;
	
	//Default Constructor
	public Aluno() {
		this.id = "";
		this.nome = "";
		
	}
	
	//Constructor
	public Aluno(String aId, String aNome) {
		this.id = aId;
		this.nome = aNome;
	}
	
	
	//Getters
	public String getId() {
		return this.id;
	}
	public String getNome() {
		return this.nome;
	}
	
	
	//Imprimi os atributos da classe
	public String toString() {
		String saida;
		saida = "Id: " + this.id + "\n" + "Nome: " + this.nome + "\n";
		return saida;
	}
}

