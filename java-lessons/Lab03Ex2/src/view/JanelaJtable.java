package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidade.Produto;


public class JanelaJtable extends JFrame implements View{
	private static final long serialVersionUID = 1L;
	JTable table;
	DefaultTableModel modelTable;
	JButton buttonVerify;
	JButton buttonAddCell;
	JButton buttonChange;
	
	JTextField txtField1 = new JTextField(10);
	JTextField txtField2 = new JTextField(10);
	JTextField txtField3 = new JTextField(10);
	
	public JanelaJtable(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,600);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		//panel that holds the data
		modelTable = new DefaultTableModel(new Object[] {"id","nome","valor"}, 0) {
			private static final long serialVersionUID = 1L;
			//This is in charge of prevent cell editing
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(modelTable);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane painelDados = new JScrollPane(table);
		add(painelDados, BorderLayout.CENTER);
		
		//Panel that holds bottom part
		JPanel panelBottom = new JPanel();
		panelBottom.setLayout(new BorderLayout());
		add(panelBottom,BorderLayout.PAGE_END);
		
		//Panel that holds table to add
		JPanel panelAddTable = new JPanel();
		panelAddTable.setLayout(new GridLayout(3, 1, 40, 5));
		panelAddTable.add(new PanelLabelTextField(txtField1, "ID"));
		panelAddTable.add(new PanelLabelTextField(txtField2, "Nome"));
		panelAddTable.add(new PanelLabelTextField(txtField3, "Valor"));
		
		panelBottom.add(panelAddTable, BorderLayout.CENTER);
		
		//Panel that holds button verify
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new GridLayout(3,1,40,5));
		buttonVerify = new JButton("Verify");
		buttonAddCell = new JButton("Add");
		buttonChange = new JButton("Perishable");
		panelButton.add(buttonVerify);
		panelButton.add(buttonAddCell);
		panelButton.add(buttonChange);
		panelBottom.add(panelButton,BorderLayout.LINE_END);
		
		
		pack();
		setVisible(true);
	}
	
	class PanelLabelTextField extends JPanel{
		private static final long serialVersionUID = 1L;
		
		public PanelLabelTextField(JTextField txt, String label) {
			add(new JLabel(label));
			add(txt);	
		}
		
	}
	
	@Override
	public void setPerisiblePanel() {
		
	}
	
	@Override
	public void setMostraProdutoListener(ActionListener al) {
		buttonVerify.addActionListener(al);
	}

	@Override
	public void mostraProdutos(Collection<Produto> produtos) {
		modelTable.setRowCount(0);
		for(Produto p : produtos) {
			Object[] row = new Object[] {p.getId(), p.getNome(),p.getValor()};
			modelTable.addRow(row);
		}
		
	}

	@Override
	public void setCadastraProdutoListener(ActionListener al) {
		buttonAddCell.addActionListener(al);
		
	}
	
	@Override
	public void trocaFuncoes(ActionListener al) {
		buttonChange.addActionListener(al);		
	}

	@Override
	public String getButtonChangeText() {
		return buttonChange.getText();
	}
	
	@Override
	public void setButtonChangeText(String txt) {
		buttonChange.setText(txt);
	}
	
	@Override
	public int getIdProduto() {
		return Integer.parseInt(txtField1.getText());
	}

	@Override
	public String getNomeProduto() {
		return txtField2.getText();
	}

	@Override
	public double getValorProduto() {
		return Double.parseDouble(txtField3.getText());
	}




	

}
