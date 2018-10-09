package conwifegame;

public enum Direction {

	NORTHEAST(1, 1),
	NORTHWEST(-1, 1),
	NORTH(0, 1),
	SOUTH(0, -1),
	WEST(-1, 0),
	EAST(1, 0),
	SOUTHWEST(-1, -1),
	SOUTHEAST(1, -1)
    ;
	
	private final int offsetX;
	private final int offsetY;
	
	private Direction(int offsetX, int offsetY){
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		
	}

	public int getOffsetX() {
		return offsetX;
	}

	public int getOffsetY() {
		return offsetY;
	}
}
