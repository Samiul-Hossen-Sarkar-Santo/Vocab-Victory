package vocab.victory.runner;

import java.io.IOException;
import java.util.Scanner;

public class VocabVictoryRunner {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice = 100;

        while (choice != 0) {
            System.out.println("\nWelcome to Vocab Victory Game!");
            System.out.println("1. Single Player Mode");
            System.out.println("2. Multiplayer Mode");
            System.out.println("3. How to play");
            System.out.println("0. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    SinglePlayer s1= new SinglePlayer();
                    try {
                        s1.play();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.println("""
                            Which mode do you want to play?
                            1. Mode 1
                            2. Mode 2
                            """);
                    int mode= scanner.nextInt();
                    switch (mode){
                        case 1:
                            Multiplayer multiplayerGame = new Multiplayer();
                            multiplayerGame.enterDetails();
                            try {
                                multiplayerGame.winner();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 2:
                            MultiplayerVocabVictory multiPlayerGame = new MultiplayerVocabVictory();
                            multiPlayerGame.play();
                            break;
                    }
                    break;
                case 3:
                    Rules rule = new Rules();
                    rule.readRules();
                    break;
                case 0:
                    System.out.println("Thanks for playing Vocab Victory Game!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}