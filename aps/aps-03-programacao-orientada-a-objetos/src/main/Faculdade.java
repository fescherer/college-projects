package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import fileManager.Reader;

public class Faculdade {
	
	private TreeMap<String ,Aluno> alunos;
	private ArrayList<Curso> cursos;
	private TreeMap<Curso, TreeMap<Aluno, Rendimento>> relatorios; 
	
	private Reader reader;
	
	
	public Faculdade() throws IOException {
		//Inicializamos os treeMaps respons�veis por guardar os dados da faculdade
		alunos = new TreeMap<>();
		cursos = new ArrayList<>();
		reader = new Reader();
		relatorios = new TreeMap<Curso, TreeMap<Aluno, Rendimento>>(new CursoComparator());
		
		this.initFacul();
	}
	
	//Getters
	public TreeMap<String, Aluno> getAlunos() {
		return alunos;
	}
	public ArrayList<Curso> getCursos() {
		return cursos;
	}
	
	//M�todo para ler os arquivos e colocar os dados respectivos em cada cole��o
	private void initFacul() throws IOException {
	reader.readAluno(alunos);
	reader.readCurso(cursos);
	
	for(Curso c : cursos) {
		TreeMap<Aluno, Rendimento> rendimento = reader.readRelatorio(c, alunos);
		relatorios.put(c, rendimento);
	}
	
	}
	
	//M�todo para ler um relat�rio de curso espec�fico
	public TreeMap<Aluno, Rendimento> relatorioCurso(Curso aCurso) throws Exception{
		return reader.readRelatorio(aCurso, alunos);
	}
	
	//M�todo para pedir para o usus�rio qual � o curso
	public Curso retornaCurso() {
		Scanner in = new Scanner(System.in);
		System.out.println("Por gentileza, digite o nome do curso:\n");
		String nome = in.nextLine().toUpperCase();
		System.out.println("Por gentileza, digite o n�vel do curso:\n");
		String nivel = this.nivelCurso(in);
		System.out.println("Por gentileza, digite o ano do curso:\n");
		int ano = this.tratamentoInt(in);
		
		//Caso o "validaCurso" n�o encontre nenhum curso, o m�todo retorna null
		return this.validaCurso(nome, nivel, ano);
	}
	
	public Curso retornaCurso(Boolean criarCurso) {
		Scanner in = new Scanner(System.in);
		System.out.println("Por gentileza, digite o nome do curso:\n");
		String nome = in.nextLine().toUpperCase();
		System.out.println("Por gentileza, digite o n�vel do curso:\n");
		String nivel = this.nivelCurso(in);
		System.out.println("Por gentileza, digite o ano do curso:\n");
		int ano = this.tratamentoInt(in);
		
		if(criarCurso) {
			if(this.validaCurso(nome, nivel, ano) == null){
				Curso novoCurso = new Curso(nome, nivel, ano);
				return novoCurso;
			} else {
				System.out.println("Curso j� existe");
				return null;
			}
		}else //Caso o usu�rio coloque o par�metro criarCurso como falso, 
			 //o m�todo funciona como se n�o tivesse recebido nenhum par�metro
			return this.validaCurso(nome, nivel, ano);
	}
	
	//M�todo para tratar o n�vel de um curso
	public String nivelCurso(Scanner in) {
		String nivel = "";
		while(true) {
			System.out.println("Qual o nivel do curso?");
			System.out.println("1- Gradua��o\n2- P�s-Gradua��o");
			String opcaoNivel = in.nextLine();
			
			try {
				int opcaoNivelNumero = Integer.parseInt(opcaoNivel);
				if (opcaoNivelNumero == 1) {
					nivel = "GRADUACAO";
					return nivel;
					}
				else if(opcaoNivelNumero == 2) {
					nivel = "POS_GRADUACAO";
					return nivel;
					}
				else {
					System.out.println("Digite um n�mero v�lido");
					}
			} catch(Exception e) {
				System.out.println("Digite um n�mero v�lido");
			}
		}
	}
	
	//M�todo para tratar inteiros, ele s� retorna inteiro
	public int tratamentoInt(Scanner in) {
		int numeroTratado = 0;
		while(true) {
			System.out.println("Digite um n�mero: \n");
			String numero = in.next();
			try {
				numeroTratado = Integer.parseInt(numero);
				//1088 � o ano de cria��o da faculdade mais antiga do mundo :)
				if(numeroTratado >= 1088) {
					return numeroTratado;
				} else {
					System.out.println("A faculdade mais antiga do mundo foi criada em 1088, ou seja, seu ano � inv�lido");
					System.out.println("Digite um ano maior que 1087");
					}
			}catch(NumberFormatException e) {
				System.out.println("Digite um n�mero v�lido");
			}
		}
	}
	
	//M�todo para tratar notas
	public double tratamentoDouble(Scanner in, String aNota, Aluno aluno) {
		double numeroTratado = -1;
		while(true) {
			System.out.println("Digite o valor da nota " + aNota + " do aluno " + aluno.getNome() +"\n");
			String numero = in.next();
			try {
				numeroTratado = Double.parseDouble(numero);
				if(numeroTratado <= 10 && numeroTratado >= 0) {
					return numeroTratado;
				} else {
					System.out.println("As notas devem estar entre 0 e 10");
					}
			}catch(NumberFormatException e) {
				System.out.println("Digite um n�mero v�lido");
			}
		}
	}
	
	//M�todo para verificar se o curso existe
	public Curso validaCurso(String aNome, String aNivel, int aAno) {
		for(Curso cursoAtual : this.cursos) {
			if(cursoAtual.getNome().equals(aNome) 
					&& cursoAtual.getNivel().equals(aNivel) 
					&& cursoAtual.getAno() == aAno)
				return cursoAtual;
		}
		
		System.out.println("\nCurso n�o encontrado, verifique os dados");
		return null;
	}
	
	//M�todo para verificar se um aluno est� cadastrado
	public Aluno validaAluno(String aId) {
		if(alunos.containsKey(aId))
			return alunos.get(aId);
		
		System.out.println("Aluno com id " + aId + " n�o encontrado!");
		return null;
	}
	
	//M�todo para definir ID do aluno
	public String definirIdAluno() {
		String id = "";
		String ultimoId = alunos.lastKey();
		id = Long.toString(Math.incrementExact(Long.parseLong(ultimoId, 36)), 36);
		
		return id;
	}
	
	//M�todo para mostrar os rendimentos do aluno
	public void geraRendimentosAluno(Aluno aluno){
		boolean temRendimento = false;
		for(Curso c : cursos) {
			if(relatorios.containsKey(c)){
				if(relatorios.get(c).containsKey(aluno)) {
					temRendimento = true;
					System.out.println(relatorios.get(c).get(aluno));
					}
			}
		}	
	if(!temRendimento)
		System.out.println("Aluno n�o tem nenhum rendimento cadastrado");
	}
}
