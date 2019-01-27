/*
 * Chris Adkins, May 19, 2018
 * CS111, Les Russell
 * Final Project
 */

// Fairly similar to the BlackJackHand class, but for cards. Holds the deck and contains useful methods like shuffle()

import java.util.Random;

public class CardDeck {

    private Card[] deck;
    private int numLeft = 52;
    private int shuffleAt;
    private int cardNum = 0;
    private Card nextCard;

    private Random random;

    public void shuffle() {

        this.deck = new CardDeck().deck;
        numLeft = 52;
        cardNum = 0;
        
        int ndxSwap;
        Card tmpCardVal;
        int numShuffles = 20;

        for (int counter = 0; counter < numShuffles; counter++) {
            for (int ndx = 0; ndx < deck.length; ndx++) {
                ndxSwap = random.nextInt(deck.length);
                if (ndxSwap != ndx) {
                    tmpCardVal = deck[ndx];
                    deck[ndx] = deck[ndxSwap];
                    deck[ndxSwap] = tmpCardVal;
                }
            }
        }

    }

    public Card dealCard() {
        // RETURN NEXT CARD

        nextCard = deck[cardNum];
        cardNum++;
        numLeft--;
        return nextCard;
    }

    public Card getNextCard() {
        return nextCard;
    }

    public void deleteCard() {
        deck[cardNum - 1] = null;
    }

    public void shuffleAuto() {
        if (numLeft < 20) {
            shuffle();
        }
    }

    public CardDeck() {
        random = new Random();
        random.setSeed(System.currentTimeMillis());

        this.deck = new Card[52];
        int counter = 0;
        for (int ndx = 0; ndx < 13; ndx++) {
            CardRank rank = CardRank.values()[ndx];
            for (int index = 0; index < 4; index++) {
                Card card = new Card(rank, CardSuit.values()[index]);
                this.deck[counter] = card;
                counter++;
            }
        }
        //shuffle();
    }

    public void printDeck() {
        for (int ndx = 0; ndx < deck.length; ndx++) {
            if (deck[ndx] != null) {
                System.out.print(deck[ndx].getRank());
                System.out.print(" of ");
                System.out.println(deck[ndx].getSuit());
            } else {
                System.out.println("NO CARD");
            }
        }
    }
    
    public int getNumLeft() {
            return numLeft;
    }
}
