package main;

import java.text.DecimalFormat;

public class Nota {
	private double nota;
	
	DecimalFormat duasCasas = new DecimalFormat("#.00");
	
	//Default Constructor
	public Nota() {
		this.nota = 0;
	}
	
	//Constructor
	public Nota(double aNota) {
		//Aqui definimos que toda nota só pode ter duas casas decimais
		String notaFormatada = duasCasas.format(aNota);
		this.nota = Double.parseDouble(notaFormatada.replace(",", "."));
	}
	
	//Getter
	public double getNota() {
		return this.nota;
	}
	//To string
	public String toString() {
		return nota + "\n";
	}
}
