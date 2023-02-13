package view.janela_simples;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;

import entidade.Produto;
import view.View;

public class JanelaSimples extends JFrame implements View {
	
	JButton botaoListar = new JButton("Listar");
	JButton botaoCadastrar = new JButton("Cadastrar");
	
	ActionListener cadastraListener;
	JanelaCadastrar janelaCadastrar;
	
	public JanelaSimples() {
		setLayout(new GridLayout(1, 2));
		add(botaoListar);
		add(botaoCadastrar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
		botaoCadastrar.addActionListener(new AtivaJanelaCadastrar());
	}
	
	class AtivaJanelaCadastrar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			janelaCadastrar = new JanelaCadastrar();
			janelaCadastrar.setCadastrarListener(cadastraListener);
		}
		
	}

	@Override
	public void setMostraProdutoListener(ActionListener al) {
		botaoListar.addActionListener(al);
	}

	@Override
	public void mostraProdutos(Collection<Produto> produtos) {
		new JanelaTabela(produtos);
	}

	@Override
	public void setCadastraProdutoListener(ActionListener al) {
		cadastraListener = al;
	}

	@Override
	public int getIdProduto() {
		return janelaCadastrar.getId();
	}

	@Override
	public String getNomeProduto() {
		return janelaCadastrar.getNome();
	}

	@Override
	public double getValorProduto() {
		return janelaCadastrar.getValor();
	}

}
