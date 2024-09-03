package vocab.victory.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Multiplayer extends VocabVictory{
    
    public Multiplayer() {
        super();
    }
    int totalPlayers;
    ArrayList <String> players= new ArrayList<>();
    public void enterDetails(){
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("\nWelcome to Vocab Victory, Multiplayer Mode 1!");

        // Get player names
        System.out.println("Enter total number of players: ");
        totalPlayers= inputScanner.nextInt();

        for(int i=0; i<totalPlayers; i++){
            System.out.print("Enter name for Player " + (i+1) + ": ");
            String player = inputScanner.next();
            players.add(i, player);
        }
    }

    ArrayList<Double> finalGuess = new ArrayList<>();
    public void winner() throws IOException {
        for(int i=0; i< totalPlayers; i++){
            System.out.println("\n\n" + players.get(i) + "'s turn: ");
            finalGuess.add(super.play());
        }
        double smallest = Collections.min(finalGuess);
        int smallestIndex = finalGuess.indexOf(smallest);
        String winner = players.get((smallestIndex));

        System.out.println("\nThe winner of this game is " + winner + ".\n");
    }
}
