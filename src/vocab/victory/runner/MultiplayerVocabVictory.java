package vocab.victory.runner;

import java.util.Scanner;

public class MultiplayerVocabVictory {

    public Word word;
    public String playerName1, playerName2;
    public boolean isPlayer1Turn;
    SelectLevel select = new SelectLevel();

    public void play() {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("\nWelcome to Vocab Victory, Multiplayer Mode 2!");

        System.out.print("Enter name for Player 1: ");
        playerName1 = inputScanner.nextLine();
        System.out.print("Enter name for Player 2: ");
        playerName2 = inputScanner.nextLine();

        WordBank wordBank= new WordBank(select.levelLocation());
        int index= (int) (Math.random() * wordBank.dictionary.size());
        Word vocabWord = new Word(wordBank.getRandomWord(index));
        this.word= vocabWord;
        String hint = wordBank.getThatHint(index);
        vocabWord.setHint(hint);

        isPlayer1Turn = true;

        while ( !word.isComplete()) {

            System.out.println("\nCurrent state: " + word.getCurrentState());
            System.out.println("Hint: " + hint);

            char guessLetter;

            String turnPrompt;
            if (isPlayer1Turn)
                turnPrompt = playerName1 + ", enter your guess: ";
            else
                turnPrompt = playerName2 + ", enter your guess: ";
            System.out.print(turnPrompt);

            guessLetter = inputScanner.nextLine().toUpperCase().charAt(0);

            if (guessLetter=='.') {
                String endingPrompt;
                if (isPlayer1Turn)
                    endingPrompt = "\n" + playerName1 + " have left the Game.\n" + "\t" + playerName2 + " wins.\n";
                else
                    endingPrompt = "\n" + playerName2 + " have left the Game.\n" + "\t" + playerName1 + " wins.\n";
                System.out.println(endingPrompt);
                break;
            }

            boolean isGuessCorrect = word.checkGuess(guessLetter);

            if(isGuessCorrect) {
                System.out.println("Correct guess!");
            } else {
                System.out.println("Incorrect guess!");
            }
            isPlayer1Turn = !isPlayer1Turn;
        }

        if (word.isComplete()) {
            System.out.println("\nCongratulations, " + (isPlayer1Turn ? playerName2 : playerName1) + "! You win!");
        }
    }
}