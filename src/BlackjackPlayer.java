public abstract class BlackjackPlayer {

    public abstract boolean hit(BlackjackHand dealerHand, BlackjackHand playerHand);

    public abstract void dealerHit(BlackjackHand dealerHand);

    public abstract void playerBusts(BlackjackHand playerHand);

    public abstract void playerTies(BlackjackHand playerHand, BlackjackHand dealerHand);

    public abstract void playerWins(BlackjackHand playerHand, BlackjackHand dealerHand);

    public abstract void dealerBusts(BlackjackHand playerHand, BlackjackHand dealerHand);

    public abstract void dealerWins(BlackjackHand playerHand, BlackjackHand dealerHand);

}


