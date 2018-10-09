package conwifegame;

public class Cell {

	private final int x;
	private final int y;
	private final String status;
	
	public Cell(int x, int y, String status){
		this.x = x;
		this.y = y;
		this.status = status;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getStatus() {
		return status;
	}

}
