package Cards;

public class Card {
    private String[] suits_list = { "SPADES", "HEARTS", "CLUBS", "DIAMONDS" };
    private String[] values_list = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
    private int suit;
    private int value;

    public Card(int number) {
        if (number >= 0 && number < 52) {
            value = number % 13;
            suit = number / 13;
        }
    }

    public String toString() {
        return values_list[value] + " of " + suits_list[suit];
    }

    public String getSuitStr() {
        return suits_list[suit];
    }

    public String getValueStr() {
        return values_list[value];
    }

    public int getSuitInt() {
        return suit;
    }

    public int getValueInt() {
        return value;
    }
}
