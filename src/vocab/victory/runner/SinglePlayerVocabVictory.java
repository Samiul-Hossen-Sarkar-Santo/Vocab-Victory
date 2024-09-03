package vocab.victory.runner;

import java.util.Scanner;

public class SinglePlayerVocabVictory {

    public static void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Vocab Victory!");
        System.out.println("You are playing in single player mode.");
        System.out.println("Enter the word to be guessed:");
        String word = scanner.nextLine().toUpperCase();
        Word vocabWord = new Word(word);
        System.out.println("Enter the hint for the word:");
        String hint = scanner.nextLine();
        vocabWord.setHint(hint);
        int guessesLeft = 6;
        while (guessesLeft > 0 && !vocabWord.isComplete()) {
            System.out.println("\n" + vocabWord.getCurrentState());
            System.out.println("Guesses left: " + guessesLeft);
            System.out.println("Enter your guess (a single letter):");
            char guess = scanner.nextLine().toUpperCase().charAt(0);
            if (!Character.isLetter(guess)) {
                System.out.println("Invalid input! Please enter a letter.");
                continue;
            }
            if (vocabWord.checkGuess(guess)) {
                System.out.println("Correct guess!");
            } else {
                guessesLeft--;
                System.out.println("Incorrect guess! Try again.");
            }
        }
        if (vocabWord.isComplete()) {
            System.out.println("\nCongratulations! You have guessed the word.");
            System.out.println("The word was: " + vocabWord.getWord());
            System.out.println("You used " + (6 - guessesLeft) + " guesses.");
        } else {
            System.out.println("\nGame over! You have run out of guesses.");
            System.out.println("The word was: " + vocabWord.getWord());
        }
        scanner.close();
    }
}