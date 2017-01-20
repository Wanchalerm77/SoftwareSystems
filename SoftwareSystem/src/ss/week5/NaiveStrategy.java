package ss.week5;

import java.util.Random;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class NaiveStrategy implements Strategy {

	Board board;
	public Random random = new Random();

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "helaas pindakaas";
	}

	@Override
	public int determineMove(Board b, Mark m) {
		int freeSpot;

		while (!b.isEmptyField(freeSpot = random.nextInt(Board.DIM * Board.DIM)))
			;
		return freeSpot;

	}
}
