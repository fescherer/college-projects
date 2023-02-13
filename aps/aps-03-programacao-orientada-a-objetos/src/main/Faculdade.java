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
		//Inicializamos os treeMaps responsáveis por guardar os dados da faculdade
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
	
	//Método para ler os arquivos e colocar os dados respectivos em cada coleção
	private void initFacul() throws IOException {
	reader.readAluno(alunos);
	reader.readCurso(cursos);
	
	for(Curso c : cursos) {
		TreeMap<Aluno, Rendimento> rendimento = reader.readRelatorio(c, alunos);
		relatorios.put(c, rendimento);
	}
	
	}
	
	//Método para ler um relatório de curso específico
	public TreeMap<Aluno, Rendimento> relatorioCurso(Curso aCurso) throws Exception{
		return reader.readRelatorio(aCurso, alunos);
	}
	
	//Método para pedir para o ususário qual é o curso
	public Curso retornaCurso() {
		Scanner in = new Scanner(System.in);
		System.out.println("Por gentileza, digite o nome do curso:\n");
		String nome = in.nextLine().toUpperCase();
		System.out.println("Por gentileza, digite o nível do curso:\n");
		String nivel = this.nivelCurso(in);
		System.out.println("Por gentileza, digite o ano do curso:\n");
		int ano = this.tratamentoInt(in);
		
		//Caso o "validaCurso" não encontre nenhum curso, o método retorna null
		return this.validaCurso(nome, nivel, ano);
	}
	
	public Curso retornaCurso(Boolean criarCurso) {
		Scanner in = new Scanner(System.in);
		System.out.println("Por gentileza, digite o nome do curso:\n");
		String nome = in.nextLine().toUpperCase();
		System.out.println("Por gentileza, digite o nível do curso:\n");
		String nivel = this.nivelCurso(in);
		System.out.println("Por gentileza, digite o ano do curso:\n");
		int ano = this.tratamentoInt(in);
		
		if(criarCurso) {
			if(this.validaCurso(nome, nivel, ano) == null){
				Curso novoCurso = new Curso(nome, nivel, ano);
				return novoCurso;
			} else {
				System.out.println("Curso já existe");
				return null;
			}
		}else //Caso o usuário coloque o parâmetro criarCurso como falso, 
			 //o método funciona como se não tivesse recebido nenhum parãmetro
			return this.validaCurso(nome, nivel, ano);
	}
	
	//Método para tratar o nível de um curso
	public String nivelCurso(Scanner in) {
		String nivel = "";
		while(true) {
			System.out.println("Qual o nivel do curso?");
			System.out.println("1- Graduação\n2- Pós-Graduação");
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
					System.out.println("Digite um número válido");
					}
			} catch(Exception e) {
				System.out.println("Digite um número válido");
			}
		}
	}
	
	//Método para tratar inteiros, ele só retorna inteiro
	public int tratamentoInt(Scanner in) {
		int numeroTratado = 0;
		while(true) {
			System.out.println("Digite um número: \n");
			String numero = in.next();
			try {
				numeroTratado = Integer.parseInt(numero);
				//1088 é o ano de criação da faculdade mais antiga do mundo :)
				if(numeroTratado >= 1088) {
					return numeroTratado;
				} else {
					System.out.println("A faculdade mais antiga do mundo foi criada em 1088, ou seja, seu ano é inválido");
					System.out.println("Digite um ano maior que 1087");
					}
			}catch(NumberFormatException e) {
				System.out.println("Digite um número válido");
			}
		}
	}
	
	//Método para tratar notas
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
				System.out.println("Digite um número válido");
			}
		}
	}
	
	//Método para verificar se o curso existe
	public Curso validaCurso(String aNome, String aNivel, int aAno) {
		for(Curso cursoAtual : this.cursos) {
			if(cursoAtual.getNome().equals(aNome) 
					&& cursoAtual.getNivel().equals(aNivel) 
					&& cursoAtual.getAno() == aAno)
				return cursoAtual;
		}
		
		System.out.println("\nCurso não encontrado, verifique os dados");
		return null;
	}
	
	//Método para verificar se um aluno está cadastrado
	public Aluno validaAluno(String aId) {
		if(alunos.containsKey(aId))
			return alunos.get(aId);
		
		System.out.println("Aluno com id " + aId + " não encontrado!");
		return null;
	}
	
	//Método para definir ID do aluno
	public String definirIdAluno() {
		String id = "";
		String ultimoId = alunos.lastKey();
		id = Long.toString(Math.incrementExact(Long.parseLong(ultimoId, 36)), 36);
		
		return id;
	}
	
	//Método para mostrar os rendimentos do aluno
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
		System.out.println("Aluno não tem nenhum rendimento cadastrado");
	}
}
