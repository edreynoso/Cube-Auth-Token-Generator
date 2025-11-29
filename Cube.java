import java.util.ArrayList;
public class Cube {

    //Array of length 6, containing all the cube faces
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

    private static final int RIGHT = 2;
    private static final int LEFT = 0;
    private static final int UP = 0;
    private static final int DOWN = 2;

    private CubeFace[] face = new CubeFace[6];

    private static final String[] MOVES = {"U", "R", "L", "F", "B", "D"};

    private static final String[] MODIFIERS = {"", "'", "2"};

    public Cube(CubeFace[] face) {
        this.face = face;
    }


    public Cube() {
    }

    public CubeFace[] getFace(){return this.face;}

    public void scramble(ArrayList<String> scramble) {
        //Scramble the cube using a custom

        for (String move: scramble){
            //System.out.println(move);
            switch(move){
                case "R":right(); break;
                case "R'": right(); right(); right(); break;
                case "R2": right(); right(); break;
                case "L": left(); break;
                case "L'": left(); left(); left(); break;
                case "L2": left(); left(); break;
                case "U": up(); break;
                case "U'": up(); up(); up(); break;
                case "U2": up(); up(); break;
                case "D": down(); break;
                case "D2": down(); down(); break;
                case "D'": down(); down(); down();break;
                case "F": front(); break;
                case "F2": front(); front(); break;
                case "F'": front(); front(); front(); break;
                case "B": back(); break;
                case "B2": back(); back(); break;
                case "B'": back(); back(); back(); break;
            }
        }

    }

    public void right(){

        CubeFace greenFace = face[GREEN];
        CubeFace redFace = face[RED];
        CubeFace blueFace = face[BLUE];
        CubeFace whiteFace = face[WHITE];
        CubeFace yellowFace = face[YELLOW];

        CubePiece[] gCol = greenFace.getCol(RIGHT);
        CubePiece[] wCol = whiteFace.getCol(RIGHT);
        CubePiece[] yCol = yellowFace.getCol(RIGHT);
        CubePiece[] bCol = blueFace.getCol(RIGHT);


        whiteFace.setCol(RIGHT, gCol);
        blueFace.setCol(RIGHT, wCol);
        yellowFace.setCol(RIGHT, bCol);
        greenFace.setCol(RIGHT, yCol);

        redFace.rotateCW();

    }


    public void left(){
        CubeFace greenFace = face[GREEN];
        CubeFace orangeFace = face[ORANGE];
        CubeFace blueFace = face[BLUE];
        CubeFace whiteFace = face[WHITE];
        CubeFace yellowFace = face[YELLOW];

        CubePiece[] gCol = greenFace.getCol(LEFT);
        CubePiece[] wCol = whiteFace.getCol(LEFT);
        CubePiece[] yCol = yellowFace.getCol(LEFT);
        CubePiece[] bCol = blueFace.getCol(LEFT);


        whiteFace.setCol(LEFT, bCol);
        blueFace.setCol(LEFT, yCol);
        yellowFace.setCol(LEFT, gCol);
        greenFace.setCol(LEFT, wCol);

        orangeFace.rotateCW();
    }

    public void up() {
        CubeFace greenFace = face[GREEN];
        CubeFace redFace = face[RED];
        CubeFace blueFace = face[BLUE];
        CubeFace whiteFace = face[WHITE];
        CubeFace orangeFace = face[ORANGE];

        CubePiece[] gRow = greenFace.getRow(UP);
        CubePiece[] rRow = redFace.getRow(UP);
        CubePiece[] oRow = orangeFace.getRow(UP);
        CubePiece[] bRow = blueFace.getRow(DOWN);

        CubePiece[] rev_b = {bRow[2], bRow[1], bRow[0]};
        CubePiece[] rev_o = {oRow[2], oRow[1], oRow[0]};

        greenFace.setRow(UP, rRow);
        redFace.setRow(UP, rev_b);
        blueFace.setRow(DOWN, rev_o);
        orangeFace.setRow(UP, gRow);

        whiteFace.rotateCW();
    }


    public void down(){
        CubeFace greenFace = face[GREEN];
        CubeFace redFace = face[RED];
        CubeFace blueFace = face[BLUE];
        CubeFace yellowFace = face[YELLOW];
        CubeFace orangeFace = face[ORANGE];

        CubePiece[] gRow = greenFace.getRow(DOWN);
        CubePiece[] rRow = redFace.getRow(DOWN);
        CubePiece[] oRow = orangeFace.getRow(DOWN);
        CubePiece[] bRow = blueFace.getRow(UP);

        CubePiece[] rev_b = {bRow[2], bRow[1], bRow[0]};
        CubePiece[] rev_r = {rRow[2], rRow[1], rRow[0]};

        greenFace.setRow(DOWN, oRow);
        redFace.setRow(DOWN, gRow);
        blueFace.setRow(UP, rev_r);
        orangeFace.setRow(DOWN, rev_b);

        yellowFace.rotateCW();
    }

    public void front(){
        /*
            orange = right col
            white = bottom row
            red = left col
            yellow = top row
            green = rotate cw
         */
        CubeFace greenFace = face[GREEN];
        CubeFace redFace = face[RED];
        CubeFace yellowFace = face[YELLOW];
        CubeFace whiteFace = face[WHITE];
        CubeFace orangeFace = face[ORANGE];

        CubePiece[] rCol = redFace.getCol(LEFT);
        CubePiece[] oCol = orangeFace.getCol(RIGHT);
        CubePiece[] wRow = whiteFace.getRow(DOWN);
        CubePiece[] yRow = yellowFace.getRow(UP);

        CubePiece[] rev_r = {rCol[2], rCol[1], rCol[0]};
        CubePiece[] rev_o = {oCol[2], oCol[1], oCol[0]};

        whiteFace.setRow(DOWN, rev_o);
        redFace.setCol(LEFT, wRow);
        yellowFace.setRow(UP, rev_r);
        orangeFace.setCol(RIGHT, yRow);

        greenFace.rotateCW();
    }

    public void back(){
        CubeFace blueFace = face[BLUE];
        CubeFace redFace = face[RED];
        CubeFace yellowFace = face[YELLOW];
        CubeFace whiteFace = face[WHITE];
        CubeFace orangeFace = face[ORANGE];

        CubePiece[] rCol = redFace.getCol(RIGHT);
        CubePiece[] oCol = orangeFace.getCol(LEFT);
        CubePiece[] wRow = whiteFace.getRow(UP);
        CubePiece[] yRow = yellowFace.getRow(DOWN);

        CubePiece[] rev_y = {yRow[2], yRow[1], yRow[0]};
        CubePiece[] rev_w = {wRow[2], wRow[1], wRow[0]};

        whiteFace.setRow(UP, rCol);
        redFace.setCol(RIGHT, rev_y);
        yellowFace.setRow(DOWN, oCol);
        orangeFace.setCol(LEFT, rev_w);

        blueFace.rotateCW();
    }


    public String getToken() {
        StringBuilder token = new StringBuilder();

        ArrayList<String> cubeScramble = generateScramble();

        this.scramble(cubeScramble);

        for (CubeFace face : this.face) {
            String k = face.hash_face(face);
            token.append(k);
        }

        return token.toString();
    }

    public ArrayList<String> generateScramble() {

        ArrayList<String> scramble = new ArrayList<>();

        String last_move = "P";

        for (int i = 0; i < 25; i++) {
            String move = "";

            do {
                int idx = (int) (Math.random() * MOVES.length);
                move = MOVES[idx];
            } while (move.equals(last_move));

            int idx = (int) (Math.random() * MODIFIERS.length);
            String mod = MODIFIERS[idx];
            move = move + mod;
            if (move.charAt(0) != last_move.charAt(0)) {
                scramble.add(move);
                last_move = move;
                //System.out.println(last_move);
            }
        }
        return scramble;
    }
}
