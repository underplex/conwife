package com.underplex.conwife;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Uses rules that classify cells not based on just their current state but rather the transition they are currently undergoing.
 * <p>
 * So all cells are one of the following statuses: "alive-alive","alive-dead","dead-dead","dead-alive" to indicate what transition they are going through.
 * <p>
 * The second item (after the hyphen) is thought of as the successor state.
 * <p>
 * Otherwise, this implements the regular rules of Conway's Game of Life.
 * @author Brandon Irvine, brandon@underplex.com
 *
 */
public class ConwayTransitionBlockAdvancer extends AbstractBlockAdvancer {
	
	public String updateCell(int x, int y, Block current){
		
//		Any live cell with fewer than two live neighbors dies, as if by underpopulation.
//		Any live cell with two or three live neighbors lives on to the next generation.
//		Any live cell with more than three live neighbors dies, as if by overpopulation.
//		Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

		Map<Direction, String> n = this.neighbors(x, y, current);
		
		int live = Collections.frequency(n.values(), "alive-alive") + Collections.frequency(n.values(), "dead-alive");
		String currentStatus = current.getCell(x, y).getStatus();
		// currentStatus != null by definition, maybe throw error
		if (currentStatus == null) throw new IllegalStateException("Status of cell " + x + ", " + y + " is unexpectedly null.");
		if (!currentStatus.equals("alive-alive") && 
				!currentStatus.equals("alive-dead") &&
				!currentStatus.equals("dead-alive") &&
				!currentStatus.equals("dead-dead")) 
			throw new IllegalStateException("Status of cell " + x + ", " + y + " is unexpectedly " + currentStatus);

		String successor = "";
		if (currentStatus.contains("-alive")){
			successor = "alive";
		} else {
			successor = "dead";
		}
		
		if (successor.equals("alive")){
			if (live == 2 || live == 3){
				successor = successor + "-alive";
			} else {
				successor = successor + "-dead";
			}
		} else {
			if (live == 3){
				successor = successor + "-alive";
			} else {
				successor = successor + "-dead";
			}
		}
		return successor;
	}
	
	/**
	 * Returns Map with keys of every direction that can be legally reached from the Cell defined by x, y and values of their status.
	 * <p>
	 * All neighbors listed here are assumed to actually exist in the simulation (rather than be "off the board"). If they aren't, they don't exist.
	 * <p>
	 * If there are no neighbors, an empty map is returned.
	 * @return 
	 */
	public Map<Direction,String> neighbors(int x, int y, Block current){
		Map<Direction, String> rMap = new HashMap<Direction, String>();
		for (Direction d : Direction.values()){
			Cell currentCell = current.getCell(x + d.getOffsetX(), y + d.getOffsetY());
			if (currentCell != null){
				rMap.put(d, currentCell.getStatus());
			}
		}
		return rMap;
	}
	
	public void printBlock(Block block){

		for (int j = block.getHeight() - 1; j >= 0; j--){
			for (int i = 0; i < block.getWidth(); i++){
				String s = block.getCell(i, j).getStatus().contains("-alive") ? "o" : ".";
				System.out.print(s + " ");
			}
			System.out.println();
		}
		
	}

}
