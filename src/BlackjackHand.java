public class BlackjackHand extends Hand {

    int handValue;
    boolean soft;

    // builds a BlackjackHand object
    public BlackjackHand() {
        super();
        handValue = 0;
        soft = false;
    }

    // adds a card to the hand and recalculates the hand value
    public void addCard(PlayingCard c)
    {
        super.addCard(c);
        computeValue();
    }

    // adds an array of cards to the hand
    public void addCards(PlayingCard[] cards)
    {
        for(PlayingCard c : cards)
            addCard(c);
    }

    // updates the value of the hand and whether it is soft
    private void computeValue()
    {
        int val = 0;
        boolean aces = false;
        boolean sft = false;
        for(int i = 0; i < numberOfCards(); i++)
        {
            if(nthCard(i).getValue() >= 10)
                val += 10;
            else
                val += nthCard(i).getValue();
            if(nthCard(i).toString().contains("Ace"))
                aces = true;
        }

        if(aces && val < 12)
        {
            val += 10;
            sft = true;
        }
        handValue = val;
        soft = sft;
    }

    // returns the value of the hand
    public int handValue()
    {
        return handValue;
    }

    // returns a boolean representing whether the hand is soft
    public boolean soft()
    {
        return soft;
    }



}



