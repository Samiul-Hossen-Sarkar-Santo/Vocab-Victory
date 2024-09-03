/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vocab.victory.runner;

/**
 *
 * @author DELL
 */
public class Guess {

    private char letter;
    private boolean isCorrect;

    public Guess(char letter, boolean isCorrect) {
        this.letter = letter;
        this.isCorrect = isCorrect;
    }

    public char getLetter() {
        return letter;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
