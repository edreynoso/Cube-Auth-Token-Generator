import java.util.Arraylist;
public class Cube {

    //Array of length 6, containing all of the cube faces
    /*Array Indexing is set and specific
        0 = Green
        1 = Red
        2 = Blue
        3 = Orange
        4 = White
        5 = Yellow
     */

    private static final int GREEN = 0;
    private static final int RED = 1;
    private static final int BLUE = 2;
    private static final int ORANGE = 3;
    private static final int WHITE = 4;
    private static final int YELLOW = 5;

    private CubeFace[] face = new CubeFace[6];

    private static final String[] MOVES = {"U", "R", "L", "F", "B", "D"};

    private static final String[] MODIFIERS = {"", "'", "2"};

    public Cube(CubeFace[] face) {
        this.face = face;
    }

    public Cube() {
    }

    public void scramble(String scramble) {
        //Scramble the cube using a custom algo

    }

    public CubeFace[] right(Cube cube) {
        CubeFace greenFace = cube.face[GREEN];
        CubeFace whiteFace = cube.face[WHITE];
        CubeFace blueFace = cube.face[BLUE];
        CubeFace redFace = cube.face[RED];
        CubeFace yellowFace = cube.face[YELLOW];

        int rightCol = 2;
        
        
    }

    public CubeFace[] left(Cube cube) {

    }

    public CubeFace[] down(cube cube) {

    }

    public CubeFace[] up(Cube cube) {

    }

    public CubeFace[] back(Cube cube) {

    }

    public CubeFace[] front(Cube cube) {

    }

    public String getToken(Cube cube) {
        StringBuilder token = new StringBuilder();

        String cubeScramble = generateScramble();

        cube.scramble(cubeScramble);

        for (CubeFace face : cube.face) {
            String k = face.hash_face(face);
            token.append(k);
        }

        return token.toString();
    }

    public ArrayList<String> generateScramble() {

        ArrayList<String> scramble = new ArrayList<>();

        String last_move = null;

        for (int i = 0; i < 25; i++) {
            String move = "";

            do {
                int idx = (int) (Math.random() * MOVES.length);
                move = MOVES[idx];
            } while (move.equals(last_move));

            int idx = (int) (Math.random() * MODIFIERS.length);
            String mod = MODIFIERS[idx];
            if (!(move.equals(last_move))) {
                scramble.append(move);
                scramble.append(mod);
                scramble.append(" ");
                last_move = move;
                //System.out.println(last_move);
            }
        }
        return scramble
    }
}
