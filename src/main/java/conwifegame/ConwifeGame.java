package conwifegame;

import java.util.HashMap;
import java.util.Map;

public class ConwifeGame {

	private final BlockAdvancer blockManager;
	private int turn;
	private Block current;
	private final Map<Integer,Block> history;
	
	public ConwifeGame(BlockAdvancer blockManager, int width, int height, String[][] initialStatuses){
		this.blockManager = blockManager;
		this.turn = 1;
		this.current = new Block(width, height, initialStatuses);
		this.history = new HashMap<Integer,Block>();
	}
	
	public void advance(){
		
		history.put(turn,current);
		current = blockManager.advanceCellBlock(current);
		turn++;
	}
	
	public void printArray(){

		for (int j = current.getHeight() - 1; j >= 0; j--){
			for (int i = 0; i < current.getWidth(); i++){
				String s = current.getCell(i, j).getStatus().equals("alive") ? "o" : ".";
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
	
}
