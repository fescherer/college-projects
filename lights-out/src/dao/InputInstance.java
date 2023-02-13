package dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import entities.Board;


public class InputInstance {
	
	public static int initialBoardType;
	
	public static Board getInstance(String file) {
		
		Board board = null;
		
		InputStream is;
		InputStreamReader isr;
		BufferedReader br;
		
		try {
			is = new FileInputStream(file);
			isr = new InputStreamReader(is, StandardCharsets.UTF_8);
			br = new BufferedReader(isr);

			
			String line;
			
			line = br.readLine();
			int boardType = Integer.parseInt(line);
			
			initialBoardType = boardType;
			
			int[][] tiles = new int[boardType][boardType];
			for(int i=0; i< boardType; i++) {
				
				line = br.readLine();
				
				String[] values = line.split(" ");
				
				for(int j=0; j < boardType; j++) {
					tiles[i][j] = Integer.parseInt(values[j]);
				}
			}
			board = new Board(tiles, boardType);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return board;
	}
	
}