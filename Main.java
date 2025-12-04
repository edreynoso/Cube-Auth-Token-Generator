
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
                    System.out.print(f.get(i, j).getPieceColor() + " ");
                }
                System.out.println();
            }
        }
    }

    public static Cube setUp() {
        int[] primes = {131, 19, 107, 101, 149, 13, 23, 103, 151, 163, 109, 173, 59, 191, 79,
            7, 17, 3, 211, 41, 167, 137, 199, 181, 197, 89, 5, 113, 47, 139, 43, 67, 71, 193, 29,
            61, 83, 157, 11, 179, 73, 53, 31, 223, 127, 2, 97, 37};

        CubePiece[][] greenSide = new CubePiece[CUBESIZE][CUBESIZE];
        CubePiece[][] whiteSide = new CubePiece[CUBESIZE][CUBESIZE];
        CubePiece[][] orangeSide = new CubePiece[CUBESIZE][CUBESIZE];
        CubePiece[][] redSide = new CubePiece[CUBESIZE][CUBESIZE];
        CubePiece[][] blueSide = new CubePiece[CUBESIZE][CUBESIZE];
        CubePiece[][] yellowSide = new CubePiece[CUBESIZE][CUBESIZE];

        int n = 0;
        int k = 0;
        for (int i = 0; i < CUBESIZE; i++) {
            for (int j = 0; j < CUBESIZE; j++) {
                CubePiece piece;
                if (j == 1 && i == 1) {
                    piece = new CubePiece(0, n, Color.GREEN);
                } else {
                    piece = new CubePiece(primes[k], n, Color.GREEN);
                    k++;
                }

                greenSide[i][j] = piece;
                n++;
            }

        }

        for (int i = 0; i < CUBESIZE; i++) {
            for (int j = 0; j < CUBESIZE; j++) {
                CubePiece piece;
                if (j == 1 && i == 1) {
                    piece = new CubePiece(0, n, Color.RED);
                } else {
                    piece = new CubePiece(primes[k], n, Color.RED);
                    k++;
                }

                redSide[i][j] = piece;
                n++;
            }
        }

        for (int i = 0; i < CUBESIZE; i++) {
            for (int j = 0; j < CUBESIZE; j++) {
                CubePiece piece;
                if (j == 1 && i == 1) {
                    piece = new CubePiece(0, n, Color.BLUE);
                } else {
                    piece = new CubePiece(primes[k], n, Color.BLUE);
                    k++;
                }

                blueSide[i][j] = piece;
                n++;
            }
        }

        for (int i = 0; i < CUBESIZE; i++) {
            for (int j = 0; j < CUBESIZE; j++) {
                CubePiece piece;
                if (j == 1 && i == 1) {
                    piece = new CubePiece(0, n, Color.ORANGE);
                } else {
                    piece = new CubePiece(primes[k], n, Color.ORANGE);
                    k++;
                }

                orangeSide[i][j] = piece;
                n++;
            }
        }

        for (int i = 0; i < CUBESIZE; i++) {
            for (int j = 0; j < CUBESIZE; j++) {
                CubePiece piece;
                if (j == 1 && i == 1) {
                    piece = new CubePiece(0, n, Color.WHITE);
                } else {
                    piece = new CubePiece(primes[k], n, Color.WHITE);
                    k++;
                }

                whiteSide[i][j] = piece;
                n++;
            }
        }

        for (int i = 0; i < CUBESIZE; i++) {
            for (int j = 0; j < CUBESIZE; j++) {
                CubePiece piece;
                if (j == 1 && i == 1) {
                    piece = new CubePiece(0, n, Color.YELLOW);
                } else {
                    piece = new CubePiece(primes[k], n, Color.YELLOW);
                    k++;
                }

                yellowSide[i][j] = piece;
                n++;
            }
        }

        CubeFace white = new CubeFace(whiteSide, Color.WHITE);
        CubeFace green = new CubeFace(greenSide, Color.GREEN);
        CubeFace orange = new CubeFace(orangeSide, Color.ORANGE);
        CubeFace red = new CubeFace(redSide, Color.RED);
        CubeFace blue = new CubeFace(blueSide, Color.BLUE);
        CubeFace yellow = new CubeFace(yellowSide, Color.YELLOW);

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
        demo(cube); //Will generate one scramble, then print it and print the scrambed cube
        //duplicateChecker(cube); //Will check for duplicate scrambles and tokens based on a set number of iterations
        //demoToken(cube); //will print one token generated from the cube
    }
}
