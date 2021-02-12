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
            }
        }
        return tempCard;
    }

    public boolean isPair() {
        return hand[0].getValueInt() == hand[1].getValueInt();
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
        if (opponent.isPair() && isPair()) {
            if (opponent.maxCard().getValueInt() > maxCard().getValueInt()) {
                return -1;
            } else if (opponent.maxCard().getValueInt() == maxCard().getValueInt()) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (opponent.isPair()) {
                return -1;
            } else if (isPair()) {
                return 1;
            } else {
                if (opponent.maxCard().getValueInt() > maxCard().getValueInt()) {
                    return -1;
                } else if (opponent.maxCard().getValueInt() == maxCard().getValueInt()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
    }
}
