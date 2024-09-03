package vocab.victory.runner;

public class Word {

    public String word;
    public String hint;
    public boolean[] guessedLetters;

    public Word(String word) {
        this.word = word;
        this.guessedLetters = new boolean[word.length()];
    }

    public String getWord() {
        return this.word;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public boolean checkGuess(char letter) {
        boolean found = false;
        //CLOCK
        //letter = C
        for (int i = 0; i < this.word.length(); i++) {
            if (this.word.charAt(i) == letter) {
                this.guessedLetters[i] = true;
                found = true;
            }
        }
        return found;
    }

    public boolean isComplete() {
        for (boolean guessedLetter : this.guessedLetters) {
            if (!guessedLetter) {
                return false;
            }
        }
        return true;
    }

    public String getCurrentState() {
        StringBuilder currentState = new StringBuilder();
        for (int i = 0; i < this.word.length(); i++) {
            if (this.guessedLetters[i]) {
                currentState.append(this.word.charAt(i));
            } else {
                currentState.append(" _ ");
            }
        }
        return currentState.toString();
    }
}