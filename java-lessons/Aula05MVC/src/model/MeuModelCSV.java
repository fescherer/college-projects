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

import entidade.Aluno;

public class MeuModelCSV implements Model {

	@Override
	public Collection<Aluno> loadAlunos() {
		Collection<Aluno> alunos = new ArrayList<>();
		
		InputStream is;
		InputStreamReader isr;
		BufferedReader br;
		
		try {
			is = new FileInputStream("files/alunos.csv");
			isr = new InputStreamReader(is, StandardCharsets.UTF_8);
			br = new BufferedReader(isr);
			
			String linha;
			while( (linha = br.readLine()) != null ) {
				String[] palavras = linha.split("\\,");
				String id = palavras[0];
				String nome = palavras[1];
				Aluno aluno = new Aluno(id, nome);
				alunos.add(aluno);
			}
			br.close();
			isr.close();
			is.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return alunos;
	}

	@Override
	public void saveAlunos(Collection<Aluno> alunos) {
		
		OutputStream os;
		OutputStreamWriter osw;
		PrintWriter pw;
		
		try {
			os = new FileOutputStream("files/alunos.csv");
			osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
			pw = new PrintWriter(osw, true);
			
			for(Aluno aluno: alunos) {
				pw.println(aluno.getId() + "," + aluno.getNome());
			}
			
			os.close();
			osw.close();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	

}

