package ex09;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Janela extends JFrame{
	private static final long serialVersionUID = 1L;
	
//	Fazer uma janela onde o usuário deve escolher um lanche, um ponto da carne, e ingredientes adicionais.
//
//    O lanche deve ser exatamente um entre “Basico”, “Cheese” e “Big”.
//    O ponto deve ser exatamente um entre “Mal Passado”, “No Ponto”, e “Bem Passado”.
//    O cliente pode escolher zero ou mais de um entre os ingredientes adicionais: “Queijo”, “Maionese”, “Carne”.
//
//A janela deve ter um botão que escreve na saída padrão o lanche escolhido e a janela é fechada. Ou se o usuário esqueceu de marcar algum item obrigatório.
//
//OBS: você pode usar o código abaixo para fazer a interface gráfica deste exercício. Mas ainda precisará programar o funcionamento dos botões.
	
	ArrayList<JRadioButton> arrayLanches;
	ArrayList<JRadioButton> arrayPonto;
	ArrayList<JCheckBox> arrayIngrediente;
	JLabel labelResultado;
	
	
	Janela(){
		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		JPanel panelEscolhas = new JPanel();
		add(panelEscolhas, BorderLayout.CENTER);
		
		//Adicionar botões de lanche
		JPanel panelLanches = new JPanel();
		panelLanches.setLayout(new FlowLayout());
		ButtonGroup bgLanches = new ButtonGroup();
		JLabel labelLanche = new JLabel("Tipo de lanche: ");
		panelLanches.add(labelLanche);
		arrayLanches = new ArrayList<>();
		arrayLanches.add(new JRadioButton("Básico"));
		arrayLanches.add(new JRadioButton("Cheese"));
		arrayLanches.add(new JRadioButton("Big"));
		for(JRadioButton i : arrayLanches) {
			panelLanches.add(i);
			bgLanches.add(i);
		}
		
		//Adicionar botões de ponto
		JPanel panelPonto = new JPanel();
		panelPonto.setLayout(new FlowLayout());
		ButtonGroup bgPonto = new ButtonGroup();
		JLabel labelPonto = new JLabel("Ponto da carne: ");
		panelPonto.add(labelPonto);
		arrayPonto = new ArrayList<>();
		arrayPonto.add(new JRadioButton("Mal Passada"));
		arrayPonto.add(new JRadioButton("Ao ponto"));
		arrayPonto.add(new JRadioButton("Bem passado"));
		for (JRadioButton i : arrayPonto) {
			bgPonto.add(i);
			panelPonto.add(i);
		}
		
		//Adicionar botões adicionais
		JPanel panelIngredientes = new JPanel();
		panelIngredientes.setLayout(new FlowLayout());
		JLabel labelIngredientes = new JLabel("Ingredientes: ");
		panelIngredientes.add(labelIngredientes);
		arrayIngrediente = new ArrayList<>();
		arrayIngrediente.add(new JCheckBox("Queijo"));
		arrayIngrediente.add(new JCheckBox("Salada"));
		arrayIngrediente.add(new JCheckBox("Maionese"));
		for(JCheckBox i : arrayIngrediente) {
			panelIngredientes.add(i);
		}
		
		
		
		panelEscolhas.setLayout(new GridLayout(3,1));
		panelEscolhas.add(panelLanches);
		panelEscolhas.add(panelPonto);
		panelEscolhas.add(panelIngredientes);
		
		JPanel panelResultado = new JPanel();
		panelResultado.setLayout(new GridLayout(2,1, 10, 10));
		JButton buttonVerifica = new JButton("Fazer Pedido");
		buttonVerifica.addActionListener(new ButtonBehavior());
		labelResultado = new JLabel("");
		panelResultado.add(buttonVerifica);
		panelResultado.add(labelResultado);
		add(panelResultado, BorderLayout.PAGE_END);
		
	}
	
	class ButtonBehavior implements ActionListener{
		String tipoLanche, tipoPonto;
		String tipoAdicionais = "";
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			labelResultado.setText("");
			tipoAdicionais = "";
			
			if(arrayLanches.get(0).isSelected()) {tipoLanche = "básico";};
			if(arrayLanches.get(1).isSelected()) {tipoLanche = "cheese";};
			if(arrayLanches.get(2).isSelected()) {tipoLanche = "big";};
			
			if(arrayPonto.get(0).isSelected()) {tipoPonto = "mal passado";};
			if(arrayPonto.get(1).isSelected()) {tipoPonto = "ao ponto";};
			if(arrayPonto.get(2).isSelected()) {tipoPonto = "bem passado";};
			
			if(arrayIngrediente.get(0).isSelected()) {tipoAdicionais += "queijo, ";};
			if(arrayIngrediente.get(1).isSelected()) {tipoAdicionais += "salada, ";};
			if(arrayIngrediente.get(2).isSelected()) {tipoAdicionais += "maionese, ";};
			
			if(tipoLanche != null && tipoPonto != null) {
				if(tipoAdicionais.equals("")) {
					labelResultado.setText("Seu pedido é um lanche " + tipoLanche + " " + tipoPonto);
				} else {
					labelResultado.setText("Seu pedido é um lanche " + tipoLanche + " " + tipoPonto + " com " + tipoAdicionais);
				}
				
			}
			
			
			
		}
		
	}
	
}
