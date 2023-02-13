package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

import entidade.Produto;

public class ModelCSV implements Model {
	
	private String path = "files/produtos.csv";
	
	@Override
	public Collection<Produto> loadProdutos(boolean isPerishable) {
		
		if(isPerishable) {
			path = "files/produtospereciveis.csv";
		} else {
			path = "files/produtos.csv";
		}
		
		Collection<Produto> produtos = new ArrayList<>();
		
		InputStream is;
		InputStreamReader isr;
		BufferedReader br;
		
		try {
			is = new FileInputStream(path);
			isr = new InputStreamReader(is, StandardCharsets.UTF_8);
			br = new BufferedReader(isr);
			
			String linha;
			while( (linha = br.readLine()) != null ) {
				String[] palavras = linha.split("\\,");
				int id = Integer.parseInt(palavras[0]);
				String nome = palavras[1];
				double valor = Double.parseDouble(palavras[2]);
				Produto produto = new Produto(id, nome, valor);
				produtos.add(produto);
			}
			br.close();
			isr.close();
			is.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return produtos;
	}

	@Override
	public void saveProdutos(Collection<Produto> produtos, boolean isPerishable) {
		
		if(isPerishable) {
			path = "files/produtospereciveis.csv";
		} else {
			path = "files/produtos.csv";
		}
		
		OutputStream os;
		OutputStreamWriter osw;
		PrintWriter pw;
		
		try {
			os = new FileOutputStream(path);
			osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
			pw = new PrintWriter(osw, true);
			
			for(Produto produto: produtos) {
				pw.println(produto.getId() + "," + produto.getNome() + "," + produto.getValor());
			}
			
			os.close();
			osw.close();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}
