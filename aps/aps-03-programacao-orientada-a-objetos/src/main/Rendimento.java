package main;

public class Rendimento  {
	private Nota np1;
	private Nota np2;
	private Nota reposicao;
	private Nota exame;
	private Nota media;
	private Aluno aluno;
	private Curso curso;

	private boolean isAprovado;
	//Constructor
	public Rendimento(Aluno aAluno, Curso aCurso, double aNp1, double aNp2, 
						double aReposicao, double aExame){
		this.np1 = new Nota(aNp1);
		this.np2 = new Nota(aNp2);
		this.reposicao = new Nota(aReposicao);
		this.exame = new Nota(aExame);
		this.aluno = aAluno;
		this.curso = aCurso;
		
		//Sempre que criarmos um rendimento, a media do aluno já será calculada automaticamente
		this.media = new Nota(calculaMediaFinal());
		
		//Sempre que criarmos um rendimento, ele será automaticamente adicionado ao TreeMap do curso
		curso.adicionarRendimento(this);
	}
	//Default Constructor
	public Rendimento() {
		this.curso = null;
		this.aluno = null;
		this.exame = null;
		this.np1 = null;
		this.np2 = null;
		this.reposicao = null;
		this.media = null;
	}
	//Getters
	public Aluno getAluno() {
		return this.aluno;
	}
	public Curso getCurso() {
		return this.curso;
	}	
	public Nota getNp1() {
		return this.np1;
	}
	public Nota getNp2() {
		return this.np2;
	}
	public Nota getReposicao() {
		return this.reposicao;
	}
	public Nota getExame() {
		return this.exame;
	}
	public Nota getMedia() {
		return this.media;
	}
	
	//Esse método funciona como um getter de isAprovado
	//Ele retorna uma string com a informação se o aluno foi ou não aprovado
	public String isAprovado() {
		String saida;
		if(isAprovado)
			saida = "O aluno foi aprovado!";
		else
			saida = "O aluno não foi aprovado!";
		return saida;
	}

	//Método para calcular a média do aluno
	private double calculaMediaInicial() {
		double media;
		//Por padrão deixaremos valor1 e valor2 como as notas da np1 e np2
		//Caso precisarmos, podemos mudar depois
        double valor1 = np1.getNota();
        double valor2 = np2.getNota();

        //Esse teste é feito, porque tem a chance das duas notas(NP1 e NP2) serem menores que a reposição
        //Por isso devemos saber qual a menor nota para poder substitui-la e deixar a outra nota intacta 
        if(valor1 > valor2) {
            if(reposicao.getNota() > valor2) 
                valor2 = reposicao.getNota();
             else if(reposicao.getNota() > valor1)
                valor1 = reposicao.getNota();
        }
        
        //Se o valor1 não for maior que o valor2, então teremos que testar de novo
        //Para ver se a reposicao devera substituir algum dos valores
        if(reposicao.getNota() > valor1) 
            valor1 = reposicao.getNota();
        else if(reposicao.getNota() > valor2)
            valor2 = reposicao.getNota();
        
        
		media = (valor1 + valor2) / 2;
		
		return media;
	}
	
	private double calculaMediaFinal() {
		//Nesse método, nós usamos as regras passadas pelo professor para calcular a nota final
		//Para ser aprovado em GRADUACAO deverá ter nota maior que 7
		//Para ser aprovado em PO_GRADUACAO deverá ter nota maior que 5
		double media = this.calculaMediaInicial();
		if(curso.getNivel().equals("GRADUACAO")) {
			if (media >= 7)
				isAprovado = true;
			else{
				media = (media + exame.getNota()) / 2;
				if (media >= 5)
					isAprovado = true;
				else
					isAprovado = false;
			}
		} else if(curso.getNivel().equals("POS_GRADUACAO")) {
			if (media >= 5)
				isAprovado = true;
			else{
				media = (media + exame.getNota()) / 2;
				if (media >= 5)
					isAprovado = true;
				else
					isAprovado = false;
			}
		}
	
		return media;
	}
	
	//toString
	public String toString() {
		String saida;
		saida = "Curso: " + curso.getNome() + " / " + "Nível: " 
				+ curso.getNivel() + " / " + "Ano: " 
				+ curso.getAno() + "\n" + aluno.toString();
		saida +="Nota NP1: " + np1.toString();
		saida +="Nota NP2: " + np2.toString();
		saida +="Nota Reposição: " + reposicao.toString();
		saida +="Nota Exame: " + exame.toString();
		saida +="Média: " + media.toString();
		saida +="Situação: " + this.isAprovado() + "\n";
		
		return saida;
	}
}
