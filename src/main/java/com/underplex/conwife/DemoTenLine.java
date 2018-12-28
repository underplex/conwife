package com.underplex.conwife;

import java.util.HashMap;
import java.util.Map;

public class DemoTenLine {
	
	public static void main(String [] args){
		
		String fileName = "C:/Users/irvin/workspace/conwife/src/main/resources/TenLine.txt";
		Map<String, String> statusMap = new HashMap<>();
		int skipRows = 1;
		
		statusMap.put(".","dead");
		statusMap.put("*", "alive");
		FileLoader loader = new FileLoader(fileName, statusMap, skipRows);
		
		ConwifeGame game = new ConwifeGame(new ConwayTradBlockAdvancer(),
				loader.getWidth(), loader.getHeight(), loader.getArray());
		
		System.out.println("*** Initial Loaded State ***");
		game.printArray();
		System.out.println();
		
		int steps = 5;
		
		for (int step = 1; step <= steps; step++){
			System.out.println("*** Game at step " + step + " ***") ;
			game.printArray();
			game.advance();
			System.out.println();
		}
				
	}
	

}
