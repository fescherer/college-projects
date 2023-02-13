package view.janela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidade.Produto;
import view.View;

public class Janela extends JFrame implements View {
	
	DefaultTableModel dtm;
	JTable tabela;
	
	JButton botaoListar = new JButton("Listar");
	JButton botaoCadastrar = new JButton("Cadastrar");
	
	JTextField tfId = new JTextField(20);
	JTextField tfNome = new JTextField(20);
	JTextField tfValor = new JTextField(20);
	
	public Janela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		dtm = new DefaultTableModel(new Object[] {"Id", "Nome", "Valor"}, 0);
		tabela = new JTable(dtm);
		JScrollPane panelTabela = new JScrollPane(tabela);
		add(panelTabela, BorderLayout.CENTER);
		
		JPanel panelTxtBotoes = new PanelTxtBotoes();
		add(panelTxtBotoes, BorderLayout.PAGE_END);
		
		pack();
		setVisible(true);
	}
	
	class PanelTxtBotoes extends JPanel {
		public PanelTxtBotoes() {
			setLayout(new BorderLayout());
			
			JPanel panelTxt = new JPanel(new GridLayout(3, 1));
			add(panelTxt, BorderLayout.CENTER);
			panelTxt.add(new PanelLabelTxField("Id", tfId));
			panelTxt.add(new PanelLabelTxField("Nome", tfNome));
			panelTxt.add(new PanelLabelTxField("Valor", tfValor));
			
			JPanel panelBotoes = new JPanel(new GridLayout(2, 1, 5, 5));
			panelBotoes.add(botaoListar);
			panelBotoes.add(botaoCadastrar);
			add(panelBotoes, BorderLayout.LINE_END);
		}
	}

	class PanelLabelTxField extends JPanel {
		public PanelLabelTxField(String txtLabel, JTextField txtFld) {
			setLayout(new FlowLayout());
			add(new JLabel(txtLabel));
			add(txtFld);
		}
	}

	@Override
	public void setMostraProdutoListener(ActionListener al) {
		botaoListar.addActionListener(al);
	}

	@Override
	public void mostraProdutos(Collection<Produto> produtos) {
		dtm.setNumRows(0);
		for(Produto produto: produtos) {
			Object[] linha = new Object[] {produto.getId(), produto.getNome(), produto.getValor()};
			dtm.addRow(linha);
		}
	}
	
	@Override
	public void setCadastraProdutoListener(ActionListener al) {
		botaoCadastrar.addActionListener(al);
	}

	@Override
	public int getIdProduto() {
		return Integer.parseInt(tfId.getText());
	}

	@Override
	public String getNomeProduto() {
		return tfNome.getText();
	}

	@Override
	public double getValorProduto() {
		return Double.parseDouble(tfValor.getText());
	}

}
