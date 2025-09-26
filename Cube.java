
public class Cube {

    //Array of length 6, containing all of the cube faces
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

    public String getToken(Cube cube) {
        StringBuilder token = new StringBuilder();

        for (CubeFace face : cube.face) {
            String k = face.hash_token(face);
            token.append(k);
        }

        return token.toString();
    }

    public String generateScramble() {

        StringBuilder scramble = new StringBuilder();

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
                System.out.println(last_move);
            }
        }
        return scramble.toString();
    }
}
