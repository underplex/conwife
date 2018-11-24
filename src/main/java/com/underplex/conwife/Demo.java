package com.underplex.conwife;

import java.util.HashMap;
import java.util.Map;

public class Demo {
	
	public static void main(String [] args){
		
		String fileName = "C:/Users/irvin/workspace/conwife/src/main/resources/Blinker.txt";
		Map<String, String> statusMap = new HashMap<>();
		int skipRows = 1;
		
		statusMap.put(".","dead");
		statusMap.put("*", "alive");
		FileLoader loader = new FileLoader(fileName, statusMap, skipRows);
		
//		int w = 5;
//		int h = 5;
//		String[][] array = new String[w][h];
//		for (int i = 0; i < w; i++){
//			for (int j = 0; j < h; j++){
//				if (j == 2 && i != 0 && i != 4){
//					array[i][j] = "alive";
//				} else {
//					array[i][j] = "dead";
//				}
//			}
//		}
		
		ConwifeGame game = new ConwifeGame(new ConwayTradBlockAdvancer(),
				loader.getWidth(), loader.getHeight(), loader.getArray());
		
		game.printArray();
		
		int steps = 5;
		
		for (int step = 1; step <= steps; step++){
			System.out.println("Game at step " + step);
			game.printArray();
			game.advance();
		}
				
	}
	

}
