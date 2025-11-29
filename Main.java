import java.util.ArrayList;

public class Main {
    //Webscrape scrambles from cs timer or other cube scramblers

    /*Might have to create my own scramble generator
      Use an array of set moves, and select indicies at random */
    public static void main(String[] args) {
        ArrayList<String> tokenList = new ArrayList<>();

        Cube test = new Cube();
        String scram = test.generateScramble();
        System.out.println(scram);

        for (int i = 0; i < 100; i++) {
            //Get the tokens in variable, then store into tokenList and compare
        }

    }
}
