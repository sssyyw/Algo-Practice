package chapter7;

public class Card {
	public enum Suit{
		ClUBS(1), SPADES(2), HEARTS(3), DIAMONS(4);
		int value;
		private Suit(int v) {value = v;}
	}
	
	private int card;
	private Suit suit;
	
	public Card(int r, Suit s){
		card = r;
		suit = s;
	}
	
	public int value() {return card;}
	public Suit suit() {return suit;}
}
