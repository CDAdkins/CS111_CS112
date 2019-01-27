/*
 * Chris Adkins, May 19, 2018
 * CS111, Les Russell
 * Final Project
 */

// Any code in this class is specific to the dealer's hand as it extends the BlackJackHand class. Things like the hole card and how the dealer plays a hand.

public class DealerHand extends BlackJackHand {

    private boolean holeCardHidden = true;

    public DealerHand() {
        super();
    }

    public int playHand() {
        // 0 = Stand
        // 1 = Bust
        // 2 = Hit

        if (getHandValue() == MAX_SCORE || getHandValue() >= 17 && getHandValue() < MAX_SCORE) {
            holeCardHidden = false;
            return 0;
        } else if (getHandValue() > MAX_SCORE) {
            return 1;
        } else {
            return 2;
        }
    }

    public int addCard(Card card) {

        for (int ndx = 0; ndx < getHand().length; ndx ++) {
            if (getHand()[ndx] != null) {
            } else {
                getHand()[ndx] = card;
                break;
            }
            if (getHand()[1] != null) {
                holeCardHidden = false;
            }
        }
        return 0;
    }

    public boolean isHoleCardHidden() {
        return holeCardHidden;
    }

    public void setIsHoleCardHidden(Boolean bool) {
        holeCardHidden = bool;
    }

    public void resetHand() {
        for (int ndx = 0; ndx < getHand().length; ndx ++) {
            getHand()[ndx] = null;
        }
        setIsHoleCardHidden(true);
    }
}