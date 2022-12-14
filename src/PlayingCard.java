public class PlayingCard {

    private int suit;
    private int value;

    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;

    public static final int HEARTS = 1;
    public static final int SPADES = 2;
    public static final int CLUBS = 3;
    public static final int DIAMONDS = 4;

    // creates a PlayingCard with set value and suit
    public PlayingCard(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    // creates a PlayingCard with random value and suit
    public PlayingCard() {
        int[] suits = {HEARTS, SPADES, CLUBS, DIAMONDS};
        int randVal = (int)(13 * Math.random() + 1);
        int randSuit = (int)(4 * Math.random() + 1);
        this.suit = randSuit;
        this.value = randVal;
    }

    // creates a PlayingCard with a set value and a random suit
    public PlayingCard(int value)
    {
        this.value = value;
        this.suit = (int)(4 * Math.random() + 1);
    }

    // returns a string representation of the card
    public String toString() {
        String val;
        String suitStr = "";
        if(value == 1)
            val = "Ace";
        else if(value == 11)
            val = "Jack";
        else if(value == 12)
            val = "Queen";
        else if(value == 13)
            val = "King";
        else
            val = Integer.toString(value);

        if(suit == 1)
            suitStr = "Hearts";
        else if(suit == 2)
            suitStr = "Spades";
        else if(suit == 3)
            suitStr = "Clubs";
        else if(suit == 4)
            suitStr = "Diamonds";

        return val + " of " + suitStr;
    }

    // returns the suit of the PlayingCard
    public int getSuit()
    {
        return suit;
    }

    // returns the value of the PlayingCard
    public int getValue()
    {
        return value;
    }
}


