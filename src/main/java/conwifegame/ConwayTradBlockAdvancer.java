package conwifegame;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ConwayTradBlockAdvancer extends AbstractBlockAdvancer {
	
	public String updateCell(int x, int y, Block current){
		
//		Any live cell with fewer than two live neighbors dies, as if by underpopulation.
//		Any live cell with two or three live neighbors lives on to the next generation.
//		Any live cell with more than three live neighbors dies, as if by overpopulation.
//		Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

		Map<Direction, String> n = this.neighbors(x, y, current);
		
		int live = Collections.frequency(n.values(), "alive");
		String currentStatus = current.getCell(x, y).getStatus();
		// currentStatus != null by definition, maybe throw error
		if (currentStatus == null) throw new IllegalStateException("Status of cell " + x + ", " + y + " is unexpectedly null.");
		if (!currentStatus.equals("alive") && !currentStatus.equals("dead")) throw new IllegalStateException("Status of cell " + x + ", " + y + " is unexpectedly " + currentStatus);

		String successor = "dead";

		if (currentStatus.equals("alive")){
			if (live == 2 || live == 3){
				successor = "alive";
			}
		} else {
			if (live == 3){
				successor = "alive";
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

}
