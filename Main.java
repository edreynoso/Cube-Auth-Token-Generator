
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static final int SCRAMBLE_COUNT = 3000000;

    public static final int CUBESIZE = 3;

    public static void printCube(Cube cube) {
        for (CubeFace f : cube.getFace()) {
            System.out.println("\nFace: " + f.getCenterColor());

            for (int i = 0; i < CUBESIZE; i++) {
                System.out.print("  ");
                for (int j = 0; j < CUBESIZE; j++) {
                    System.out.print(f.get(i, j).getPieceNumber() + " ");
                }
                System.out.println();
            }
        }
    }

    public static Cube setUp() {
        Corner GWR = new Corner(2, 1, Color.GREEN, Color.WHITE, Color.RED);
        Corner GYR = new Corner(5, 2, Color.GREEN, Color.YELLOW, Color.RED);
        Corner GYO = new Corner(7, 3, Color.GREEN, Color.YELLOW, Color.ORANGE);
        Corner GWO = new Corner(11, 4, Color.GREEN, Color.WHITE, Color.ORANGE);

        Corner BWO = new Corner(79, 5, Color.BLUE, Color.WHITE, Color.ORANGE);
        Corner BYO = new Corner(73, 6, Color.BLUE, Color.YELLOW, Color.ORANGE);
        Corner BWR = new Corner(71, 7, Color.BLUE, Color.WHITE, Color.RED);
        Corner BYR = new Corner(17, 8, Color.BLUE, Color.YELLOW, Color.RED);

        Edge GW = new Edge(31, 9, Color.GREEN, Color.WHITE);
        Edge GR = new Edge(41, 10, Color.GREEN, Color.RED);
        Edge GY = new Edge(53, 11, Color.GREEN, Color.YELLOW);
        Edge GO = new Edge(229, 12, Color.GREEN, Color.ORANGE);

        Edge BW = new Edge(199, 13, Color.BLUE, Color.WHITE);
        Edge BO = new Edge(139, 14, Color.BLUE, Color.ORANGE);
        Edge BY = new Edge(151, 15, Color.BLUE, Color.YELLOW);
        Edge BR = new Edge(109, 16, Color.BLUE, Color.RED);

        Edge RW = new Edge(127, 17, Color.RED, Color.WHITE);
        Edge RY = new Edge(167, 18, Color.RED, Color.YELLOW);

        Edge OW = new Edge(67, 19, Color.ORANGE, Color.WHITE);
        Edge OY = new Edge(189, 20, Color.ORANGE, Color.YELLOW);

        Center W = new Center(0, 21, Color.WHITE);
        Center G = new Center(0, 22, Color.GREEN);
        Center R = new Center(0, 23, Color.RED);
        Center O = new Center(0, 24, Color.ORANGE);
        Center B = new Center(0, 25, Color.BLUE);
        Center Y = new Center(0, 26, Color.YELLOW);

        CubePiece[][] greenFace = {
            {GWO, GW, GWR},
            {GO, G, GR},
            {GYO, GY, GYR}
        };
        CubeFace green = new CubeFace(greenFace, Color.GREEN);

        CubePiece[][] redFace = {
            {GWR, RW, BWR},
            {GR, R, BR},
            {GYR, RY, BYR}
        };
        CubeFace red = new CubeFace(redFace, Color.RED);

        CubePiece[][] blueFace = {
            {BYO, BY, BYR},
            {BO, B, BR},
            {BWO, BW, BWR}
        };
        CubeFace blue = new CubeFace(blueFace, Color.BLUE);

        CubePiece[][] orangeFace = {
            {BWO, OW, GWO},
            {BO, O, GO},
            {BYO, OY, GYO}
        };
        CubeFace orange = new CubeFace(orangeFace, Color.ORANGE);

        CubePiece[][] whiteFace = {
            {BWO, BW, BWR},
            {OW, W, RW},
            {GWO, GW, GWR}
        };

        CubeFace white = new CubeFace(whiteFace, Color.WHITE);

        CubePiece[][] yellowFace = {
            {GYO, GY, GYR},
            {OY, Y, RY},
            {BYO, BY, BYR}
        };

        CubeFace yellow = new CubeFace(yellowFace, Color.YELLOW);

        CubeFace[] sides = {green, red, blue, orange, white, yellow};
        Cube cube = new Cube(sides);

        return cube;
    }

    public static void duplicateChecker(Cube cube) {

        int duplicateScrambles = 0;
        int duplicateTokens = 0;
        Set<String> dTokens = new HashSet<>();

        ArrayList<String> scramble;

        Set<String> scrambles = new HashSet<>();
        Set<String> tokens = new HashSet<>();

        for (int i = 0; i < SCRAMBLE_COUNT; i++) {

            scramble = cube.generateScramble();
            String s = String.join(" ", scramble);
            if (scrambles.contains(s)) {
                duplicateScrambles++;
            } else {
                scrambles.add(s);
            }
            cube.scramble(scramble);
            String t = cube.getToken();
            if (tokens.contains(t)) {
                duplicateTokens++;
                dTokens.add(t);
            } else {
                tokens.add(t);
            }
            cube.reset();
        }

        System.out.println("In " + SCRAMBLE_COUNT + " different scrambles generated, there was "
                + duplicateScrambles + " duplicate scambles");
        System.out.println("In " + SCRAMBLE_COUNT + " different tokens generated, there was "
                + duplicateTokens + " duplicate tokens");
        System.out.println("The duplicate tokens found are: " + dTokens);
    }

    public static void demo(Cube cube) {
        ArrayList<String> scramble;

        scramble = cube.generateScramble();
        System.out.println(scramble);

        cube.scramble(scramble);
        printCube(cube);
        cube.reset();
    }

    public static void demoToken(Cube cube) {
        cube.scramble(cube.generateScramble());

        System.out.println(cube.getToken());
        cube.reset();
    }

    public static void main(String[] args) {

        Cube cube = setUp(); //Sets up cube using 6 3x3 matricies with set piece numbers and weights

        //printCube(cube); //Prints the unscrambled cube represented with piece numbers
        //demo(cube); //Will generate one scramble, then print it and print the scrambed cube
        duplicateChecker(cube); //Will check for duplicate scrambles and tokens based on a set number of iterations

        //demoToken(cube); //will print one token generated from the cube
    }
}
