package Cards;

public class Player {
    private Card[] hand;

    public Player(int card_count) {
        hand = new Card[card_count];
    }

    public void addCard(Card... input) {
        for (Card card : input) {
            for (int i = 0; i < hand.length; i++) {
                if (hand[i] == null) {
                    hand[i] = card;
                    break;
                }
            }
        }
    }

    public void discard() {
        for (int i = 0; i < hand.length; i++) {
            hand[i] = null;
        }
    }

    public Card maxCard() {
        Card tempCard = null;
        int highCardInt = 0;
        for (Card card : hand) {
            if (highCardInt < card.getValueInt()) {
                tempCard = card;
                highCardInt = card.getValueInt();
            }
        }
        return tempCard;
    }

    public boolean isPair() {
        return hand[0].getValueInt() == hand[1].getValueInt();
    }

    public boolean isFlush() {
        return hand[0].getSuitInt() == hand[1].getSuitInt();
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null)
                result += hand[i] + ", ";
        }
        return result.substring(0, result.length() - 2);
    }

    public int compareTo(Player opponent) {
        if ((opponent.isPair() && isPair())) {
            return (int) Math.signum(maxCard().getValueInt() - opponent.maxCard().getValueInt());
        } else if ((!opponent.isPair() && !isPair())) {
            if (!(opponent.isFlush() ^ isFlush())) {
                return (int) Math.signum(maxCard().getValueInt() - opponent.maxCard().getValueInt());
            } else if (opponent.isFlush()) {
                return -1;
            } else {
                return 1;
            }
        } else if (opponent.isPair()) {
            return -1;
        } else {
            return 1;
        }
    }
}
