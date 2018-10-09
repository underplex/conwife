package conwifegame;

/**
 * Represents an array of Cell instances in a Conway Game of Life or some variation on it.
 * @author Brandon Irvine, brandon@underplex.com
 *
 */
public class Block {

	private final Cell[][] cellArray;
	private final int width;
	private final int height;
	
	public Block(int width, int height, String[][] statuses){
		if (width < 3) throw new IllegalArgumentException("Width parameter is less than 3.");
		if (height < 3) throw new IllegalArgumentException("Height parameter is less than 3.");
		
		// throw errors for bad number of width, height
		// throw error for null BlockAdvancer
		this.width = width;
		this.height = height;
		cellArray = new Cell[width][height];
		for (int i = 0; i < width; i++){
			for (int j = 0; j < height; j++){
				if (statuses.length <= i ) throw new IllegalArgumentException("Cell at " + i + ", " + j + " is not defined.");
				if (statuses[i].length <= j) throw new IllegalArgumentException("Cell at " + i + ", " + j + " is not defined.");
				if (statuses[i][j] == null) throw new IllegalArgumentException("Cell at " + i + ", " + j + " is not defined.");
				cellArray[i][j] = new Cell(i, j, statuses[i][j]);
			}
		}	
	}

	public Cell getCell(int x, int y){
		if (x >= width || x < 0 ||
				y >= height || y < 0){
			return null;
		}
		return cellArray[x][y];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
