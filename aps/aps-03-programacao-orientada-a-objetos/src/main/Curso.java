package main;


import java.util.TreeMap;

public class Curso implements Comparable<Curso>{
	//Essa classe guarda informações sobre um curso
	private String nome;
	private String nivel;
	private int ano;
	private TreeMap<Aluno,Rendimento> rendimentos;
	
	//Default Constructor
	public Curso() {
		this.nome = "";
		this.nivel = "";
		this.ano = 0;
	}
	//Constructor
	public Curso(String aNome, String aNivel, int aAno) {
		this.ano = aAno;
		this.nivel = aNivel;
		this.nome = aNome;
//		this.alunos = new ArrayList<>();
		this.rendimentos = new TreeMap<>(new AlunoComparator());
	}
	
	
	//Getters
	public String getNome() {
		return this.nome;
	}
	
	public String getNivel() {
		return this.nivel;
	}
	
	public int getAno() {
		return this.ano;
	}
	
	public TreeMap<Aluno,Rendimento> getRendimentos() {
		return this.rendimentos;
	}
	
	//Podemos deixar esse método protected porque ele só será usado na classe Rendimento
	//Assim só será visivel para as classes no mesmo pacote
	protected void adicionarRendimento(Rendimento rendimento) {
		if (rendimento.getAluno() != null) {
			this.rendimentos.put(rendimento.getAluno(), rendimento);
		}
	}
	
	
	//Equals personalizado
	//O equals não sabe o que comparar quando se trata de objetos
	//Nós fizemos com que ele compare os 3 atributos dessa classe
	@Override
	public boolean equals(Object obj) {
		int var = 3;
		if (obj instanceof Curso) {
			//Como sabemos que o obj é instancia de Curso, podemos transforma-lo em Curso
			Curso curso = (Curso) obj;
			//O compareTo retorna 0 se os valores são iguais
			if (this.getNome().compareTo(curso.getNome()) == 0) 
				var--;
			if (this.getNivel().compareTo(curso.getNivel()) == 0) 
				var--;
			if (this.getAno() == (curso.getAno())) 
		        var--;
		}
		//Se ele não passar pelos 3 ifs, quer dizer que algum dos valores não são iguais
		if (var != 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//Imprimi os atributos da classe
	public String toString() {
		String saida;
		saida = "Nome do Curso: " + this.nome + "\n" 
				+ "Nível: " + this.nivel + "\n"
				+ "Ano: " + this.ano + "\n" ;
		return saida;
	}
	
	 @Override 
	 public int compareTo(Curso outroCurso) { 
		 if(this.ano != outroCurso.ano) 
			 return Integer.compare(this.ano, outroCurso.ano); 
		 if(!(this.nivel.equals(outroCurso.nivel))) 
		 return this.nivel.compareTo(outroCurso.nivel);
		 if(!(this.nome.equals(outroCurso.nome))) 
			 return this.nome.compareTo(outroCurso.nome);
		 
		 return this.nome.compareTo(outroCurso.nome);
	}
}
