package conwifegame;

import java.io.IOException;
import java.util.Random;

public class DemoTenSquare {
	
	public static void main(String [] args){
		int w = 5;
		int h = 5;
		String[][] array = new String[w][h];
		for (int i = 0; i < w; i++){
			for (int j = 0; j < h; j++){
				if (j == 2 && i != 0 && i != 4){
					array[i][j] = "alive";
				} else {
					array[i][j] = "dead";
				}
			}
		}
		
		ConwifeGame game = new ConwifeGame(new ConwayTradBlockAdvancer(),
				w, h, array);
		
		int steps = 5;
		
		for (int step = 1; step <= steps; step++){
			System.out.println("Game at step " + step);
			game.printArray();
			game.advance();
		}
				
	}
	

}
