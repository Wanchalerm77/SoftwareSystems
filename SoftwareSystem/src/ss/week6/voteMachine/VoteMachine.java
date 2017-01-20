package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;

public class VoteMachine {

	public static VoteMachine voteMachine;
	public VoteList voteList;
	public PartyList partyList;
	public VoteView view;

	public static void main(String[] args) {
		VoteMachine.voteMachine = new VoteMachine();
		VoteMachine.voteMachine.start();
	}

	public void start() {
		voteList = new VoteList();
		partyList = new PartyList();
		view = new VoteTUIView(this);
		voteList.addObserver(view);
		partyList.addObserver(view);
		view.start();
	}

	public void addParty(String party) {
		partyList.addParty(party);
	}

	public void vote(String party) {
		voteList.addVote(party);
	}

	public List<String> getParties() {
		return partyList.getParties();
	}

	public Map<String, Integer> getVotes() {
		return voteList.getVotes();
	}

}