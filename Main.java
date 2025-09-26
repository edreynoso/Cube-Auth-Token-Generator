
public class Main {
    //Webscrape scrambles from cs timer or other cube scramblers

    /*Might have to create my own scramble generator
      Use an array of set moves, and select indicies at random */
    public static void main(String[] args) {

        Cube test = new Cube();
        String scram = test.generateScramble();
        System.out.println(scram);
    }
}
