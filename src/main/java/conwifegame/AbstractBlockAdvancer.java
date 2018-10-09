package conwifegame;

public abstract class AbstractBlockAdvancer implements BlockAdvancer{

	public Block advanceCellBlock(Block current){
		String[][] tempArray = new String[current.getWidth()][current.getHeight()];
		for (int i = 0; i < current.getWidth(); i++){
			for (int j = 0; j < current.getHeight(); j++){
				tempArray[i][j] = updateCell(i, j, current);
			}
		}
		return new Block(current.getWidth(),current.getHeight(),tempArray);
	}
	
	public abstract String updateCell(int x, int y, Block current);
	
}
