/*
 * Chris Adkins, May 19, 2018
 * CS111, Les Russell
 * Final Project
 */
 
 /*
  * This class handles the initial dealing of the cards.
  * It also handles the interactions between the user and their hand.
  * The auto shuffle function as well as some interaction between the user and their player is handled by this class.
  */

public class Blackjack {

    private CardDeck   cardDeck   = new CardDeck();
    private PlayerHand playerHand = new PlayerHand();
    private DealerHand dealerHand = new DealerHand();
    private Players    players    = new Players();
    private Player     player;

    private int bet = 0;

    public void play() {

        cardDeck.shuffleAuto();

        getDealerHand().resetHand();
        getPlayerHand().resetHand();

        cardDeck.dealCard();
        playerHand.addCard(cardDeck.getNextCard());
        cardDeck.deleteCard();
        cardDeck.dealCard();
        dealerHand.addCard(cardDeck.getNextCard());
        cardDeck.deleteCard();
        cardDeck.dealCard();
        playerHand.addCard(cardDeck.getNextCard());
        cardDeck.deleteCard();
        cardDeck.dealCard();
        dealerHand.addCard(cardDeck.getNextCard());
        cardDeck.deleteCard();

        displayHand(dealerHand.getHand());
        displayHand(playerHand.getHand());

        System.out.println();
    }

    public void listPlayers() {
        System.out.println("Available Players:");
        for (int ndx = 0; ndx < players.getPlayers().length; ndx ++) {
            if (players.getPlayers()[ndx] != null) {
                System.out.print(players.getPlayers()[ndx].getPlayerId());
                System.out.println(" ($" + players.getPlayers()[ndx].getBankroll() + ")");
            }
        }
    }

    public Player selectPlayer(String playerId) { //Searches through the known players for the playerId searched by the user, returns that player.

        for (int ndx = 0; ndx < players.getPlayers().length; ndx++) {
            if (players.getPlayers()[ndx] != null) {
                if (players.getPlayers()[ndx].getPlayerId().equals(" " + playerId)) {
                    player = players.getPlayers()[ndx];
                    System.out.println("PlayerFound");
                    System.out.println(player.getBankroll());
                    break;
                }
            }
        }
        System.out.println(player.getPlayerName());
        getPlayers().setCurrentPlayer(player);
        return player;
    }

    public void displayHand(Card[] hand) {

        if (hand == playerHand.getHand()) {
            System.out.println();
            System.out.println("Your Hand: ");

            for (int ndx = 0; ndx < hand.length; ndx ++) {
                if (hand[ndx] != null) {
                    System.out.print(hand[ndx].getRank());
                    System.out.print(" of ");
                    System.out.println(hand[ndx].getSuit());
                }
            }
        } else if (hand == dealerHand.getHand()) {
            System.out.println();
            System.out.println("Dealer's Hand: ");
            if (dealerHand.isHoleCardHidden()) {
                for (int ndx = 0; ndx < hand.length; ndx++) {
                    if (hand[ndx] != null && ndx != 1) {
                        System.out.print(hand[ndx].getRank());
                        System.out.print(" of ");
                        System.out.println(hand[ndx].getSuit());
                    }
                    else if (hand[ndx] != null && ndx == 1 && dealerHand.isHoleCardHidden()) {
                        System.out.println("?");
                    }
                }
            } else if (!dealerHand.isHoleCardHidden()) {
                for (int ndx = 0; ndx < hand.length; ndx++) {
                    if (hand[ndx] != null) {
                        System.out.print(hand[ndx].getRank());
                        System.out.print(" of ");
                        System.out.println(hand[ndx].getSuit());
                    }
                }
            }
        }

        System.out.print("Hand Value: ");
        if (hand == playerHand.getHand()) {
            System.out.println(playerHand.getHandValue());
        } else if (hand == dealerHand.getHand() && !dealerHand.isHoleCardHidden()) {
            System.out.println(dealerHand.getHandValue());
        } else if (hand == dealerHand.getHand() && dealerHand.isHoleCardHidden()) {
            System.out.println("?");
        }
    }

    public CardDeck getCardDeck() {
        return cardDeck;
    }

    public PlayerHand getPlayerHand() {
        return playerHand;
    }

    public DealerHand getDealerHand() {
        return dealerHand;
    }

    public Players getPlayers() {
        return players;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getBet() {
        return this.bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

}
