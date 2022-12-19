# blackjack
Allows the user to play Blackjack against the computer.
## Game Logic
- Computer (dealer) takes cards until its hand value is 17+ (so dealer must stand on soft 17)
- User can make a 2:1 side bet as insurance when the dealer gets an Ace
- Blackjack pays 3:2 (only naturals)
- Aces are worth either 1 or 11, whatever is most advantageous to the holder
- Betting is only constrained by the user's balance (no arbitrary restrictions, whole numbers only)
- Cards are completely random (counting cards is futile, each card type has a 1 in 52 chance of being generated without regard to the cards that have been generated)
- No surrender option
- DAS (Doubling After Split) is allowed
- No resplitting allowed (Max number of hands is 2)
