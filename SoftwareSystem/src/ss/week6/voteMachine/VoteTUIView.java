package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.Set;

public class VoteTUIView implements VoteView, Observer {

	private VoteMachine controller;
	private static Scanner in = new Scanner(System.in);

	public VoteTUIView(VoteMachine controller) {
		this.controller = controller;
	}

	public void start() {
		boolean running = true;
		while (running) {
			System.out.println(" Enter your command \n Or type \"Help\" for more info");

			String line = in.nextLine();
			String[] words = line.split(" ");
			if (words.length == 3 && words[0].equals("ADD") && words[1].equals("PARTY")) {
				controller.addParty(words[2]);
			} else if (words.length == 1 && words[0].equals("PARTIES")) {
				showParties(controller.getParties());
			} else if (words.length == 1 && words[0].equals("EXIT")) {
				running = false;
			} else if (words.length == 2 && words[0].equals("VOTE")) {
				controller.vote(words[1]);
			} else if (words.length == 1 && words[0].equals("VOTES")) {
				showVotes(controller.getVotes());

			} else if (words[0].equals("Help")) {
				System.out.println(
						"Commands: \n To register a party: ADD PARTY + name \n To see a list of parties: PARTIES \n To vote for a party: VOTE + name \n To see the vote count: VOTES \n To exit the voting: EXIT");
				System.out.println("");
			} else {
				System.out.println("Unknown command");

			}
		}
	}

	public void showVotes(Map<String, Integer> votes) {
		System.out.println("Current votes:");
		Set<String> keyset = votes.keySet();
		for (String key : keyset) {
			System.out.println("Party: " + key + " has " + votes.get(key) + " votes");
		}
	}

	public void showParties(List<String> parties) {
		System.out.println("Current parties in the system:");
		for (String party : parties) {
			System.out.println(party);
		}
	}

	public void showError(String error) {
		System.out.println(error);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg.equals("vote")) {
			System.out.println("A vote has been casted!");
		} else if (arg.equals("party")) {
			System.out.println("A party has been added!");
		} else {
			System.out.println("Something weird happened...");
		}
	}
}