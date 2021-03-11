package Cards;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck() {
        for (int i = 0; i < 52; i++) {
            deck.add(new Card(i));
        }
    }

    public int length() {
        return deck.size();
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < deck.size(); i++) {
            result += deck.get(i) + ", ";
        }
        return result.substring(0, result.length() - 2);
    }

    public void shuffle() {
        int curr = deck.size() - 1;
        int rand = (int) (Math.random() * (curr + 1));
        Card temp;
        while (curr > 0) {
            temp = deck.get(curr);
            deck.set(curr, deck.get(rand));
            deck.set(rand, temp);
            curr--;
            rand = (int) (Math.random() * (curr + 1));
        }
    }

    public Card dealCard() {
        return deck.remove(deck.size() - 1);
    }
}
