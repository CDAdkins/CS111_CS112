/*
 * Chris Adkins, May 19, 2018
 * CS111, Les Russell
 * Final Project
 */

// Only difference between this and BlackJackHand is the ability to play the hand as a player.

public class PlayerHand extends BlackJackHand {

    public PlayerHand() {
        super();
    }

    public int playHand() {
        if (getHandValue() == MAX_SCORE) {
            return 0;
        } else if (getHandValue() > MAX_SCORE) {
            return 1;
        } else {
            return 2;
        }
    }
}
