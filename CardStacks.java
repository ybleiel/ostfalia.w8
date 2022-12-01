package s0start;

public class CardStacks {
public static void main(String[] args) {
	CardDeck c = new CardDeck(101);
	CardDeck d = new CardDeck(101);
	System.out.println(c.getTop());
	c.moveAll(d);
	System.out.println(d.getTop());
}
}

class Card {
	int wert;
	
	public Card(int wert) {
		this.wert = wert;
	}
	
	public Card() {
		int i = (int) (Math.random() * 9) + 2;
		this.wert = i; 
	}
	
	public int getNum() {
		return wert;
	}
}

class CardDeck {
	int anzahl;
	Card[] deck = new Card[100];
	
	public CardDeck(int anzahl) {
		this.anzahl = anzahl;
		int i = 0;
		while(i < anzahl) {
			deck[i] = new Card();
			i++;
		}
	}
	
	public Card getTop() {
		if (this.isEmpty() == true)
			return null;
		return deck[anzahl - 1];
	}
	
	public void moveTop(CardDeck cd) {
		if (this.isEmpty() == true)
			return ;
		else {
		cd.deck[cd.anzahl] = this.getTop();
		cd.anzahl++;
		this.deck[anzahl - 1] = null;
		this.anzahl--;
		}
	}
	
	public void moveAll(CardDeck cd) {
		int i = 0;
		while (i < this.anzahl) {
			cd.deck[cd.anzahl] = this.deck[i];
			cd.anzahl++;
			i++;
		}
		this.anzahl = 0;
	}
	
	public boolean isEmpty() {
		if (this.anzahl == 0)
			return true;
		else
			return false;
	}

	public boolean isSingle() {
		if (this.anzahl == 1)
			return true;
		else
			return false;
	}
}