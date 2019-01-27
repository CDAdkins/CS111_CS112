/*
 * Chris Adkins, May 19, 2018
 * CS111, Les Russell
 * Final Project
 */

// The class for a single Card, rank, suit, primary values, and secondary values live here.

public class Card {

    private CardRank rank = null;
    private CardSuit suit = null;

    private int primaryValue = 0;
    private int secondaryValue = 0;

    public Card (CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;

        switch (rank) {
            case Two:   this.primaryValue = 2;
                        break;
            case Three: this.primaryValue = 3;
                        break;
            case Four:  this.primaryValue = 4;
                        break;
            case Five:  this.primaryValue = 5;
                        break;
            case Six:   this.primaryValue = 6;
                        break;
            case Seven: this.primaryValue = 7;
                        break;
            case Eight: this.primaryValue = 8;
                        break;
            case Nine:  this.primaryValue = 9;
                        this.secondaryValue = 0;
                        break;
            case Ten:
            case Jack:
            case Queen:
            case King:  this.primaryValue = 10;
                        this.secondaryValue = 0;
                        break;
            case Ace:   this.primaryValue = 11;
                        this.secondaryValue = 1;
                        break;
        }
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public int getPrimaryValue() {
        return primaryValue;
    }

    public int getSecondaryValue() {
        return secondaryValue;
    }
}
