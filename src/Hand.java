public class Hand {
    private PlayingCard[] cards;
    private int cardNum;

    // creates a Hand object with 5 PlayingCard slots
    public Hand()
    {
        cardNum = 0;
        cards = new PlayingCard[5];
    }

    // returns the number of occupied card slots
    public int numberOfCards()
    {
        int num = 0;
        for (PlayingCard card : cards) {
            if (card != null) {
                num++;
            }
        }
        return num;
    }

    // returns the nth card in the hand
    public PlayingCard nthCard(int n)
    {
        return cards[n];
    }

    // returns a string representation of the hand
    public String toString()
    {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < cardNum; i++)
        {
            output.append(cards[i].toString());
            if(i != cardNum - 1)
                output.append("<br>");
        }
        return output.toString();
    }

    // adds a new card to the hand and adds 5 slots if it is full
    public void addCard(PlayingCard c)
    {
        cardNum++;
        if(cardNum > cards.length)
        {
            PlayingCard[] newCards = new PlayingCard[cards.length * 2];
            System.arraycopy(cards, 0, newCards, 0, cards.length);
            newCards[cardNum - 1] = c;
            cards = newCards;
        }
        else
            cards[cardNum - 1] = c;
    }

}





