package Cards;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner inputs = new Scanner(System.in);

        System.out.println("wanna play? (Press Y or N)");
        if (inputs.next().equalsIgnoreCase("Y")) {
            int wins_p1 = 0;
            int wins_p2 = 0;
            int games_played = 0;
            boolean play = true;

            Deck deck1 = new Deck();
            deck1.shuffle();

            Player p1 = new Player(2);
            Player p2 = new Player(2);

            while (deck1.length() > 0 && play) {
                games_played++;
                p1.addCard(deck1.dealCard(), deck1.dealCard());

                p2.addCard(deck1.dealCard(), deck1.dealCard());

                System.out.println("Player 1 cards: " + p1);
                System.out.println("Player 2 cards: " + p2);
                if (p1.compareTo(p2) == 1) {
                    wins_p1++;
                    System.out.println("You Won!");
                } else if (p1.compareTo(p2) == -1) {
                    wins_p2++;
                    System.out.println("You Lost!");
                } else {
                    System.out.println("It was a tie!");
                }

                p1.discard();
                p2.discard();

                System.out.println("Wanna play? (Press Y or N)");
                play = inputs.next().equalsIgnoreCase("Y");
            }
            System.out.println("Player 1 wins: " + wins_p1);
            System.out.println("Player 2 wins: " + wins_p2);
            System.out.println("Games played: " + games_played);
            System.out.println("Good Game!");
        }
        System.out.println("Next Time!");
        inputs.close();
    }
}