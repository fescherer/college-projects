package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import entidade.Produto;
import model.Model;
import view.View;

public class Controller {
	private View view;
	private Model model;
	private boolean isPerishable = false;
	
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
		this.init();
	}
	
	public void init() {
		view.setMostraProdutoListener(new ComportamentoListaProdutos());
		view.setCadastraProdutoListener(new ComportamentoCadastraProduto());
		view.trocaFuncoes(new ComportamentoTrocaTipoProduto());
	}
	
	class ComportamentoListaProdutos implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Collection<Produto> produtos = model.loadProdutos(false);
			view.mostraProdutos(produtos);
		}
		
	}
	
	class ComportamentoTrocaTipoProduto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			isPerishable = !isPerishable;
			if(view.getButtonChangeText().equals("Normal")) {
				view.setButtonChangeText("Perishable");
				
			} else {
				view.setButtonChangeText("Normal");
			}
		}
		
	}
	
	class ComportamentoCadastraProduto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int id = view.getIdProduto();
			String nome = view.getNomeProduto();
			double valor = view.getValorProduto();
			Produto produto = new Produto(id, nome, valor);
			
			Collection<Produto> produtos = model.loadProdutos(false);
			produtos.add(produto);
			
			model.saveProdutos(produtos, false);
			
		}
		
	}


}
