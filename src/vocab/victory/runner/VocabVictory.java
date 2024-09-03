package vocab.victory.runner;

import java.io.IOException;
import java.util.Scanner;

public class VocabVictory {

    public Word word;
    public final StringBuilder guessedLetters;
    public WordBank wordBank;

    public VocabVictory() {
        this.guessedLetters = new StringBuilder();
    }
    SelectLevel select = new SelectLevel();
    Scanner scanner = new Scanner(System.in);
    public double play() throws IOException {
        guessedLetters.setLength(0); // current guesses reset korar jnno

        wordBank= new WordBank(select.levelLocation());
        int index= (int) (Math.random() * wordBank.dictionary.size());
        Word vocabWord = new Word(wordBank.getRandomWord(index));
        this.word= vocabWord;
        int totalAttempts = this.word.getWord().length();
        String hint = wordBank.getThatHint(index);
        vocabWord.setHint(hint);
        int attemptsLeft = totalAttempts;
        int finalGuess;

        while (attemptsLeft > 0 && !vocabWord.isComplete()) {
            System.out.println("\n" + vocabWord.getCurrentState());
            System.out.println("Guessed letters: " + guessedLetters);

            System.out.println("Guesses left: " + attemptsLeft);
            System.out.println("Hint: " + hint);
            System.out.println("Enter your guess (a single letter):");
            char guess = scanner.next().toUpperCase().charAt(0);

            if (guessedLetters.indexOf(String.valueOf(guess)) != -1) {
                System.out.println("You already guessed this letter. Try another one.\n");
                continue;
            }
            guessedLetters.append(guess);
            if (guess=='.') {
                System.out.println("\nYou have left the game.\n");
                break;
            }
            else if (vocabWord.checkGuess(guess)) {
                System.out.println("Correct guess!\n");
            } else {
                attemptsLeft--;
                System.out.println("Incorrect guess! Try again.\n");
            }
        }
        if (vocabWord.isComplete()) {
            System.out.println("\nCongratulations! You have guessed the word.");
            System.out.println("The word was: " + vocabWord.getWord());
            int usedGuess= totalAttempts - attemptsLeft;
            System.out.println("You used " + usedGuess + " guesses.");
            finalGuess= usedGuess;

        } else {
            System.out.println("\nGame over! You have run out of guesses.");
            System.out.println("The word was: " + vocabWord.getWord());
            finalGuess=totalAttempts;
        }
        return (finalGuess*100)/totalAttempts;
    }
}