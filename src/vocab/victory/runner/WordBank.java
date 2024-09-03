package vocab.victory.runner;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WordBank {

    ArrayList<String> dictionary = new ArrayList<>();
    ArrayList<String> hintLibrary = new ArrayList<>();

    public WordBank(String filename) {
        try {
            File Levelfile = new File(filename);

            Scanner scan = new Scanner(Levelfile);

            while(scan.hasNext()){
                String rootWord= scan.next();
                String rootHint = scan.nextLine();
                dictionary.add(rootWord);
                hintLibrary.add(rootHint);
            }
            scan.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getRandomWord(int index) {
        return dictionary.get(index);
    }
    public String getThatHint(int index) {
        return hintLibrary.get(index);
    }
}