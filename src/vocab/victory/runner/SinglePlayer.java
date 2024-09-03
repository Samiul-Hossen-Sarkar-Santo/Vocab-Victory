package vocab.victory.runner;

import java.io.IOException;

public class SinglePlayer extends VocabVictory{
    
    public SinglePlayer() {
        super();
    }
    @Override
    public double play() throws IOException {
        System.out.println("\nWelcome to Vocab Victory, Single Player mode.");
        return super.play();
    }
}