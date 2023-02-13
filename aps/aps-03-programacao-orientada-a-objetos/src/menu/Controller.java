package menu;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import fileManager.Writer;
import main.Aluno;
import main.Curso;
import main.Faculdade;
import main.Rendimento;

public class Controller {
	View view;
	
	public Controller(View aView) {
		this.view = aView;
	}
	
	public void init(Faculdade faculdade) throws Exception {
		//Lemos os arquivos com os cursos e os alunos
		Writer writer = new Writer();

		//Menu
		Action resposta = null;
		while(resposta != Action.SAIR) {
			
			resposta = view.getAction();
			
			if(resposta == Action.LISTARTODOSOSCURSOS) {
				System.out.println("Opção 1 escolhida! Listando todos os cursos:\n");
				for(Curso curso : faculdade.getCursos()) {
					System.out.println(curso);
				}				
				
			}else if(resposta == Action.LISTARDADOSDOCURSO) {
				System.out.println("Opção 2 escolhida! Listar dados de um curso:\n");
				Curso curso = faculdade.retornaCurso();
				
				if(curso != null) {
					TreeMap<Aluno ,Rendimento> rendimentos = faculdade.relatorioCurso(curso);
					if(rendimentos.isEmpty())
						System.out.println("Esse curso não tem dados");
					if(rendimentos != null)
						for (Map.Entry<Aluno, Rendimento> r : rendimentos.entrySet())
							System.out.println(r.getValue());
				}
				
			}else if(resposta == Action.LISTARTODOSOSALUNOS) {
				System.out.println("Opção 3 escolhida! Listando todos os alunos:\n");
				for(Map.Entry<String, Aluno> aluno : faculdade.getAlunos().entrySet()) {
					System.out.println(aluno.getValue());
				}
				
			}else if(resposta == Action.LISTARDADOSDOALUNO) {
				System.out.println("Opção 4 escolhida! Listar dado de um aluno:\n");
				Scanner in = new Scanner(System.in);
				System.out.println("Por gentileza, digite o id do aluno:\n");
				String id = in.next();
				if(faculdade.validaAluno(id) != null) {
					faculdade.geraRendimentosAluno(faculdade.getAlunos().get(id));
				}
			}else if(resposta == Action.ADICIONARALUNO) {
				System.out.println("Opção 5 escolhida! Adicionar um aluno:\n");
				Scanner in = new Scanner(System.in);
				System.out.println("Qual o nome do aluno?\n");
				String nome = in.nextLine();
				Aluno novoAluno = new Aluno(faculdade.definirIdAluno(), nome);
				faculdade.getAlunos().put(novoAluno.getId(), novoAluno);
				System.out.println("Aluno adicionado");
				writer.writeAluno(novoAluno);
				
			}else if(resposta == Action.ADICIONARCURSO) {
				System.out.println("Opção 6 escolhida! Adicionar um curso:\n");
				Curso novoCurso = faculdade.retornaCurso(true);
				
				if(novoCurso != null) {
					faculdade.getCursos().add(novoCurso);
					System.out.println("Curso com nome " 
										+ novoCurso.getNome() + ", "
										+ "nivel " + novoCurso.getNivel() + 
										" e ano " + novoCurso.getAno() + 
										" foi adicionado com sucesso!");
					writer.writeCurso(novoCurso);
					writer.writeRelatorio(novoCurso);
					faculdade.getCursos().add(novoCurso);
					}
					
			}else if(resposta == Action.ADICIONARRENDIMENTO) {
				
				System.out.println("Opção 7 escolhida! Adicionar um rendimento:\n");
				Scanner in = new Scanner(System.in);

				System.out.println("Por gentileza, digite o id do aluno:\n");
				String idAluno = in.nextLine();
				//Essa é uma verificação feita para ver se esse ID digitado corresponde a algum aluno
				Aluno aluno = faculdade.validaAluno(idAluno);
				
				if(aluno != null) {
					System.out.println("Aluno: " + aluno.getNome() + ", com id: " + aluno.getId() );
					Curso curso = faculdade.retornaCurso();
					if(curso != null) {
						System.out.println("Curso encontrado!");
						double np1 = faculdade.tratamentoDouble(in, "np1", aluno);
						double np2 = faculdade.tratamentoDouble(in, "np2", aluno);
						double reposicao = faculdade.tratamentoDouble(in, "reposição", aluno);
						double exame = faculdade.tratamentoDouble(in, "exame", aluno);						
						
						new Rendimento(aluno, curso, np1, np2, reposicao, exame);
						writer.writeRelatorio(curso);
						System.out.println("Rendimento adicionado!");
						
						
					}
				}

			}
		}
		
		System.out.println("Opção 8 escolhida! Sair\n");
		System.out.println("Programa finalizado!");
		
	}
}
