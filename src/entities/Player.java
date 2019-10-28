package entities;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;

import enums.PlayerRole;


public class Player {

	private static int idCounter = 0; 
	private int id;
	private String nickname;
	private PlayerRole role;
	private List<Card> cards = new ArrayList<Card>();

	public Player(String nickname, PlayerRole role) {
		this.setId(idCounter);
		this.nickname = nickname;
		this.role = role;
		this.cards = null;
		
		++Player.idCounter;
	}
	
	public Player(String nickname) {
		this(nickname, null);
	}
	
	public Player() {
		this(null, null);
	}

	public PlayerRole getRole() {
		return role;
	}

	public void setRole(PlayerRole role) {
		this.role = role;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Card> checkCardsOnHand(ArrayList<String> cardNames) { // TODO: cardNames should be sorted
		int i = 0, j = 0;
		List<Card> res = new ArrayList<Card>();
		
		while(i < cardNames.size() && j < this.cards.size()) {
			if (cardNames.get(i) == this.cards.get(j).getRank().getName()) { // TODO: adapt for a | A
				res.add(this.cards.get(j));
				++i; ++j;
			}
			else
				++j;
		}
		if (res.size() != cardNames.size())
			return null;
		return res;
	}
	
	public void removeCards(List<Card> handCards) {
		for(int i=0;i<handCards.size();i++)
			if(cards.contains(handCards.get(i)))
				cards.remove(handCards.get(i));
	}

	public void playCards(List<Card> cards) {
		// TODO Auto-generated method stub
		
	}

}
