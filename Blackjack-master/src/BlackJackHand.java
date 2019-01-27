/*
 * Chris Adkins, May 19, 2018
 * CS111, Les Russell
 * Final Project
 */

// Abstract class, parent of DealerHand and PlayerHand. It houses the methods relevent to a hand.

public abstract class BlackJackHand {
    public final int MAX_CARDS = 12;
    public final int MAX_SCORE = 21;
    private int handValue = 0;
    private Card[] hand = new Card[MAX_CARDS];
    private boolean hasAce = false;


    public int addCard(Card card) {

        for (int ndx = 0; ndx < hand.length; ndx ++) {
            if (hand[ndx] != null) {
            } else {
                hand[ndx] = card;
                break;
            }
        }
        return 0;
    }

    public Card[] getHand() {
        return this.hand;
    }

    public int getHandValue() {
        handValue = scoreHand();
        return this.handValue;
    }

    public abstract int playHand();

    private int scoreHand() {
        handValue = 0;
        for (int ndx = 0; ndx < hand.length; ndx++) {
            if (hand[ndx] != null && hand[ndx].getSecondaryValue() == 0) {
                handValue += hand[ndx].getPrimaryValue();
            } else if (hand[ndx] != null && hand[ndx].getSecondaryValue() == 1) {
                if (handValue + hand[ndx].getPrimaryValue() > MAX_SCORE) {
                    handValue += hand[ndx].getSecondaryValue();
                    hasAce = true;
                } else {
                    handValue += hand[ndx].getPrimaryValue();
                    hasAce = true;
                }
            }
        }
        return handValue;
    }

    public void resetHand() {
        for (int ndx = 0; ndx < hand.length; ndx ++) {
            hand[ndx] = null;
        }
    }

    public boolean isHasAce() {
        return hasAce;
    }
}
