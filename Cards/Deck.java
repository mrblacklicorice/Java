public class Deck {
    private Card[] deck = new Card[52];

    public Deck() {
        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card(i);
        }
    }

    public String toString() {
        if (length() == 0)
            return "";
        String result = "";
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] != null)
                result += deck[i] + ", ";
        }
        return result.substring(0, result.length() - 2);
    }

    public int length() {
        int count = 0;
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] != null)
                count++;
        }
        return count;
    }

    public void shuffle() {
        int curr = length() - 1;
        int rand = (int) (Math.random() * (curr + 1));
        Card temp;
        while (curr > 0) {
            temp = deck[curr];
            deck[curr] = deck[rand];
            deck[rand] = temp;
            curr--;
            rand = (int) (Math.random() * (curr + 1));
        }
    }

    public Card dealCard() {
        if (length() == 0)
            return null;
        Card temp = deck[length() - 1];
        deck[length() - 1] = null;
        return temp;
    }
}
