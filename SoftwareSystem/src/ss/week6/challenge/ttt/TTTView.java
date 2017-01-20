package ss.week6.challenge.ttt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TTTView implements Observer {

	JFrame frame;
	JPanel panel;
	JButton button;
	JLabel label;
	JButton[][] buttons = new JButton[3][3];

	public TTTView() {
		// TODO Auto-generated constructor stub
		gui();
		TTTController controller = new TTTController();
	}

	public void gui() {
		frame = new JFrame("TicTacToe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(350, 450);
		frame.setLocationRelativeTo(null);

		panel = new JPanel(new GridLayout(3, 3)); // game
		JPanel menu = new JPanel(new BorderLayout());
		JPanel mainPanel = new JPanel(new BorderLayout());

		JButton start = new JButton("Start");
		JButton reset = new JButton("Reset");

		label = new JLabel();

		panel.add(label);

		frame.add(mainPanel);
		mainPanel.add(menu, BorderLayout.NORTH);
		mainPanel.add(panel, BorderLayout.SOUTH);
		menu.add(reset, BorderLayout.EAST);
		menu.add(start, BorderLayout.WEST);

		mainPanel.setPreferredSize(new Dimension(325, 425));
		menu.setPreferredSize(new Dimension(300, 50));
		panel.setPreferredSize(new Dimension(300, 300));

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setVisible(true);
				buttons[i][j].setText("LOL");

				panel.add(buttons[i][j]);

			}
		}

	}

	public static void main(String[] args) {

		TTTView view = new TTTView();

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	public class TTTController implements ActionListener {

		public TTTController() {
			// TODO Auto-generated constructor stub
			Game game = new Game();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
