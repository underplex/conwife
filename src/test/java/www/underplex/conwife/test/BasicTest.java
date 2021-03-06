package www.underplex.conwife.test;
/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.underplex.conwife.Block;
import com.underplex.conwife.ConwayTradBlockAdvancer;
import com.underplex.conwife.ConwifeGame;
import com.underplex.conwife.Direction;

public class BasicTest {

    @Test
    public void testNeighbors() {
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
		
		ConwayTradBlockAdvancer advancer = new ConwayTradBlockAdvancer();
		
		Block block = new Block(w, h, array);
		
		Map<Direction, String> neighbors = advancer.neighbors(2, 2, block);
		assertEquals(8, neighbors.values().size());

    }
}
