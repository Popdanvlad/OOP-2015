package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayersNameFrame implements ActionListener {

	private JFrame playerName;
	private int nbPlayers;
	private ArrayList<String> namePlayers;
	private JPanel namePanel;
	private JButton saveName;
	private JPanel saveNamePanel;
	private JTextField yourPlayer;

	public PlayersNameFrame(int nbPlayers) {
		playerName = new JFrame();
		playerName.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playerName.setSize(800, 500);
		playerName.setVisible(true);
		this.playerName.setLocationRelativeTo(null);
		this.playerName.setLayout(new GridLayout(2, 1));
		this.namePanel = new JPanel();
		this.saveNamePanel = new JPanel();
		this.namePlayers = new ArrayList<>();
		this.yourPlayer = new JTextField();
		this.nbPlayers = nbPlayers;
		this.saveName = new JButton("Save");
		setPlace();
		this.saveNamePanel.add(saveName);
		this.playerName.add(this.namePanel);
		this.playerName.add(this.saveNamePanel);
		addActionListeners();
	}

	private void setPlace() {
		this.namePanel.setLayout(new GridLayout(this.nbPlayers, 2));
		// /Yeah,I know this part of code is repeated but I wanted to outline
		// with which player the user of the game will play,
		// because initially it was also added in the for loop ,but I think in
		// this way is less confusing
		JLabel myname = new JLabel("Your name ");
		this.namePanel.add(myname);
		JTextField myNamePlayer = new JTextField("Your Name ");
		this.yourPlayer.add(myNamePlayer);
		this.namePanel.add(yourPlayer);
	}

	private void addActionListeners() {
		this.saveName.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.saveName) {
			this.namePlayers.add(this.yourPlayer.getText());
			for (int i = 1; i < this.nbPlayers; i++) {
			String name = "Player " + i;
			this.namePlayers.add(name);
		}
			this.namePlayers.add("Dealer");
			this.playerName.setVisible(false);

			new GameApplication(this.nbPlayers, this.namePlayers);
		}
	}

}
