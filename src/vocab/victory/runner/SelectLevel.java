package vocab.victory.runner;

import java.util.Scanner;

public class SelectLevel {

    public String levelLocation(){
        Scanner input = new Scanner(System.in);
        /* multi-line string literal in Java, which was introduced in Java 15 */
        System.out.println("""
                Which Level you want to play?
                1. Easy
                2. Intermediate
                3. Challenging
                4. Difficult
                5. Expert""");
        int level= input.nextInt();
        String levelName= "";
        switch (level){
            case 1:
                levelName = ("Level1.txt");
                break;
            case 2:
                levelName = ("Level2.txt");
                break;
            case 3:
                levelName = ("Level3.txt");
                break;
            case 4:
                levelName = ("Level4.txt");
                break;
            case 5:
                levelName = ("Level5.txt");
                break;
            default:
                System.out.println("Invalid input.");
        }
        return levelName;
    }
}