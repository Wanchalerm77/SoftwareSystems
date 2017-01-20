package ss.week5;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;
import ss.week4.tictactoe.Player;

public class ComputerPlayer extends Player {

	protected Strategy strat;
	protected Mark mark;

	public ComputerPlayer(Mark mark, Strategy strategy) {
		super(strategy.getName() + "-" + mark.toString(), mark);
		this.strat = strategy;

		// TODO Auto-generated constructor stub
	}

	public ComputerPlayer(Mark mark) {
		this(mark, new NaiveStrategy());

	}

	@Override
	public int determineMove(Board board) {
		// TODO Auto-generated method stub
		return strat.determineMove(board, getMark());
	}

}
