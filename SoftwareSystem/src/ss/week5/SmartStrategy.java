package ss.week5;

import java.util.Random;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class SmartStrategy implements Strategy {

	private final static String NAME = "Smart";

	@Override
	public String getName() {
		return SmartStrategy.NAME;
	}

	@Override
	public int determineMove(Board b, Mark m) {
		// Take the middle field if possible

		if (b.isEmptyField(1, 1)) {
			return b.index(1, 1);

		}
		// Check for guaranteed win
		for (int i = 0; i < (Board.DIM * Board.DIM); i++) {
			Board newboard = b.deepCopy();
			newboard.setField(i, m);
			if (newboard.isWinner(m))
				return i;
		}
		// Check if opponent could win on a field
		for (int i = 0; i < (Board.DIM * Board.DIM); i++) {
			Board newboard = b.deepCopy();
			newboard.setField(i, m.other());
			if (newboard.isWinner(m.other()))
				return i;
		}
		// In every other case, do a random move
		return doRandomMove(b);
	}

	/*
	 * doRandomMove iterates through every field of the board and checks if
	 * they´re empty If not we return the specific index of that field ( 0-8)
	 */

	public int doRandomMove(Board b) {
		int ret;

		while (!b.isEmptyField(ret = new Random().nextInt(Board.DIM * Board.DIM)))
			;
		return ret;
	}
}
