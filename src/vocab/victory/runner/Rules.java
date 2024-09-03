package vocab.victory.runner;

import java.io.File;
import java.util.Scanner;

public class Rules {


    void readRules(){
        try {
            File ruleBook = new File("Rules.txt");
            Scanner scan = new Scanner(ruleBook);
            while (scan.hasNext()){
                System.out.println(scan.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e);;
        }
    }

}
