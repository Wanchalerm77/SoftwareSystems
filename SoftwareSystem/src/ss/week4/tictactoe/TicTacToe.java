package ss.week4.tictactoe;

import ss.week5.ComputerPlayer;
import ss.week5.HumanPlayer;
import ss.week5.NaiveStrategy;
import ss.week5.SmartStrategy;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {

	public static void main(String[] args) {

		Player p1 = determinePlayer(args[0], Mark.XX);
		Player p2 = determinePlayer(args[1], Mark.OO);
		Game game = new Game(p1, p2);
		game.start();
	}

	public static Player determinePlayer(String arg, Mark mark) {
		String args = arg;
		if (args.equals("-N")) {
			return new ComputerPlayer(mark, new NaiveStrategy());
		} else if (args.equals("-S")) {
			return new ComputerPlayer(mark, new SmartStrategy());
		} else {
			return new HumanPlayer(arg, mark);
		}
	}
}