package com.underplex.conwife;

/**
 * The BlockAdvancer implements the desired logic of the Conway Game of Life and variations by producing an initial state for the game and a method for advancing the state on each iteration.
 * <p>
 * Both the initial block and each block returned by advanceCellBlock are expected to have the same dimensions, possibly statuses for each Cell, and use the same logic for advancement.
 * @author Brandon Irvine, brandon@underplex.com
 *
 */
public interface BlockAdvancer {

	/**
	 * Implements the rules of this BlockAdvancer to create a block cells to succeed each Cell in the current block of Cells.
	 * @param current Block representing current state of the game
	 * @return Block that will be successor to the current Block
	 */
	Block advanceCellBlock(Block current);
	
	/**
	 * Prints to console a grid of Cell values, with abbreviations for the current status of each cell.
	 * <p>
	 * It is assumed the block parameter was implemented or governed by the rules of this BlockAdvancer.
	 * @param block Block to be printed
	 */
	void printBlock(Block block);
}
