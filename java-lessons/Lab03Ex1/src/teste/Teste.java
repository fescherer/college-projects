package teste;

import java.util.ArrayList;
import java.util.Collection;

import entidade.Produto;
import model.ModelCSV;

public class Teste {
	public static void main(String[] args) {
		ModelCSV m = new ModelCSV();
		Collection<Produto> produtos = m.loadProdutos();
		produtos.add(new Produto(1,"manteiga",4.00));
		produtos.add(new Produto(2,"jujuba",2.00));
		
		m.saveProdutos(produtos);
		for(Produto atual : produtos) {
			System.out.println(atual);
		}
	}
	

}
