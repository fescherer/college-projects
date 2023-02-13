package menu;

import java.io.IOException;
import java.util.Scanner;

public class View {
	public Action getAction() {
		System.out.println("//---------------------------------------//");
		System.out.println("Bem-vindo Usuário !");
		System.out.println("Escolha uma das opções abaixo: " + "\n" +
					       "1- Listar todos os cursos" + "\n" + 
					       "2- Listar dados do curso" + "\n" +
					       "3- Listar todos os alunos" + "\n" +
					       "4- Listar dados do aluno" + "\n" +
					       "5- Adicionar aluno" + "\n" +
					       "6- Adicionar curso" + "\n" +
					       "7- Adicionar rendimento" + "\n" +
					       "8- Sair");
		System.out.println("//---------------------------------------//");
		Action resposta = null;
		try {
			resposta = getEscolhaOpcoes();
		}
		//Aqui ele poderia pegar um AcaoNaoExisteException também
		catch(Exception E) {
			System.out.println("Erro. Opção não existente.");
			return getAction();
		}
		return resposta;
	}
	
	private Action getEscolhaOpcoes() throws AcaoNaoExisteException {
		Scanner in = new Scanner(System.in);
		String escolha = in.next();
		switch(escolha) {
			case "1":
				return Action.LISTARTODOSOSCURSOS;
			case "2":
				return Action.LISTARDADOSDOCURSO;
			case "3":
				return Action.LISTARTODOSOSALUNOS;
			case "4":
				return Action.LISTARDADOSDOALUNO;
			case "5":
				return Action.ADICIONARALUNO;
			case "6":
				return Action.ADICIONARCURSO;
			case "7":
				return Action.ADICIONARRENDIMENTO;
			case "8":
				return Action.SAIR;
			case "":
				throw new AcaoNaoExisteException();
			default: throw new AcaoNaoExisteException();
		}
	}
	
	public class AcaoNaoExisteException extends IOException{

		private static final long serialVersionUID = 1L;
		
	}
}
