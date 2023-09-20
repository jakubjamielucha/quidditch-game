package src.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static Game game;
    static final String TEAMS_FILE = "src/main/teams.txt";
    static final String PLAYS_FILE = "src/main/plays.txt";

    public static void main(String[] args) {
        try{
            String data[][] = getData();
            game = new Game(
                    new Team(data[0][0], data[0][1], data[0][2], new String[] {data[0][3], data[0][4], data[0][5]}),
                    new Team(data[1][0], data[1][1], data[1][2], new String[] {data[1][3], data[1][4], data[1][5]})
            );
            startGame();
            printResult();
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public static String[][] getData() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(TEAMS_FILE);
        Scanner scanner = new Scanner(fis);
        String[] lines = new String[] {scanner.nextLine(), scanner.nextLine()};
        scanner.close();
        return new String[][]{
                lines[0].split(","), lines[1].split(",")
        };
    }

    public static void startGame() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(PLAYS_FILE);
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNextLine()){
            System.out.println("\n" + game.simulate(scanner.nextLine()) + "\n");
        }
        scanner.close();
    }

    public static void printResult(){
        Team gryffindor = game.getTeam("GRYFFINDOR");
        Team slytherin = game.getTeam("SLYTHERIN");
        Team winner = game.getScore(gryffindor) > game.getScore(slytherin) ? gryffindor : slytherin;
        System.out.println("\nGRYFFINDOR: " + game.getScore(gryffindor) +
                " SLYTHERIN: " + game.getScore(slytherin));
        System.out.println("\n" + winner.getHouse() + " WINS!");
    }

}
