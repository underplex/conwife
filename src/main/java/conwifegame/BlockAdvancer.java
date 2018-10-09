package conwifegame;

/**
 * The BlockAdvancer implements the desired logic of the Conway Game of Life and variations by producing an initial state for the game and a method for advancing the state on each iteration.
 * <p>
 * Both the initial block and each block returned by advanceCellBlock are expected to have the same dimensions, possibly statuses for each Cell, and use the same logic for advancement.
 * @author Brandon Irvine, brandon@underplex.com
 *
 */
public interface BlockAdvancer {

	Block advanceCellBlock(Block current);
}
