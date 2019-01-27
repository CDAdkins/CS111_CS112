/*
 * Chris Adkins, May 19, 2018
 * CS111, Les Russell
 * Final Project
 */

import java.io.File;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * This class handles the collection of players that the program may or may not have.
 * It, depending on the player, will add and edit the value of players to the relevant text file.
 */

public class Players {

    private File temp = new File("temp.txt"); // Used to "save" over the "player.txt" file.
    private File playersFile = new File ("player.txt");
    private Player[] players = new Player[100];
    private Scanner fileInput = new Scanner(System.in);
    private Player player;
    private PrintWriter printWriter;

    private boolean newPlayer = false;


    public Player addPlayer() { // Adds a new player to the temporary file.

        newPlayer = true;

        Player addedPlayer = null;

        String playerName;
        String playerId;
        int    bankroll = 3000;
        
        try {
            printWriter = new PrintWriter(temp);

            System.out.println("Enter your name");
            playerName = fileInput.nextLine();

            System.out.println("Enter your player ID (e.g. Cheesecake99)");
            playerId = fileInput.nextLine();

            System.out.println("New player created");

            printWriter.print("n ");
            printWriter.println(playerName);
            printWriter.print("i ");
            printWriter.println(playerId);
            printWriter.print("b ");
            printWriter.println(bankroll);

            printWriter.flush();
            printWriter.close();

            for (int ndx = 0; ndx < players.length; ndx++) {
                if (players[ndx] == null) {
                    players[ndx] = new Player(playerName, playerId, bankroll);
                    addedPlayer = new Player(playerName, playerId, bankroll);
                    break;
                }
            }
            
        } catch(FileNotFoundException e) {
            System.out.println("Can't find file");
        }
        player = addedPlayer;
        return addedPlayer;
    }

    public void loadPlayers() {

        String playerName;
        String playerId;
        int bankroll;

        try {
            Scanner inputStream = new Scanner(new FileInputStream(playersFile));

            if (!inputStream.hasNext()) {
                System.out.println("No players found");
            }

            while (inputStream.hasNext()) {
                while (inputStream.next().equals("n")) {
                    playerName = inputStream.nextLine();

                    if (inputStream.next().equals("i")) {
                        playerId = inputStream.nextLine();

                        if (inputStream.next().equals("b")) {
                            bankroll = inputStream.nextInt();

                            for (int ndx = 0; ndx < players.length; ndx++) {
                                if (players[ndx] == null) {
                                    players[ndx] = new Player(playerName, playerId, bankroll);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file, creating new file");
        }
    }

    public void savePlayers() {
        try {
            printWriter = new PrintWriter(temp);
            Scanner inputStream = new Scanner(new FileInputStream(playersFile));
            String currentId;

            while (inputStream.hasNext()) {
                if (inputStream.next().equals("n")) {
                    printWriter.print("n");
                    printWriter.println(inputStream.nextLine());

                    printWriter.print(inputStream.next());
                    currentId = inputStream.nextLine();
                    printWriter.println(currentId);

                    printWriter.print(inputStream.next());

                    if (currentId.equals(player.getPlayerId())) {
                        printWriter.println(" " + player.getBankroll());
                    } else {
                        printWriter.println(inputStream.nextLine());
                    }
                }
            }
            if (newPlayer) {
                printWriter.print("n ");
                printWriter.println(player.getPlayerName());
                printWriter.print("i ");
                printWriter.println(player.getPlayerId());
                printWriter.print("b ");
                printWriter.println(player.getBankroll());
            }
            inputStream.close();
            printWriter.close();

            playersFile.delete();

            temp.renameTo(playersFile);


        } catch(FileNotFoundException e) {
            System.out.println("Can't find File");
        }

    }

    public Player[] getPlayers() {
        return players;
    }

    public void setCurrentPlayer(Player player) {
        this.player = player;
    }
    
    public void start() {
        try{
            printWriter = new PrintWriter(playersFile);
            
            printWriter.print("n ");
            printWriter.println("TestManuel");
            printWriter.print("i ");
            printWriter.println("TestMan");
            printWriter.print("b ");
            printWriter.println(3000);
            System.out.println("done");
            
        } catch(FileNotFoundException e) {
            System.out.println("Can't find file");
        }
        
    }

}
