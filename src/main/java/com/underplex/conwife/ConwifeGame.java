package com.underplex.conwife;

import java.util.HashMap;
import java.util.Map;

public class ConwifeGame {

	private final BlockAdvancer blockAdvancer;
	private int turn;
	private Block current;
	private final Map<Integer,Block> history;
	
	public ConwifeGame(BlockAdvancer blockAdvancer, int width, int height, String[][] initialStatuses){
		this.blockAdvancer = blockAdvancer;
		this.turn = 1;
		this.current = new Block(width, height, initialStatuses);
		this.history = new HashMap<Integer,Block>();
	}
	
	public void advance(){		
		history.put(turn,current);
		current = blockAdvancer.advanceCellBlock(current);
		turn++;
	}
	
	public void printArray(){

		blockAdvancer.printBlock(current);
	}

	public int getTurn(){
		return turn;
	}
	
	public Block getCurrentBlock(){
		return current;
	}
	
	public Map<Integer,Block> getHistory(){
		return history;
	}
}
