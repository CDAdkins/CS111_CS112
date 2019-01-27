/*
 * Chris Adkins, May 19, 2018
 * CS111, Les Russell
 * Final Project
 */

// Just the class for every player, includes the name, ID, and bankroll.

public class Player {
    private String playerName;
    private String playerId;
    private int    bankroll;

    public void updateBankroll(int winnings) {
        this.bankroll += winnings;
    }
    
    public Player(String playerName, String playerId, int bankroll) {
        this.playerName = playerName;
        this.playerId = playerId;
        this.bankroll = bankroll;
    }

    public String getPlayerName() {
        return this.playerName;
    }
    public String getPlayerId() {
        return this.playerId;
    }

    public int getBankroll() {
        return this.bankroll;
    }
}