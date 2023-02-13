package teste;

import java.util.ArrayList;
import java.util.Collection;

import entidade.Produto;
import model.ModelCSV;

public class Teste {
	public static void main(String[] args) {
		ModelCSV m = new ModelCSV();
		Collection<Produto> produtos = m.loadProdutos(true);
		
		//m.saveProdutos(produtos, false);
		for(Produto atual : produtos) {
			System.out.println(atual);
		}
	}
	

}
