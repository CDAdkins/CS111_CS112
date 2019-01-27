/*
 * Chris Adkins, May 19, 2018
 * CS111, Les Russell
 * Final Project
 *
 * This is a Blackjack program that allows you to play Blackjack. It also supports multiple characters with their own bankrolls that should carry between games.
 */
import java.util.Scanner;

/*
 * This class calls the methods from the other classes and does most of the interaction with the user.
 * It begins by loading the characters it already has. 
 * Then it asks if the player wants to make a new character.
 * The player is asked how much they'd like to bet.
 * It asks if the player would like to shuffle.
 * Then the program runs through the game, asking the player how they want to play the hand.
 * Once the player is done the program assesses the dealer's hand and decides what they should do.
 * The program then decides who wins and allocates the winnings/loss to the bankroll of the player.
 */

public class BlackJackDriver {

    public static void main(String args[]) {
        Scanner userInput      = new Scanner(System.in);
        Blackjack game         = new Blackjack();
        String userSelection   = null;
        
        game.getPlayers().start();
        
        int gamesPlayed = 0;

        game.getPlayers().loadPlayers();

        if (game.getPlayers().getPlayers()[0] == null) {
            game.setPlayer(game.getPlayers().addPlayer());
            game.getPlayers().setCurrentPlayer(game.getPlayer());
        } else {
            game.listPlayers();
            System.out.println("Would you like to create a new player? [y/n]");
            if (userInput.nextLine().toUpperCase().equals("Y")) {
                game.setPlayer(game.getPlayers().addPlayer());
                game.getPlayers().setCurrentPlayer(game.getPlayer());
            }
            System.out.println("Type the ID of the player you want");
            game.selectPlayer(userInput.nextLine());
        }


        do {
            if (gamesPlayed > 0) {
                System.out.println("Would you like to shuffle the deck? [y/n]");
                if (userInput.nextLine().toUpperCase().equals("Y")) {
                        game.getCardDeck().shuffle();
                }
            } else {
                game.getCardDeck().shuffle();
            }
                
            gamesPlayed++;

            System.out.println("Your Bankroll is $" + game.getPlayer().getBankroll());
            System.out.println("What would you like to bet?");
            game.setBet(userInput.nextInt());

            game.play();
            if (game.getPlayerHand().playHand() == 1) {
                System.out.println();
                System.out.println("Bust, Dealer Wins");
                game.getPlayer().updateBankroll(-game.getBet());
            } else if (game.getPlayerHand().playHand() == 2) {
                System.out.println("[hit/stand]");
                System.out.println();
                userSelection = userInput.nextLine().toUpperCase();
                userSelection = userInput.nextLine().toUpperCase();
                if (userSelection.equals("STAND")) {
                } else if (userSelection.equals("HIT")) {
                    while(userSelection.equals("HIT")) {
                        game.getCardDeck().dealCard();
                        game.getPlayerHand().addCard(game.getCardDeck().getNextCard());
                        game.getCardDeck().deleteCard();
                        game.displayHand(game.getPlayerHand().getHand());
                        if (game.getPlayerHand().getHandValue() > 21) {
                            System.out.println();
                            System.out.println("Bust, Dealer Wins");
                            game.getPlayer().updateBankroll(-game.getBet());
                            break;
                        } else if (game.getPlayerHand().getHandValue() == 21) {
                            System.out.println("Blackjack!");
                            break;
                        } else {
                            System.out.println();
                            System.out.println("[hit/stand]");
                            System.out.println();
                            userSelection = userInput.nextLine().toUpperCase();
                            if (userSelection.equals("STAND")) {
                                break;
                            }
                        }
                    }
                }
            }

            if (userSelection != null && game.getPlayerHand().getHandValue() <= 21) {

                while (game.getDealerHand().playHand() != 0 && game.getDealerHand().playHand() != 1) {
                    System.out.println();
                    System.out.println("Dealer Hits");
                    System.out.println();
                    game.getCardDeck().dealCard();
                    game.getDealerHand().addCard(game.getCardDeck().getNextCard());
                    game.getCardDeck().deleteCard();
                    game.displayHand(game.getDealerHand().getHand());
                }

                if (game.getDealerHand().playHand() == 0) {
                    System.out.println();
                    System.out.println("Dealer Stands");
                    game.displayHand(game.getDealerHand().getHand());

                    if (game.getDealerHand().getHandValue() > game.getPlayerHand().getHandValue()) {
                        System.out.println();
                        System.out.println("Dealer Wins");
                        game.getPlayer().updateBankroll(-game.getBet());
                    } else if (game.getDealerHand().getHandValue() == game.getPlayerHand().getHandValue()) {
                        System.out.println();
                        System.out.println("Push");
                    } else {
                        System.out.println();
                        System.out.println("You Win");
                        game.getPlayer().updateBankroll(game.getBet());
                    }
                } else if (game.getDealerHand().playHand() == 1) {
                    game.displayHand(game.getDealerHand().getHand());
                    System.out.println();
                    System.out.println("Dealer Busts, You Win");
                    game.getPlayer().updateBankroll(game.getBet());
                }

            }

            System.out.println();
            System.out.println("Would you like to play another hand? [y/n]");
        } while (userInput.nextLine().toUpperCase().equals("Y"));

        game.getPlayers().savePlayers();
        System.out.println("Thank You For Playing!");
    }
    
}